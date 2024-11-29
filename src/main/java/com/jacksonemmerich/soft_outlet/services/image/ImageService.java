package com.jacksonemmerich.soft_outlet.services.image;

import com.jacksonemmerich.soft_outlet.dto.ImageDto;
import com.jacksonemmerich.soft_outlet.exceptions.ResourceNotFoundException;
import com.jacksonemmerich.soft_outlet.model.Image;
import com.jacksonemmerich.soft_outlet.model.Product;
import com.jacksonemmerich.soft_outlet.repository.ImageRepository;
import com.jacksonemmerich.soft_outlet.services.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService {

    private final ImageRepository imageRepository;
    private final IProductService productService;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No image found with id: " + id));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete,
                () -> {throw new ResourceNotFoundException("Image not found");});
    }

    @Override
    public List<ImageDto>  saveImages(List<MultipartFile> files, Long productId) {
        Product product = productService.getProductById(productId);
        List<ImageDto> savedImagesDtos = new ArrayList<>();
        for (MultipartFile file : files) {
            Image image = new Image();
            try {
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImage(new SerialBlob(file.getBytes()));
                image.setDownloadUrl(file.getOriginalFilename());
                image.setProduct(product);

                String buildDownloadUrl = "/api/v1/image/download/";
                String downloadUrl = buildDownloadUrl + image.getId();
                image.setDownloadUrl(downloadUrl);
                Image savedImage = imageRepository.save(image);

                savedImage.setDownloadUrl(buildDownloadUrl + savedImage.getId());
                imageRepository.save(savedImage);

                ImageDto imageDto = new ImageDto();
                imageDto.setImageId(savedImage.getId());
                imageDto.setImageName(savedImage.getFileName());
                imageDto.setDownloadUrl(savedImage.getDownloadUrl());
                savedImagesDtos.add(imageDto);

            } catch (IOException | SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return savedImagesDtos;
    }

    @Override
    public void updateImage(MultipartFile file, Long ImageId) {

        Image image = getImageById(ImageId);

        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

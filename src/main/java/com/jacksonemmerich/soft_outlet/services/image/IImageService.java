package com.jacksonemmerich.soft_outlet.services.image;

import com.jacksonemmerich.soft_outlet.dto.ImageDto;
import com.jacksonemmerich.soft_outlet.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long ImageId);
}

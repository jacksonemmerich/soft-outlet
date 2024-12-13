package com.jacksonemmerich.soft_outlet.service;

import com.jacksonemmerich.soft_outlet.dto.ImageDto;
import com.jacksonemmerich.soft_outlet.model.Product;
import com.jacksonemmerich.soft_outlet.services.image.ImageService;
import com.jacksonemmerich.soft_outlet.services.product.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageServiceTest {

    @Mock
    private ImageService imageService;

    @Mock
    private ProductService productService;

    @Mock
    private MultipartFile file;

    @InjectMocks
    private ImageService imageServiceUnderTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    public void testSaveImages() throws IOException, SQLException {
        // Arrange
        Long productId = 1L;
        when(file.getOriginalFilename()).thenReturn("test.jpg");
        when(file.getContentType()).thenReturn("image/jpeg");
        when(file.getBytes()).thenReturn(new byte[]{1, 2, 3});
        ImageDto imageDto = new ImageDto();
        imageDto.setId(1L);
        imageDto.setFileName("test.jpg");
        imageDto.setDownloadUrl("/api/v1/images/image/download/1");
        when(imageService.saveImages(anyLong(), any(List.class))).thenReturn(Arrays.asList(imageDto));

        // Act
        List<ImageDto> result = imageServiceUnderTest.saveImages(productId, Arrays.asList(file));

        // Assert
        assertEquals(1, result.size());
        assertEquals(imageDto.getFileName(), result.get(0).getFileName());
        assertEquals(imageDto.getDownloadUrl(), result.get(0).getDownloadUrl());
        verify(imageService).saveImages(anyLong(), any(List.class));
    }*/
    @Test
    void testSaveImages() throws Exception {
        // Mock do produto
        Product product = new Product();
        product.setId(1L);

        // Mock do serviço
        when(productService.getProductById(1L)).thenReturn(product);

        // Mock do arquivo
        MockMultipartFile mockFile = new MockMultipartFile("file", "test.jpg", "image/jpeg", "Test Content".getBytes());

        // Salvar imagem
        List<ImageDto> savedImages = imageService.saveImages(1L, List.of(mockFile));
        assertNotNull(savedImages);
        assertFalse(savedImages.isEmpty());
    }
}


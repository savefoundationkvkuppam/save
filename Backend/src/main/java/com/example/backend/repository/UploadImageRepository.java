package com.example.backend.repository;

import com.example.backend.entity.UploadImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadImageRepository extends JpaRepository<UploadImage, Long> {
    List<UploadImage> findByDocumentType(String documentType);
}

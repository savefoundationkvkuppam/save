package com.example.backend.repository;

import com.example.backend.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByMemberId(Long memberId);
}


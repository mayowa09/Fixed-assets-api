package com.project.fixedasset.repositories;

import com.project.fixedasset.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetTypeRepository extends JpaRepository<AssetType, Long> {
    Optional<AssetType> findByTypeName(String typeName);
}

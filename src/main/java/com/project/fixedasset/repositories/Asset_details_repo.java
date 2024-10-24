package com.project.fixedasset.repositories;

import com.project.fixedasset.AssetDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

    public interface Asset_details_repo  extends JpaRepository<AssetDetails, Long> {
    @Query("SELECT COUNT(a) FROM AssetDetails a WHERE a.assetType.id = :assetTypeId AND a.assetId LIKE :year%")
    long countAssetsByTypeAndYear(@Param("assetTypeId") Long assetTypeId, @Param("year") String year);

        Page<AssetDetails> findAll(Pageable pageable);
    }

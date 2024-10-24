package com.project.fixedasset.services;

import com.project.fixedasset.AssetType;
import com.project.fixedasset.AssetDetails;
import com.project.fixedasset.FinancialInformation;
import com.project.fixedasset.repositories.AssetTypeRepository;
import com.project.fixedasset.repositories.Asset_details_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssetService {

    @Autowired
    private Asset_details_repo assetRepo;

    @Autowired
    private AssetTypeRepository assetTypeRepo;

    public String generateAssetId(AssetType assetType) {
        String year = String.valueOf(LocalDate.now().getYear());

        long count = assetRepo.countAssetsByTypeAndYear(assetType.getId(), year);
        String assetNumber = String.format("%03d", count + 1);

        return year + "/" + assetType.getPrefix() + assetNumber;
    }

    public AssetType getAssetTypeDetails(String typeName) {
        return assetTypeRepo.findByTypeName(typeName).orElse(null);
    }

    public FinancialInformation autoPopulateFinancialInfo(AssetType assetType) {
        FinancialInformation financialInfo = new FinancialInformation();
        financialInfo.setDepreciationRate(assetType.getDepreciationRate());
        financialInfo.setScrapValue(assetType.getScrapValue());
        financialInfo.setLifespan(assetType.getLifespan());

        return financialInfo;
    }


    public AssetDetails saveAsset(AssetDetails asset) {
        AssetType assetTypeEntity = assetTypeRepo.findById(asset.getAssetType().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid asset type"));
        asset.setAssetType(assetTypeEntity);
        String assetId = generateAssetId(assetTypeEntity);
        asset.setAssetId(assetId);
        return assetRepo.save(asset);
    }

    public List<AssetDetails> getAssets(PageRequest pageRequest) {
        return assetRepo.findAll(pageRequest).getContent();
    }
}

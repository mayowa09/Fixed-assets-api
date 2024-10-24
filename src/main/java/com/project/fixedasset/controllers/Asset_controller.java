package com.project.fixedasset.controllers;

import com.project.fixedasset.AssetDetails;
import com.project.fixedasset.AssetType;
import com.project.fixedasset.FinancialInformation;
import com.project.fixedasset.dto.AssetDetailsDTO;
import com.project.fixedasset.dto.FinancialInformationDTO;
import com.project.fixedasset.repositories.Asset_details_repo;
import com.project.fixedasset.repositories.Financial_information_repo;
import com.project.fixedasset.services.AssetService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/assets")
@Data
public class Asset_controller {

    @Autowired
    private Asset_details_repo assetRepo;

    @Autowired
    private Financial_information_repo financialRepo;

    @Autowired
    private AssetService assetService;

    @GetMapping("/")
    public List<AssetDetailsDTO> getAssets(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        List<AssetDetails> assets = assetService.getAssets(PageRequest.of(page, size));
        return assets.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/asset-type-details")
    public ResponseEntity<AssetType> getAssetTypeDetails(@RequestParam String typeName) {
        AssetType assetType = assetService.getAssetTypeDetails(typeName);
        return ResponseEntity.ok(assetType);
    }

    @GetMapping("/info")
    public List<FinancialInformation> getFinancialInfo() {
        return financialRepo.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<AssetDetailsDTO> createAsset(@Validated @RequestBody AssetDetailsDTO assetDTO) {
        AssetDetails assetEntity = mapToEntity(assetDTO);
        AssetDetails savedAsset = assetService.saveAsset(assetEntity);
        AssetDetailsDTO responseDTO = mapToDTO(savedAsset);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/auto-populate-financial-info")
    public ResponseEntity<FinancialInformationDTO> autoPopulateFinancialInfo(@RequestParam String typeName) {
        AssetType assetType = assetService.getAssetTypeDetails(typeName);
        if (assetType == null) {
            return ResponseEntity.badRequest().build();
        }

        FinancialInformation financialInfo = assetService.autoPopulateFinancialInfo(assetType);

        FinancialInformationDTO financialInfoDTO = new FinancialInformationDTO();
        financialInfoDTO.setDepreciationMethod("default method");
        financialInfoDTO.setDepreciationRate(financialInfo.getDepreciationRate());
        financialInfoDTO.setScrapValue(financialInfo.getScrapValue());
        financialInfoDTO.setLifespan(financialInfo.getLifespan());

        return ResponseEntity.ok(financialInfoDTO);
    }

    private AssetDetailsDTO mapToDTO(AssetDetails asset) {
        AssetDetailsDTO dto = new AssetDetailsDTO();
        dto.setAssetId(asset.getAssetId());
        dto.setAssetName(asset.getAssetName());
        dto.setCost(asset.getCost());
        dto.setLocation(asset.getLocation());
        dto.setAssignedTo(asset.getAssignedTo());
        dto.setAssetType(asset.getAssetType());
        return dto;
    }

    private AssetDetails mapToEntity(AssetDetailsDTO dto) {
        AssetDetails asset = new AssetDetails();
        asset.setAssetId(dto.getAssetId());
        asset.setAssetName(dto.getAssetName());
        asset.setCost(dto.getCost());
        asset.setLocation(dto.getLocation());
        asset.setAssignedTo(dto.getAssignedTo());
        asset.setAssetType(asset.getAssetType());
        return asset;
    }
}

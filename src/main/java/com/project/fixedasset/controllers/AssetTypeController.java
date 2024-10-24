package com.project.fixedasset.controllers;

import com.project.fixedasset.AssetType;
import com.project.fixedasset.repositories.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asset-types")
public class AssetTypeController {

    @Autowired
    private AssetTypeRepository assetTypeRepo;

    @GetMapping
    public List<AssetType> getAssetTypes() {
        return assetTypeRepo.findAll();
    }
}

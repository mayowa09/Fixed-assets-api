package com.project.fixedasset.dto;

import com.project.fixedasset.AssetType;

public class AssetDetailsDTO {

    private String assetId;
    private String assetName;
    private String assetSubType;
    private String purchaseDate;
    private Double cost;
    private String location;
    private String assignedTo;
    private AssetType assetType;

    // Getters
    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetSubType() {
        return assetSubType;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public Double getCost() {
        return cost;
    }

    public String getLocation() {
        return location;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    // Setters
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setAssetSubType(String assetSubType) {
        this.assetSubType = assetSubType;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }
}

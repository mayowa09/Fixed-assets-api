package com.project.fixedasset;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_details")
public class AssetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_id", unique = true)
    private String assetId;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_subtype")
    private String assetSubType;

    @Column(name = "purchase_date")
    private String purchaseDate;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "location")
    private String location;

    @Column(name = "assigned_to")
    private String assignedTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id")
    private AssetType assetType;

    // Getters
    public Long getId() {
        return id;
    }

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
    public void setId(Long id) {
        this.id = id;
    }

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

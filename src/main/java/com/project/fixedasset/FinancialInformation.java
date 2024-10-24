package com.project.fixedasset;

import jakarta.persistence.*;

@Entity
@Table(name = "financial_info")
public class FinancialInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long depreciation_id;

    @Column(name = "depreciation_method")
    private String depreciationMethod;

    @Column(name = "depreciation_rate")
    private Double depreciationRate;

    @Column(name = "scrap_value")
    private Double scrapValue;

    @Column(name = "lifespan")
    private Integer lifespan;

    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "Asset_id")
    private AssetDetails assetDetails;

    @ManyToOne
    @JoinColumn(name = "asset_type_id", referencedColumnName = "id")
    private AssetType assetType;

    // Getters and Setters
    public long getDepreciationId() {
        return depreciation_id;
    }

    public void setDepreciationId(long depreciation_id) {
        this.depreciation_id = depreciation_id;
    }

    public String getDepreciationMethod() {
        return depreciationMethod;
    }

    public void setDepreciationMethod(String depreciationMethod) {
        this.depreciationMethod = depreciationMethod;
    }

    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Double getScrapValue() {
        return scrapValue;
    }

    public void setScrapValue(Double scrapValue) {
        this.scrapValue = scrapValue;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public AssetDetails getAssetDetails() {
        return assetDetails;
    }

    public void setAssetDetails(AssetDetails assetDetails) {
        this.assetDetails = assetDetails;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }
}

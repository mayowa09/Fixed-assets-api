package com.project.fixedasset;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_type")
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", unique = true)
    private String typeName;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "depreciation_rate")
    private Double depreciationRate;

    @Column(name = "scrap_value")
    private Double scrapValue;

    @Column(name = "lifespan")
    private Integer lifespan;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for typeName
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    // Getter and Setter for prefix
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    // Getter and Setter for depreciationRate
    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    // Getter and Setter for scrapValue
    public Double getScrapValue() {
        return scrapValue;
    }

    public void setScrapValue(Double scrapValue) {
        this.scrapValue = scrapValue;
    }

    // Getter and Setter for lifespan
    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }
}

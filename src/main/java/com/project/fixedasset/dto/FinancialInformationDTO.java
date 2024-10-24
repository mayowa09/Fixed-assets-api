package com.project.fixedasset.dto;

public class FinancialInformationDTO {

    private String depreciationMethod;
    private Double depreciationRate;
    private Double scrapValue;
    private Integer lifespan;

    // Getters
    public String getDepreciationMethod() {
        return depreciationMethod;
    }

    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public Double getScrapValue() {
        return scrapValue;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    // Setters
    public void setDepreciationMethod(String depreciationMethod) {
        this.depreciationMethod = depreciationMethod;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public void setScrapValue(Double scrapValue) {
        this.scrapValue = scrapValue;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }
}

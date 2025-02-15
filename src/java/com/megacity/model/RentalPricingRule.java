/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.model;

import java.math.BigDecimal;

/**
 *
 * @author OZT00106
 */
public class RentalPricingRule {
    
    private int ruleId;                          
    private int rentalDaysCondition;            
    private BigDecimal discountPercentage;       
    private BigDecimal salesTaxPercentage;       
    private String description;

    public RentalPricingRule() {
    }

    public RentalPricingRule(int ruleId, int rentalDaysCondition, BigDecimal discountPercentage, BigDecimal salesTaxPercentage, String description) {
        this.ruleId = ruleId;
        this.rentalDaysCondition = rentalDaysCondition;
        this.discountPercentage = discountPercentage;
        this.salesTaxPercentage = salesTaxPercentage;
        this.description = description;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public int getRentalDaysCondition() {
        return rentalDaysCondition;
    }

    public void setRentalDaysCondition(int rentalDaysCondition) {
        this.rentalDaysCondition = rentalDaysCondition;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getSalesTaxPercentage() {
        return salesTaxPercentage;
    }

    public void setSalesTaxPercentage(BigDecimal salesTaxPercentage) {
        this.salesTaxPercentage = salesTaxPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RentalPricingRule{" + "ruleId=" + ruleId + ", rentalDaysCondition=" + rentalDaysCondition + ", discountPercentage=" + discountPercentage + ", salesTaxPercentage=" + salesTaxPercentage + ", description=" + description + '}';
    }
    
    
    





}

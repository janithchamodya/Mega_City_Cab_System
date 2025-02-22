/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.dao;

import com.megacity.model.RentalPricingRule;

/**
 *
 * @author OZT00106
 */
public interface RentalPricingRuleDAO {
    
    public RentalPricingRule getPricingRuleForRentalDays(int rentalDays);
    
}

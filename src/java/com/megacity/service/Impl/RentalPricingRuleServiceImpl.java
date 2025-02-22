/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacity.service.Impl;

import com.megacity.dao.RentalPricingRuleDAO;
import com.megacity.dao.Impl.RentalPricingRuleDAOImpl;
import com.megacity.model.RentalPricingRule;
import com.megacity.service.RentalPricingRuleService;
import org.slf4j.LoggerFactory;

/**
 *
 * @author OZT00106
 */
public class RentalPricingRuleServiceImpl  implements RentalPricingRuleService{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RentalPricingRuleServiceImpl.class);

   private  RentalPricingRuleDAO rentalPricingRuleDAO;
    
    public RentalPricingRuleServiceImpl(){    
        rentalPricingRuleDAO=new RentalPricingRuleDAOImpl();
    } 
    
    @Override
    public  RentalPricingRule getAllAvailableDrivers(int days){
        LOGGER.info("getPricingRuleForRentalDays");
        return rentalPricingRuleDAO.getPricingRuleForRentalDays(days);
    }
}

package com.ppro.interview.billing.models.converters;

import com.ppro.interview.billing.entitys.BillingPeriodEntity;
import com.ppro.interview.billing.models.BillingPeriod;

import java.sql.Date;
import java.time.LocalDate;

public class BillingPeriodConverter {

    public static BillingPeriodEntity toEntity(BillingPeriod billingPeriod) {
        BillingPeriodEntity entity = new BillingPeriodEntity();
        entity.setPeriodId(billingPeriod.getPeriodId());
        entity.setStartDate(Date.valueOf(billingPeriod.getFrom()).toLocalDate());
        entity.setEndDate(Date.valueOf(billingPeriod.getTo()).toLocalDate());
        entity.setYear(billingPeriod.getFrom().getYear());
        return entity;
    }

    public static BillingPeriod toModel(BillingPeriodEntity entity) {
        BillingPeriod billingPeriod = new BillingPeriod();
        billingPeriod.setPeriodId(entity.getPeriodId());
        billingPeriod.setFrom(entity.getStartDate());
        billingPeriod.setTo(entity.getEndDate());
        return billingPeriod;
    }
}

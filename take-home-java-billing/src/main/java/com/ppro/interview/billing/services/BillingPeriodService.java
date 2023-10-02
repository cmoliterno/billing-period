package com.ppro.interview.billing.services;

import com.ppro.interview.billing.entitys.BillingPeriodEntity;
import com.ppro.interview.billing.models.BillingPeriod;
import com.ppro.interview.billing.models.converters.BillingPeriodConverter;
import com.ppro.interview.billing.repository.BillingPeriodRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BillingPeriodService {

    private final BillingPeriodRepository billingPeriodRepository;

    @Autowired
    public BillingPeriodService(BillingPeriodRepository billingPeriodRepository) {
        this.billingPeriodRepository = billingPeriodRepository;
    }

    public String getBillingPeriod(LocalDate date) {
        BillingPeriodEntity entity = billingPeriodRepository.findByDate(date);
        return (Objects.nonNull(entity) ? entity.getPeriodId() : null);
    }

    public List<BillingPeriodEntity> getAllBillingPeriodsByYear(int year) {
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);
        return billingPeriodRepository.findByYear(startOfYear, endOfYear);
    }

    public List<BillingPeriod> generateBillingPeriods(int year) {
        List<BillingPeriod> billingPeriods = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

        int periodNumber = 1;

        while (!currentDate.isAfter(endDate)) {
            LocalDate periodStart = currentDate;

            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfMonth() == 1) {
                LocalDate nextDate = currentDate.plusDays(1);

                while (!nextDate.isAfter(endDate) && !(nextDate.getDayOfWeek() == DayOfWeek.SATURDAY || nextDate.getDayOfMonth() == 1)) {
                    nextDate = nextDate.plusDays(1);
                }

                LocalDate periodEnd = nextDate.minusDays(1);
                BillingPeriod period = new BillingPeriod(getPeriodId(year, periodNumber), periodStart, periodEnd);
                billingPeriods.add(period);
                BillingPeriodEntity periodEntity = BillingPeriodConverter.toEntity(period);
                billingPeriodRepository.save(periodEntity);

                periodNumber++;
            }

            currentDate = currentDate.plusDays(1);
        }


        return billingPeriods;

    }

    private static String getPeriodId(int year, int periodNumber) {
        return year + "-" + periodNumber;
    }

}

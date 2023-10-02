package com.ppro.interview.billing.services;

import com.ppro.interview.billing.entitys.BillingPeriodEntity;
import com.ppro.interview.billing.models.BillingPeriod;
import com.ppro.interview.billing.repository.BillingPeriodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BillingPeriodServiceTest {

    private BillingPeriodService billingPeriodService;

    @Mock
    private BillingPeriodRepository billingPeriodRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        billingPeriodService = new BillingPeriodService(billingPeriodRepository);
    }

    @Test
    public void testGetBillingPeriod() {
        LocalDate date = LocalDate.of(2019, Month.JANUARY, 24);
        BillingPeriodEntity billingPeriodEntity = new BillingPeriodEntity();
        billingPeriodEntity.setPeriodId("2019-4");
        billingPeriodEntity.setStartDate(LocalDate.of(2019, Month.JANUARY, 19));
        billingPeriodEntity.setEndDate(LocalDate.of(2019, Month.JANUARY, 25));

        when(billingPeriodRepository.findByDate(date)).thenReturn(billingPeriodEntity);

        String result = billingPeriodService.getBillingPeriod(date);

        assertEquals("2019-4", result);
    }

    @Test
    public void testGetAllBillingPeriodsByYear() {
        int year = 2019;
        LocalDate startOfYear = LocalDate.of(year, Month.JANUARY, 1);
        LocalDate endOfYear = LocalDate.of(year, Month.DECEMBER, 31);
        List<BillingPeriodEntity> billingPeriodEntities = new ArrayList<>();
        BillingPeriodEntity billingPeriodEntity = new BillingPeriodEntity();
        billingPeriodEntity.setPeriodId("2019-1");
        billingPeriodEntity.setStartDate(startOfYear);
        billingPeriodEntity.setEndDate(LocalDate.of(year, Month.JANUARY, 4));
        billingPeriodEntities.add(billingPeriodEntity);

        when(billingPeriodRepository.findByYear(startOfYear, endOfYear)).thenReturn(billingPeriodEntities);

        List<BillingPeriodEntity> result = billingPeriodService.getAllBillingPeriodsByYear(year);

        assertEquals(1, result.size());
        assertEquals("2019-1", result.get(0).getPeriodId());
    }

    @Test
    public void testGenerateBillingPeriods() {
        int year = 2019;

        List<BillingPeriod> result = billingPeriodService.generateBillingPeriods(year);

        assertEquals( result.size(), 63);
    }
}

package com.ppro.interview.billing.repository;

import com.ppro.interview.billing.entitys.BillingPeriodEntity;
import com.ppro.interview.billing.models.BillingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BillingPeriodRepository extends JpaRepository<BillingPeriodEntity, Long> {

    @Query("SELECT bp FROM BillingPeriodEntity bp " +
            "WHERE bp.startDate <= :endOfYear " +
            "AND bp.endDate >= :startOfYear")
    List<BillingPeriodEntity> findByYear(
            @Param("startOfYear") LocalDate startOfYear,
            @Param("endOfYear") LocalDate endOfYear
    );

    @Query("SELECT bp FROM BillingPeriodEntity bp " +
            "WHERE :date BETWEEN bp.startDate AND bp.endDate")
    BillingPeriodEntity findByDate(@Param("date") LocalDate date);

}

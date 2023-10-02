package com.ppro.interview.billing.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BillingPeriodResponseDTO {
    private String periodId;
    private LocalDate from;
    private LocalDate to;

}

package com.ppro.interview.billing.controllers;

import com.ppro.interview.billing.entitys.BillingPeriodEntity;
import com.ppro.interview.billing.models.BillingPeriod;
import com.ppro.interview.billing.models.dtos.BillingPeriodResponseDTO;
import com.ppro.interview.billing.services.BillingPeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/billing-periods")
@Slf4j
public class BillingPeriodController {

    private final BillingPeriodService billingPeriodService;

    @Autowired
    public BillingPeriodController(BillingPeriodService billingPeriodService) {
        this.billingPeriodService = billingPeriodService;
    }

    @PostMapping("/")
    public ResponseEntity<?> generateBillingPeriods(@RequestParam int year) {
        try {
            List<BillingPeriod> billingPeriods = billingPeriodService.generateBillingPeriods(year);
            return ResponseEntity.ok(billingPeriods);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Year out of the range.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IE001 - Internal Error. Please contact SUPPORT");
        }
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<BillingPeriodResponseDTO>> getBillingPeriodsByYear(@PathVariable int year) {
        try {
            List<BillingPeriodEntity> billingPeriods = billingPeriodService.getAllBillingPeriodsByYear(year);

            // Convert to DTO
            List<BillingPeriodResponseDTO> responseDTOs = billingPeriods.stream()
                    .map(this::mapToResponseDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responseDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private BillingPeriodResponseDTO mapToResponseDTO(BillingPeriodEntity billingPeriod) {
        BillingPeriodResponseDTO responseDTO = new BillingPeriodResponseDTO();
        responseDTO.setPeriodId(billingPeriod.getPeriodId());
        responseDTO.setFrom(billingPeriod.getStartDate());
        responseDTO.setTo(billingPeriod.getEndDate());
        return responseDTO;
    }
}
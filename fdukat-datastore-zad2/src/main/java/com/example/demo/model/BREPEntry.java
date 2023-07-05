package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Unindexed;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
public class BREPEntry {
    @Id
    @Unindexed
    private Long id;
    private String fullName;
    private OperationSystem operationSystem;
    private Integer yearsInXTRF;
    private BigDecimal bambooGoalsDonePercent;
    private Integer bambooGoalsDonePercentInteger;
}
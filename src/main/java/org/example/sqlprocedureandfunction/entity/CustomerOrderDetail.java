package org.example.sqlprocedureandfunction.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lzp
 */
@Data
public class CustomerOrderDetail {
    // === input ===
    private Integer customerId;

    // === output ===
    private String name;
    private Integer orderCount;
    private BigDecimal totalSpent;
}

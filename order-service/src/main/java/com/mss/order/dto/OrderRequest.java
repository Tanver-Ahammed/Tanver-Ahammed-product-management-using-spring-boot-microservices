package com.mss.order.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal totalAmount, Integer quantity) {
}

package com.example.budgeting.application.output;

import com.example.budgeting.domain.Transaction;

import java.math.BigDecimal;

public record TransactionOutput(String id, String description, String category, double value) {
    public static TransactionOutput from(Transaction transaction) {
        return new TransactionOutput(
                transaction.getId().uuid().toString(),
                transaction.getDescription(),
                transaction.getCategory().name(),
                BigDecimal.valueOf(transaction.getAmount()).movePointLeft(2).doubleValue());
    }
}
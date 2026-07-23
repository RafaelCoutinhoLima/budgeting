package com.example.budgeting.infrastructure.http.request;

import com.example.budgeting.application.input.PersistTransactionInput;
import com.example.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
package com.example.budgeting.domain;

import java.util.List;

public interface TransactionRepository {
    Transaction save (Transaction transaction);

    List<Transaction> findByCategory(Category category);
}

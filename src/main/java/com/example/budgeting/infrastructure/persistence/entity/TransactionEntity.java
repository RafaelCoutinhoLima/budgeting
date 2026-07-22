package com.example.budgeting.infrastructure.persistence.entity;

import com.example.budgeting.domain.Category;
import com.example.budgeting.domain.Transaction;
import com.example.budgeting.domain.TransactionId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class TransactionEntity {
    @Id
    private UUID id;
    private String description;
    private long amount;
    @Enumerated(EnumType.STRING)
    private Category category;
    protected TransactionEntity(){
    }
    public TransactionEntity(UUID id, String description, long amount, Category category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
    public static TransactionEntity from(Transaction transaction) {
        return new TransactionEntity(transaction.getId().uuid(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getCategory());
    }
    public Transaction toDomain() {
        return new Transaction(new TransactionId(this.id),
                this.description,
                this.amount,
                this.category);
    }
}

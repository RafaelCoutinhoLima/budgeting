package com.example.budgeting.domain;

import java.util.UUID;

public record TransactionId(UUID uuid){
    public TransactionId(){
        this(UUID.randomUUID());
    }
}

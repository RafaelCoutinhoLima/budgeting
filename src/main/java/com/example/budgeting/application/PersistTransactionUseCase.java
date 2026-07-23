package com.example.budgeting.application;

import com.example.budgeting.application.input.PersistTransactionInput;
import com.example.budgeting.application.output.TransactionOutput;
import com.example.budgeting.domain.Transaction;
import com.example.budgeting.domain.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.ai.tool.annotation.Tool;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Tool(name = "persist-transaction", description = "Persiste uma nova transação financeira")
    public TransactionOutput execute(PersistTransactionInput input) {
        var transaction = transactionRepository.save(
                new Transaction(input.description(), input.amount(), input.category()));

        return TransactionOutput.from(transaction);
    }

}
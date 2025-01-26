package ec.com.sofka.gateway.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDTO {
    private String id;
    private String description;
    private BigDecimal amount;
    private String transactionType;
    private LocalDate date;
    private String accountId;
    private BigDecimal tax;

    public TransactionDTO(String id, String description, BigDecimal amount, String transactionType, LocalDate date, String accountId, BigDecimal tax) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = date;
        this.accountId = accountId;
        this.tax = tax;
    }

    public TransactionDTO(String description, BigDecimal amount, String transactionType, LocalDate date, String accountId, BigDecimal tax) {
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = date;
        this.accountId = accountId;
        this.tax = tax;
    }

    public TransactionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}

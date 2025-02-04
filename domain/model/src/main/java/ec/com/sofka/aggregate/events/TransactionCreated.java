package ec.com.sofka.aggregate.events;

import ec.com.sofka.aggregate.events.util.TransactionEventsEnum;
import ec.com.sofka.generics.domain.DomainEvent;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionCreated extends DomainEvent {

    private String id;
    private String description;
    private BigDecimal amount;
    private String transactionType;
    private LocalDate date;
    private String accountId;
    private BigDecimal tax;

    public TransactionCreated(String eventType, String id, String description, BigDecimal amount, String transactionType, LocalDate date, String accountId, BigDecimal tax) {
        super(eventType);
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = date;
        this.accountId = accountId;
        this.tax = tax;
    }

    public TransactionCreated(String eventType) {
        super(TransactionEventsEnum.TRANSACTION_CREATED.name());
    }

    public TransactionCreated() {
        super(TransactionEventsEnum.TRANSACTION_CREATED.name());
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getTax() {
        return tax;
    }
}

package ec.com.sofka.aggregate.events;

import ec.com.sofka.aggregate.events.util.AccountEventsEnum;
import ec.com.sofka.generics.domain.DomainEvent;

import java.math.BigDecimal;

public class AccountUpdated extends DomainEvent {
    private String accountId;
    private String accountNumber;
    private String name;
    private String status;
    private BigDecimal balance;

    public AccountUpdated(String eventType, String accountId, String accountNumber, String name, String status, BigDecimal balance) {
        super(eventType);
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.status = status;
        this.balance = balance;
    }

    public AccountUpdated() {
        super(AccountEventsEnum.ACCOUNT_UPDATED.name());

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

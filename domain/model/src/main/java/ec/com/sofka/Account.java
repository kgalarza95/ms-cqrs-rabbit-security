package ec.com.sofka;


import java.math.BigDecimal;

public class Account {
    private String id;
    private BigDecimal balance;
    private String accountNumber;
    private String owner;

    public Account(String id, BigDecimal balance, String owner, String accountNumber) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

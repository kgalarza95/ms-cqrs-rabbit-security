package ec.com.sofka.gateway;

import ec.com.sofka.Account;

public interface AccountRepository {
    Account findByAcccountId(String id);
    Account save(Account account);
}

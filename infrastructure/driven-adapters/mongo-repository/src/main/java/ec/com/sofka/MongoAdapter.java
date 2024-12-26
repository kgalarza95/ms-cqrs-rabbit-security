package ec.com.sofka;

import ec.com.sofka.config.IMongoRepository;
import ec.com.sofka.data.AccountEntity;
import ec.com.sofka.gateway.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MongoAdapter implements AccountRepository {

    private final IMongoRepository repository;

    public MongoAdapter(IMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account findByAcccountId(String id) {
        AccountEntity found = repository.findById(id).get();

        return new Account(found.getId(), found.getBalance(), found.getOwner(), found.getAccountNumber());
    }

    @Override
    public Account save(Account account) {
        AccountEntity a = new AccountEntity(account.getBalance(), account.getOwner(), account.getAccountNumber());
        AccountEntity saved = repository.save(a);
        return new Account(saved.getId(), saved.getBalance(), saved.getOwner(), saved.getAccountNumber());
    }
}

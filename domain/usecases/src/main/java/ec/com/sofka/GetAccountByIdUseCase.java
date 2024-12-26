package ec.com.sofka;

import ec.com.sofka.gateway.AccountRepository;

public class GetAccountByIdUseCase{

    private final AccountRepository repository;

    public GetAccountByIdUseCase(AccountRepository repository) {
        this.repository = repository;
    }

    public Account apply(String id){
        return repository.findByAcccountId(id);
    }
}

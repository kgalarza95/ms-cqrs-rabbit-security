package ec.com.sofka.queries.usecase.account;

import ec.com.sofka.gateway.repository.AccountRepository;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class AccountCreatedViewUseCase implements IUseCaseAccept<AccountDTO, Void> {

    private final AccountRepository accountRepository;

    public AccountCreatedViewUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void accept(AccountDTO accountDTO) {
        accountRepository.save(accountDTO).subscribe();
    }


}

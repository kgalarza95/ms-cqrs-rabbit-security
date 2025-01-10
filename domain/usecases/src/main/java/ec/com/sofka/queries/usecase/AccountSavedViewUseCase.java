package ec.com.sofka.queries.usecase;

import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class AccountSavedViewUseCase implements IUseCaseAccept<AccountDTO, Void> {

    private final AccountRepository accountRepository;

    public AccountSavedViewUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void accept(AccountDTO accountDTO) {
        accountRepository.save(accountDTO).subscribe();
    }


}

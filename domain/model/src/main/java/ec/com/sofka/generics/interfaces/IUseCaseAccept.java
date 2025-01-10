package ec.com.sofka.generics.interfaces;

public interface IUseCaseAccept<AccountDTO, Void> {
    void accept(AccountDTO accountDTO);
}

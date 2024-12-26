package ec.com.sofka;

import ec.com.sofka.data.ResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class Handler {
    private final GetAccountByIdUseCase getAccountByIdUseCase;

    public Handler(GetAccountByIdUseCase getAccountByIdUseCase) {
        this.getAccountByIdUseCase = getAccountByIdUseCase;
    }

    public ResponseDTO  getAccountById(String id){
        Account account = getAccountByIdUseCase.apply(id);

        return new ResponseDTO(
                account.getOwner(),
                account.getAccountNumber());
    }

}

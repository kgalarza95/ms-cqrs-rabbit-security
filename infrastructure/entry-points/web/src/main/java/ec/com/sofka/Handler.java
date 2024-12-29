package ec.com.sofka;

import ec.com.sofka.appservice.CreateAccountUseCase;
import ec.com.sofka.appservice.GetAccountByIdUseCase;
import ec.com.sofka.data.RequestDTO;
import ec.com.sofka.data.ResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class Handler {
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    public Handler(GetAccountByIdUseCase getAccountByIdUseCase, CreateAccountUseCase createAccountUseCase) {
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.createAccountUseCase = createAccountUseCase;
    }

    public ResponseDTO  getAccountById(String id){
//        Account account = getAccountByIdUseCase.apply(id);
//
//        return new ResponseDTO(
//                account.getOwner(),
//                account.getAccountNumber());
        return null;
    }

    public ResponseDTO createAccount(RequestDTO request){
//        Account account = new Account(
//                null,
//                request.getBalance(),
//                request.getCustomer(),
//                request.getAccount());
//
//        Account a = createAccountUseCase.apply(account);
//
//        return new ResponseDTO(
//                a.getOwner(),
//                a.getAccountNumber());

        return null;
    }

}

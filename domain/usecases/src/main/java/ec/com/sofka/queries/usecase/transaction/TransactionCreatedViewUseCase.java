package ec.com.sofka.queries.usecase.transaction;

import ec.com.sofka.gateway.dto.CustomerDTO;
import ec.com.sofka.gateway.dto.TransactionDTO;
import ec.com.sofka.gateway.repository.CustomerRepository;
import ec.com.sofka.gateway.repository.TransactionRepository;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class TransactionCreatedViewUseCase implements IUseCaseAccept<TransactionDTO, Void> {

    private final TransactionRepository transactionRepository;

    public TransactionCreatedViewUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void accept(TransactionDTO dto) {
        transactionRepository.save(dto).subscribe();
    }


}

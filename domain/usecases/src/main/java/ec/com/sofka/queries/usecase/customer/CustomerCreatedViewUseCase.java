package ec.com.sofka.queries.usecase.customer;

import ec.com.sofka.gateway.dto.CustomerDTO;
import ec.com.sofka.gateway.repository.AccountRepository;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.gateway.repository.CustomerRepository;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class CustomerCreatedViewUseCase implements IUseCaseAccept<CustomerDTO, Void> {

    private final CustomerRepository customerRepository;

    public CustomerCreatedViewUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void accept(CustomerDTO dto) {
        customerRepository.save(dto).subscribe();
    }


}

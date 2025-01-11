package ec.com.sofka;

import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.events.CustomerUpdated;
import ec.com.sofka.gateway.dto.CustomerDTO;
import ec.com.sofka.gateway.listerner.CustomerBusMessageListenerGateway;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.queries.usecase.customer.CustomerCreatedViewUseCase;
import ec.com.sofka.queries.usecase.customer.CustomerUpdatedViewUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusMessageListener implements CustomerBusMessageListenerGateway {


    private final CustomerCreatedViewUseCase customerCreatedViewUseCase;
    private final CustomerUpdatedViewUseCase customerUpdatedViewUseCase;

    public CustomerBusMessageListener(CustomerCreatedViewUseCase customerCreatedViewUseCase, CustomerUpdatedViewUseCase customerUpdatedViewUseCase) {
        this.customerCreatedViewUseCase = customerCreatedViewUseCase;
        this.customerUpdatedViewUseCase = customerUpdatedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.customer}")
    public void receiveMsg(DomainEvent event) {
        if (event instanceof CustomerCreated) {
            customerCreated( event);
        } else if (event instanceof CustomerUpdated) {
            customerUpdated( event);
        }
    }

    private void customerCreated(DomainEvent event){
        CustomerCreated domainEvent = (CustomerCreated) event;
        customerCreatedViewUseCase.accept(new CustomerDTO(
                domainEvent.getId(),
                domainEvent.getIdentification(),
                domainEvent.getFirstName(),
                domainEvent.getLastName(),
                domainEvent.getEmail(),
                domainEvent.getPhone(),
                domainEvent.getAddress(),
                domainEvent.getBirthDate(),
                domainEvent.getStatus()
        ));
    }

    private void customerUpdated(DomainEvent event){
        CustomerUpdated domainEvent = (CustomerUpdated) event;
        customerUpdatedViewUseCase.accept(new CustomerDTO(
                domainEvent.getId(),
                domainEvent.getIdentification(),
                domainEvent.getFirstName(),
                domainEvent.getLastName(),
                domainEvent.getEmail(),
                domainEvent.getPhone(),
                domainEvent.getAddress(),
                domainEvent.getBirthDate(),
                domainEvent.getStatus()
        ));
    }
}

package ec.com.sofka;

import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.events.CustomerUpdated;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.gateway.listerner.CustomerBusMessageListenerGateway;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.queries.usecase.customer.CustomerCreatedViewUseCase;
import ec.com.sofka.queries.usecase.customer.CustomerUpdatedViewUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionBusMessageListener implements CustomerBusMessageListenerGateway {


    private final CustomerCreatedViewUseCase customerCreatedViewUseCase;
    private final CustomerUpdatedViewUseCase customerUpdatedViewUseCase;

    public TransactionBusMessageListener(CustomerCreatedViewUseCase customerCreatedViewUseCase, CustomerUpdatedViewUseCase customerUpdatedViewUseCase) {
        this.customerCreatedViewUseCase = customerCreatedViewUseCase;
        this.customerUpdatedViewUseCase = customerUpdatedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.transaction}")
    public void receiveMsg(DomainEvent event) {
        CustomerCreated domainEvent = (CustomerCreated) event;
//        customerCreatedViewUseCase.accept(new AccountDTO(
//                domainEvent.getAccountId(),
//                domainEvent.getName(),
//                domainEvent.getAccountNumber(),
//                domainEvent.getAccountBalance(),
//                domainEvent.getStatus()
//        ));
    }

}

package ec.com.sofka;

import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.events.CustomerUpdated;
import ec.com.sofka.aggregate.events.TransactionCreated;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.gateway.dto.TransactionDTO;
import ec.com.sofka.gateway.listerner.CustomerBusMessageListenerGateway;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.queries.usecase.customer.CustomerCreatedViewUseCase;
import ec.com.sofka.queries.usecase.customer.CustomerUpdatedViewUseCase;
import ec.com.sofka.queries.usecase.transaction.TransactionCreatedViewUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionBusMessageListener implements CustomerBusMessageListenerGateway {


    private final TransactionCreatedViewUseCase transactionCreatedViewUseCase;

    public TransactionBusMessageListener(TransactionCreatedViewUseCase transactionCreatedViewUseCase) {
        this.transactionCreatedViewUseCase = transactionCreatedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.transaction}")
    public void receiveMsg(DomainEvent event) {
        System.out.println("Recived event");
        TransactionCreated domainEvent = (TransactionCreated) event;
        transactionCreatedViewUseCase.accept(new TransactionDTO(
                domainEvent.getAccountId(),
                domainEvent.getDescription(),
                domainEvent.getAmount(),
                domainEvent.getTransactionType(),
                domainEvent.getDate(),
                domainEvent.getAccountId()
        ));
    }

}

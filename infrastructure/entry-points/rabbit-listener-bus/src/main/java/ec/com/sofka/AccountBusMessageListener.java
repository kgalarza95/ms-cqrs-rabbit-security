package ec.com.sofka;

import ec.com.sofka.aggregate.events.AccountCreated;
import ec.com.sofka.aggregate.events.AccountUpdated;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.queries.usecase.account.AccountCreatedViewUseCase;
import ec.com.sofka.gateway.listerner.AccountBusMessageListenerGateway;
import ec.com.sofka.queries.usecase.account.AccountUpdatedViewUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AccountBusMessageListener implements AccountBusMessageListenerGateway {


    private final AccountCreatedViewUseCase accountCreatedViewUseCase;
    private final AccountUpdatedViewUseCase accountUpdatedViewUseCase;

    public AccountBusMessageListener(AccountCreatedViewUseCase accountCreatedViewUseCase, AccountUpdatedViewUseCase accountUpdatedViewUseCase) {
        this.accountCreatedViewUseCase = accountCreatedViewUseCase;
        this.accountUpdatedViewUseCase = accountUpdatedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.account}")
    public void receiveMsg(DomainEvent event) {
        if (event instanceof AccountCreated) {
            accountCreated( event);
        } else if (event instanceof AccountUpdated) {
            accountUpdated( event);
        }
    }

    private void accountCreated(DomainEvent event){
        AccountCreated accountEvent = (AccountCreated) event;
        accountCreatedViewUseCase.accept(new AccountDTO(
                accountEvent.getAccountId(),
                accountEvent.getName(),
                accountEvent.getAccountNumber(),
                accountEvent.getAccountBalance(),
                accountEvent.getStatus()
        ));
    }

    private void accountUpdated(DomainEvent event){
        AccountUpdated accountUpdatedEvent = (AccountUpdated) event;
        accountUpdatedViewUseCase.accept(new AccountDTO(
                accountUpdatedEvent.getAccountId(),
                accountUpdatedEvent.getName(),
                accountUpdatedEvent.getAccountNumber(),
                accountUpdatedEvent.getBalance(),
                accountUpdatedEvent.getStatus()
        ));
    }
}

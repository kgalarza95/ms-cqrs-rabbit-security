package ec.com.sofka;

import ec.com.sofka.aggregate.events.AccountCreated;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.queries.usecase.AccountSavedViewUseCase;
import ec.com.sofka.usecase.PrintLogUseCase;
import ec.com.sofka.gateway.BusMessageListenerGateway;
import ec.com.sofka.usecase.RegisterLogUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AccountBusMessageListener implements BusMessageListenerGateway {


    private final RegisterLogUseCase registerLogUseCase;
    private final PrintLogUseCase printLogUseCase;
    private final AccountSavedViewUseCase accountSavedViewUseCase;

    public AccountBusMessageListener(RegisterLogUseCase registerLogUseCase, PrintLogUseCase printLogUseCase, AccountSavedViewUseCase accountSavedViewUseCase) {
        this.registerLogUseCase = registerLogUseCase;
        this.printLogUseCase = printLogUseCase;
        this.accountSavedViewUseCase = accountSavedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.account}")
    public void receiveMsg(DomainEvent event) {
        AccountCreated accountEvent = (AccountCreated) event;
        accountSavedViewUseCase.accept(new AccountDTO(
                accountEvent.getAccountId(),
                accountEvent.getName(),
                accountEvent.getAccountNumber(),
                accountEvent.getAccountBalance(),
                accountEvent.getStatus()
        ));
    }

}

package ec.com.sofka;

import ec.com.sofka.usecase.PrintLogUseCase;
import ec.com.sofka.gateway.BusMessageListenerGateway;
import ec.com.sofka.usecase.RegisterLogUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Service
public class BusListener implements BusMessageListenerGateway {

    @Value("${amqp.queue.default}")
    private String queueName;

    private final RegisterLogUseCase registerLogUseCase;
    private final PrintLogUseCase printLogUseCase;

    public BusListener(RegisterLogUseCase registerLogUseCase, PrintLogUseCase printLogUseCase) {
        this.registerLogUseCase = registerLogUseCase;
        this.printLogUseCase = printLogUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.default}")
    public void receiveMsg(String message) {
        Mono<Log> logMono = registerLogUseCase.saveLog(new Log(message, LocalDate.now()));

        logMono.subscribe(savedLog -> {
            printLogUseCase.accept(message);
        });

    }
}

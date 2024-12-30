package ec.com.sofka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ec.com.sofka.gateway.AccountBusMessageGateway;
import ec.com.sofka.gateway.TransactionBusMessageGateway;
import ec.com.sofka.usecase.PrintLogUseCase;
import ec.com.sofka.usecase.RegisterLogUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionBusMessageListener implements TransactionBusMessageGateway {

    private final RegisterLogUseCase registerLogUseCase;
    private final PrintLogUseCase printLogUseCase;

    public TransactionBusMessageListener(RegisterLogUseCase registerLogUseCase, PrintLogUseCase printLogUseCase) {
        this.registerLogUseCase = registerLogUseCase;
        this.printLogUseCase = printLogUseCase;
    }


    @Override
    @RabbitListener(queues = "${amqp.queue.transaction}")
    public void sendMsg(String log) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Log logObj = null;
        try {
            logObj = objectMapper.readValue(log.toString(), Log.class);
            Mono<Log> logMono = registerLogUseCase.saveLog(logObj);

            logMono.subscribe(savedLog -> {
                printLogUseCase.accept(log);
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package ec.com.sofka;

import ec.com.sofka.applogs.PrintLogUseCase;
import ec.com.sofka.gateway.BusMessageListener;
import ec.com.sofka.usecase.RegisterLogUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

//20. Create the BusListener class
@Service
public class BusListener implements BusMessageListener {

    private final RegisterLogUseCase registerLogUseCase;
    private final PrintLogUseCase printLogUseCase;

    public BusListener(RegisterLogUseCase registerLogUseCase, PrintLogUseCase printLogUseCase) {
        this.registerLogUseCase = registerLogUseCase;
        this.printLogUseCase = printLogUseCase;
    }

    //23. Implement the receiveMsg method with the usecase
    @Override
    @RabbitListener(queues = "simpleQueue")
    public void receiveMsg(String message) {
        Mono<Log> logMono = registerLogUseCase.saveLog(new Log(message, LocalDate.now()));

        logMono.subscribe(savedLog -> {
            System.out.println("Log saved: " + savedLog);
            printLogUseCase.accept(message);
        });

    }
}

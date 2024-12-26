package ec.com.sofka;

import ec.com.sofka.applogs.PrintLogUseCase;
import ec.com.sofka.gateway.BusMessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//20. Create the BusListener class
@Service
public class BusListener implements BusMessageListener{
    private final PrintLogUseCase printLogUseCase;

    public BusListener(PrintLogUseCase printLogUseCase) {
        this.printLogUseCase = printLogUseCase;
    }
    //23. Implement the receiveMsg method with the usecase
    @Override
    @RabbitListener(queues = "example.queue")
    public void receiveMsg(String message) {
        printLogUseCase.accept(message);
    }
}

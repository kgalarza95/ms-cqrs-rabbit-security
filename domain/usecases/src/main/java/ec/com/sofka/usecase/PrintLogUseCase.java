package ec.com.sofka.usecase;

public class PrintLogUseCase{

    public void accept(String message){
        System.out.println("Message received: " + message);
    }
}

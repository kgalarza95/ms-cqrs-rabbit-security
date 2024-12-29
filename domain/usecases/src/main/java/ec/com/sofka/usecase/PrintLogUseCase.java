package ec.com.sofka.usecase;

//18. UseCase for printing logs
public class PrintLogUseCase{

    public void accept(String message){
        //Print the message
        System.out.println("Message received: " + message);
    }
}

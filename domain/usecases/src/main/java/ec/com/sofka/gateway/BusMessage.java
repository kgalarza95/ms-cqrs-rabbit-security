package ec.com.sofka.gateway;

//7. New gateway to establish the link for the outside just as we do with repository
public interface BusMessage {
    //Its a void bc does an action
    void sendMsg(String message);
}

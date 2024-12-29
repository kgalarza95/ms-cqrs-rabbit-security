package ec.com.sofka.gateway;

//18. Port for listening messages
public interface BusMessageListenerGateway {
   void receiveMsg(String message);
}

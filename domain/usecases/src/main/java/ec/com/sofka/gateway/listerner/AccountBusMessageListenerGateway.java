package ec.com.sofka.gateway.listerner;

import ec.com.sofka.generics.domain.DomainEvent;

//18. Port for listening messages
public interface AccountBusMessageListenerGateway {
   void receiveMsg(DomainEvent event);
}

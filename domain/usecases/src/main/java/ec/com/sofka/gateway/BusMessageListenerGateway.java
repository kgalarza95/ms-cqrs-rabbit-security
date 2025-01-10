package ec.com.sofka.gateway;

import ec.com.sofka.generics.domain.DomainEvent;

//18. Port for listening messages
public interface BusMessageListenerGateway {
   void receiveMsg(DomainEvent event);
}

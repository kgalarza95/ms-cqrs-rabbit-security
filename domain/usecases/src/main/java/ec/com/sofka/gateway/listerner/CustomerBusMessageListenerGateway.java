package ec.com.sofka.gateway.listerner;

import ec.com.sofka.generics.domain.DomainEvent;

public interface CustomerBusMessageListenerGateway {
   void receiveMsg(DomainEvent event);
}

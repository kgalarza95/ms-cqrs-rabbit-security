package ec.com.sofka.gateway.listerner;

import ec.com.sofka.generics.domain.DomainEvent;

public interface TransactionBusMessageListenerGateway {
   void receiveMsg(DomainEvent event);
}

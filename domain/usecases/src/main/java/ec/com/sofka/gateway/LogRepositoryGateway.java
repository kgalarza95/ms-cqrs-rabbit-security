package ec.com.sofka.gateway;

import ec.com.sofka.model.Log;
import reactor.core.publisher.Mono;

public interface LogRepositoryGateway {
    Mono<Log> saveLog(Log log);
}

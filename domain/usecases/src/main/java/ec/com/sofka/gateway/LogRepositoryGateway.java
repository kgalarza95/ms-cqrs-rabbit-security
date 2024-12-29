package ec.com.sofka.gateway;

import ec.com.sofka.Log;
import reactor.core.publisher.Mono;

public interface LogRepositoryGateway {
    Mono<Log> saveLog(Log log);
}

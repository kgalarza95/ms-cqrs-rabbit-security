package ec.com.sofka.usecase;

import ec.com.sofka.Log;
import ec.com.sofka.gateway.LogRepositoryGateway;
import reactor.core.publisher.Mono;

public class RegisterLogUseCase {

    LogRepositoryGateway logRepositoryGateway;

    public RegisterLogUseCase(LogRepositoryGateway logRepositoryGateway) {
        this.logRepositoryGateway = logRepositoryGateway;
    }

    public Mono<Log> saveLog(Log log){
        return logRepositoryGateway.saveLog(log);
    }
}

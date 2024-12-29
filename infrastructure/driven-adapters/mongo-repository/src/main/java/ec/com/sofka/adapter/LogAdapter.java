package ec.com.sofka.adapter;

import ec.com.sofka.Log;
import ec.com.sofka.document.LogDocument;
import ec.com.sofka.gateway.LogRepositoryGateway;
import ec.com.sofka.mapper.LogMapper;
import ec.com.sofka.repository.ILogRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class LogAdapter implements LogRepositoryGateway {

    private final  ILogRepository iLogRepository;

    public LogAdapter(ILogRepository iLogRepository) {
        this.iLogRepository = iLogRepository;
    }

    @Override
    public Mono<Log> saveLog(Log log) {
        LogDocument logDocument = LogMapper.toEntity(log);
        return iLogRepository.save(logDocument).map(LogMapper::toDomain);
    }
}

package ec.com.sofka.repository;

import ec.com.sofka.document.LogDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ILogRepository extends ReactiveMongoRepository<LogDocument, String> {
}

package ec.com.sofka.adapter;

import ec.com.sofka.gateway.dto.TransactionDTO;
import ec.com.sofka.gateway.repository.TransactionRepository;
import ec.com.sofka.mapper.TransactionRepoMapper;
import ec.com.sofka.repository.ITransactionRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TransactionAdapterGateway implements TransactionRepository {

    private final ITransactionRepository transactionRepository;
    private final ReactiveMongoTemplate accountReactiveMongoTemplate;

    public TransactionAdapterGateway(ITransactionRepository transactionRepository, ReactiveMongoTemplate accountReactiveMongoTemplate) {
        this.transactionRepository = transactionRepository;
        this.accountReactiveMongoTemplate = accountReactiveMongoTemplate;
    }

    @Override
    public Mono<TransactionDTO> save(TransactionDTO transaction) {
        return Mono.just(transaction)
                .map(TransactionRepoMapper::toEntity)
                .flatMap(transactionRepository::save)
                .map(TransactionRepoMapper::toDomain);
    }
}

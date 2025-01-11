package ec.com.sofka.adapter;

import ec.com.sofka.document.AccountEntity;
import ec.com.sofka.document.ClientEntity;
import ec.com.sofka.gateway.dto.AccountDTO;
import ec.com.sofka.gateway.dto.CustomerDTO;
import ec.com.sofka.gateway.repository.AccountRepository;
import ec.com.sofka.gateway.repository.CustomerRepository;
import ec.com.sofka.mapper.AccountRepoMapper;
import ec.com.sofka.mapper.CustomerRepoMapper;
import ec.com.sofka.repository.IAccountMongoRepository;
import ec.com.sofka.repository.ICustomerMongoRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomerMongoAdapter implements CustomerRepository {


    private final ICustomerMongoRepository iCustomerMongoRepository;
    private final ReactiveMongoTemplate accountReactiveMongoTemplate;

    public CustomerMongoAdapter(ICustomerMongoRepository iCustomerMongoRepository, ReactiveMongoTemplate accountReactiveMongoTemplate) {
        this.iCustomerMongoRepository = iCustomerMongoRepository;
        this.accountReactiveMongoTemplate = accountReactiveMongoTemplate;
    }

    @Override
    public Flux<CustomerDTO> findAll() {
        return iCustomerMongoRepository.findAll()
                .map(CustomerRepoMapper::toDomain);
    }

    @Override
    public Mono<CustomerDTO> findByCustomerId(String id) {
        return iCustomerMongoRepository.findById(id)
                .map(CustomerRepoMapper::toDomain);
    }

    @Override
    public Mono<CustomerDTO> save(CustomerDTO dto) {
        return Mono.just(dto)
                .map(CustomerRepoMapper::toEntity)
                .flatMap(iCustomerMongoRepository::save)
                .map(CustomerRepoMapper::toDomain);
    }

    @Override
    public Mono<CustomerDTO> update(CustomerDTO dto) {
        return iCustomerMongoRepository.findById(dto.getId())
                .flatMap(existingClient -> {
                    ClientEntity updatedClient = CustomerRepoMapper.toEntity(dto);
                    updatedClient.setId(existingClient.getId());
                    return iCustomerMongoRepository.save(updatedClient);
                })
                .map(CustomerRepoMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(CustomerDTO dto) {
        return iCustomerMongoRepository.findById(dto.getId())
                .flatMap(iCustomerMongoRepository::delete)
                .then();
    }
}

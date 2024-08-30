package org.example.loginapi.repo;

import org.example.loginapi.model.entity.BankAccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepo extends MongoRepository<BankAccountEntity, String> {
    Optional<BankAccountEntity> findByIban(String iban);
    void deleteByIban(String iban);

}

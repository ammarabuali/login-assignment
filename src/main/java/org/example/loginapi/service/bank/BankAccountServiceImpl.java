package org.example.loginapi.service.bank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.loginapi.exception.*;
import org.example.loginapi.model.entity.BankAccountEntity;
import org.example.loginapi.model.response.CreateBankAccountResponse;
import org.example.loginapi.model.response.DeleteBankAccountResponse;
import org.example.loginapi.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {

    private final AccountRepo accountRepo;

    @Override
    public CreateBankAccountResponse createBankAccount(BankAccountEntity bankAccount) {
        try {
            if (accountRepo.findByIban(bankAccount.getIban()).isPresent()) {
                throw new AccountAlreadyExistsException("Account already exists " + bankAccount.getIban());
            }
            accountRepo.save(bankAccount);
        } catch (AccountAlreadyExistsException e) {
            log.error("Account with iban {} already exists!", bankAccount.getIban());
            throw new AccountAlreadyExistsException();
        } catch (Exception e) {
            throw new AccountServiceException("An error occurred while creating account " + " " + bankAccount.getIban() + " " + e.getMessage());
        }
        return CreateBankAccountResponse.builder().created(true).build();

    }

    @Override
    public DeleteBankAccountResponse deleteBankAccount(String iban) {
        try {
            if (accountRepo.findByIban(iban).isPresent()) {
                accountRepo.deleteByIban(iban);
                return DeleteBankAccountResponse.builder().deleted(true).build();
            }
            throw new AccountNotFoundException("Account with iban " + iban + " does not exist");
        } catch (AccountNotFoundException e) {
            log.error("Account with this iban {} does not exist" ,iban);
            throw new AccountNotFoundException();
        } catch (Exception e) {
            throw new AccountServiceException("An error occurred while creating account " + iban + " " + e.getMessage());
        }
    }

}

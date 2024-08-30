package org.example.loginapi.service.bank;

import org.example.loginapi.model.entity.BankAccountEntity;
import org.example.loginapi.model.response.CreateBankAccountResponse;
import org.example.loginapi.model.response.DeleteBankAccountResponse;

public interface BankAccountService {
    CreateBankAccountResponse createBankAccount(BankAccountEntity bankAccount);
    DeleteBankAccountResponse deleteBankAccount(String iban);
}

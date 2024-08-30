package org.example.loginapi.controller.bankaccount;

import lombok.RequiredArgsConstructor;
import org.example.loginapi.model.entity.BankAccountEntity;
import org.example.loginapi.model.request.DeleteBankAccountRequest;
import org.example.loginapi.model.response.CreateBankAccountResponse;
import org.example.loginapi.model.response.DeleteBankAccountResponse;
import org.example.loginapi.service.bank.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/account")
@RequiredArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {

    private final BankAccountService bankAccountService;

    @Override
    public ResponseEntity<CreateBankAccountResponse> createBankAccount(BankAccountEntity account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bankAccountService.createBankAccount(account));
    }

    @Override
    public ResponseEntity<DeleteBankAccountResponse> deleteBankAccount(DeleteBankAccountRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.deleteBankAccount(request.getIban()));
    }
}

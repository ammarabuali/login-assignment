package org.example.loginapi.controller.bankaccount;

import jakarta.validation.Valid;
import org.example.loginapi.annotation.CommonResponse;
import org.example.loginapi.model.entity.BankAccountEntity;
import org.example.loginapi.model.request.DeleteBankAccountRequest;
import org.example.loginapi.model.response.CreateBankAccountResponse;
import org.example.loginapi.model.response.DeleteBankAccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BankAccountController {

    @PostMapping("/create")
    @CommonResponse
    ResponseEntity<CreateBankAccountResponse> createBankAccount(@RequestBody @Valid BankAccountEntity account);


    @DeleteMapping("/delete")
    @CommonResponse
    ResponseEntity<DeleteBankAccountResponse> deleteBankAccount(@RequestBody DeleteBankAccountRequest request);
}

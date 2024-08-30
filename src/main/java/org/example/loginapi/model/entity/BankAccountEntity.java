package org.example.loginapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "BANK_ACCOUNTS")
public class BankAccountEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    private String id;

    @NotBlank(message = "Account title can't be left empty")
    @Size(min = 4, max = 20, message = "Account title must be between 4 and 20 characters")
    private String accountTitle;

    @NotBlank(message = "IBAN can't be left empty")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{1,30}$", message = "Invalid IBAN format")
    @Schema(example = "DE1234567890")
    private String iban;
}



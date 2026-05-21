package net.javaguides.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data is a Lombok annotation
// that automatically generates getter, setter, toString(), equals(), hashCode(),
// and required constructor methods. It helps reduce boilerplate code and makes the class cleaner.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;



}

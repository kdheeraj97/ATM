package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
    private String name;
    private BankAccount account;
}

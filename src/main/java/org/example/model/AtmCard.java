package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtmCard {
    private int cardNo;
    private int pin;
    private Customer customer;
}

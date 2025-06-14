package org.example.model;

import lombok.Getter;

@Getter
public enum Cash {
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    ONE_HUNDRED(100);

    private final int value;
    Cash(int value) {
        this.value = value;
    }
}

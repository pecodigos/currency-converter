package com.pecodigos.exceptions;

import java.io.IOException;

public class UnableToConnectException extends IOException {
    public UnableToConnectException() {
        super("Error: Could not connect to ExchangeRate API.");
    }
}

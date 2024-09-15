package com.pecodigos.models;

import com.pecodigos.dtos.CurrencyDTO;
import lombok.Data;

@Data
public class Currency {

    private String code;
    private double value;

    public Currency(CurrencyDTO currencyDTO) {
        this.code = currencyDTO.code();
        this.value = Double.parseDouble(currencyDTO.value());
    }
}

package com.pecodigos.models;

import com.google.gson.annotations.SerializedName;
import com.pecodigos.dtos.CurrencyDTO;
import lombok.Data;

import java.util.Map;

@Data
public class Currency {

    @SerializedName("base_code")
    private String currencyCode;

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public Currency(CurrencyDTO currencyDTO) {
        this.currencyCode = currencyDTO.code();
        this.conversionRates = currencyDTO.conversionRates();
    }

    public Double getRate(String code) {
        return conversionRates != null ? conversionRates.get(code.toUpperCase()) : null;
    }
}

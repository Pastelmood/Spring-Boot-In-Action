package com.il0v3dorayaki.demo.wallet;

import com.il0v3dorayaki.demo.annotation.WalletType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Wallet {

    @Positive(message = "Field id must be Positive Number")
    @NotNull(message = "Field id is required")
    private int id;

    @Size(min = 3, max = 255, message = "Field name must be between 3 to 255 characters")
    private String name;

    @WalletType
    private String type;

    @NotNull(message = "field balance is required")
    private Double balance;

    public Wallet(int id, String name, String type, Double balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

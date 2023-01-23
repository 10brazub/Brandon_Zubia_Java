package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

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

    public int getBalance() {
        
        int balance = 0;
        List<AccountRecord> customerCharges = getCharges();

        for (AccountRecord charge: customerCharges) {
            balance += charge.getCharge();
        }

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return String.format(id + " " + name + " " + getBalance());
    }
}

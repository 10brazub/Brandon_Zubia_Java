package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();
        
        // HashMap keeps track of the unique accounts and keeps track  
        // of their index in customerList
        Map<Integer, Integer> accountsSeenWithIndex = new HashMap<>();
        int idx = 0;

        for (String[] customer: customerData) {
            int customerId = Integer.parseInt(customer[0]);
            
            // Check to see if the current account has been seen before
            // if so, just append charge data to charges list
            if (accountsSeenWithIndex.containsKey(customerId)) {
                
                // Retrieve customer from customerList using the index stored
                // in hashmap
                int idxCustomer = accountsSeenWithIndex.get(customerId);
                Customer currentCustomer = customerList.get(idxCustomer);

                AccountRecord newRecord = new AccountRecord();
                int chargeAmount = Integer.parseInt(customer[2]);
                String chargeDate = customer[3];
                newRecord.setCharge(chargeAmount);
                newRecord.setChargeDate(chargeDate);

                currentCustomer.getCharges().add(newRecord);

            } 
            // New accounts that havent been seen are put into customerList
            // and ID and index are stored in hashmap when accessing the same account occurs
            else {
                String customerName = customer[1];
                int chargeAmount = Integer.parseInt(customer[2]);
                String chargeDate = customer[3];

                Customer newCustomer = new Customer();
                newCustomer.setId(customerId);
                newCustomer.setName(customerName);

                AccountRecord newRecord = new AccountRecord();
                newRecord.setCharge(chargeAmount);
                newRecord.setChargeDate(chargeDate);
                newCustomer.getCharges().add(newRecord);

                accountsSeenWithIndex.put(customerId, idx);
                customerList.add(newCustomer);
                idx++;
            }
        }
        
        // Separates the accounts into two lists by distinguishing
        // which account balances are positive or negative
        List<Customer> positiveBalances = new ArrayList<>();
        List<Customer> negativeBalances = new ArrayList<>();

        for (Customer currentCustomer: customerList) {
            if (currentCustomer.getBalance() >= 0) {
                positiveBalances.add(currentCustomer);
            } else {
                negativeBalances.add(currentCustomer);
            }
        }

        System.out.println("Positive accounts:" + positiveBalances);
        System.out.println("Negative accounts:" + negativeBalances);
    }
}

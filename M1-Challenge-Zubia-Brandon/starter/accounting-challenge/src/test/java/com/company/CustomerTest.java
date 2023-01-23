package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void shouldCalculateBalance() {
        // Test for positive balance
        Customer customer1 = new Customer();
        AccountRecord record11 = new AccountRecord();
        AccountRecord record12 = new AccountRecord();

        record11.setCharge(1000);
        record12.setCharge(500);

        customer1.getCharges().add(record11);
        customer1.getCharges().add(record12);

        assertEquals(1500, customer1.getBalance());

        // Test for negative balance
        Customer customer2 = new Customer();
        AccountRecord record21 = new AccountRecord();
        AccountRecord record22 = new AccountRecord();

        record21.setCharge(-1000);
        record22.setCharge(500);

        customer2.getCharges().add(record21);
        customer2.getCharges().add(record22);

        assertEquals(-500, customer2.getBalance());

        // Test for zero balance
        Customer customer3 = new Customer();
        AccountRecord record31 = new AccountRecord();
        AccountRecord record32 = new AccountRecord();

        record31.setCharge(-500);
        record32.setCharge(500);

        customer1.getCharges().add(record31);
        customer1.getCharges().add(record32);

        assertEquals(0, customer3.getBalance());
    }

    @Test
    public void shouldReturnCustomerData() {
        // Test of customer of zero balance
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Netflix Inc");

        assertEquals("1 Netflix Inc 0", customer1.toString());

        // Test of customer with positive balance
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Movie Pass");

        AccountRecord record = new AccountRecord();
        record.setCharge(20000);
        customer2.getCharges().add(record);

        assertEquals("2 Movie Pass 20000", customer2.toString());

        // Test of customer with negative balance
        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("BlockBuster");

        AccountRecord record2 = new AccountRecord();
        record2.setCharge(-200);
        customer3.getCharges().add(record2);

        assertEquals("3 BlockBuster -200", customer3.toString());
    }
}

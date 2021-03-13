package edu.pingpong.enzinium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AddressTest {

    Address address = null;

    @Before
    public void setupAddress() {
        address = new Address();
        address.generateKeyPair();
    }

    @Test
    public void constructorTest() {
        assertNotNull(address);
    }
}

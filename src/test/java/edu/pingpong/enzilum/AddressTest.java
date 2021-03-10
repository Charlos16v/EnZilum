package edu.pingpong.enzilum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AddressTest {

    Address addres = null;

    @Before
    public void setupAddress() {
        addres = new Address();
        addres.generateKeyPair();
    }

    @Test
    public void constructorTest() {
        assertNotNull(addres);
    }
}

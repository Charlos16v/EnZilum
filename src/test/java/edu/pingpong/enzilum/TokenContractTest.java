package edu.pingpong.enzilum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TokenContractTest {

    TokenContract tokenContract = null;
    Address test = null;

    @Before
    public void setupTokenContract() {
        test = new Address();
        test.generateKeyPair();
        tokenContract = new TokenContract(test);
    }

    @Test
    public void constructorTest() {
        assertNotNull(tokenContract);
    }

}

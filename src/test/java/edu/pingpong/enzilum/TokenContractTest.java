package edu.pingpong.enzilum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenContractTest {

    TokenContract tokenContract = null;
    Address test = null;

    @Before
    public void setupTokenContract() {
        test = new Address();
        test.generateKeyPair();
        tokenContract = new TokenContract(test);
        tokenContract.setName("Dollars");
        tokenContract.setSymbol("USD");
        tokenContract.setTotalSupply(100);
        tokenContract.setTokenPrice(5d);
    }

    @Test
    public void constructorTest() {
        assertNotNull(tokenContract);
    }

    @Test
    public void addOwnerTest(){
        tokenContract.addOwner(test.getPK(), tokenContract.getTotalSupply());
        assertTrue(tokenContract.getBalances().containsKey(test.getPK()));
        assertTrue(tokenContract.getBalances().containsValue(tokenContract.getTotalSupply()));
    }
}

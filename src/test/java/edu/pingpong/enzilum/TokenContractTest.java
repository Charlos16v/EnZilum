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
        tokenContract.addOwner(test.getPK(), tokenContract.getTotalSupply());
    }

    @Test
    public void constructorTest() {
        assertNotNull(tokenContract);
    }

    @Test
    public void addOwnerTest(){
        assertTrue(tokenContract.getBalances().containsKey(test.getPK()));
        assertTrue(tokenContract.getBalances().containsValue(tokenContract.getTotalSupply()));
    }

    @Test
    public void numOwnersTest(){
        assertEquals(1, tokenContract.numOwners());
    }

    @Test
    public void balanceOfTest(){
        assertEquals(100.0, tokenContract.balanceOf(test.getPK()), 0.001);
    }
}

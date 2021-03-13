package edu.pingpong.enzinium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenContractTest {

    TokenContract tokenContract = null;
    Address test = null;
    Address aguila = null;

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
        aguila = new Address();
        aguila.generateKeyPair();
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

    @Test
    public void transferTest() {
        tokenContract.transfer(aguila.getPK(), 2d);
        assertEquals(98, tokenContract.balanceOf(test.getPK()), 0.001);
        assertEquals(2, tokenContract.balanceOf(aguila.getPK()), 0.001);
    }

    @Test
    public void totalTokensSoldTest() {
        tokenContract.transfer(aguila.getPK(), 69d);
        assertEquals(69, tokenContract.totalTokensSold());
    }
}

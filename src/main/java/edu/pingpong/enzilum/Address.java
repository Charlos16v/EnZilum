package edu.pingpong.enzilum;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    // Attributes
    private PublicKey PK = null;
    private PrivateKey SK = null;
    private double balance = 0.0d;
    private final String SYMBOL = "EZI";

    // Constructor
    public Address(){};

    // Getters & Setters
    public PublicKey getPK() {
        return PK;
    }

    public void setPK(PublicKey PK) {
        this.PK = PK;
    }

    public PrivateKey getSK() {
        return SK;
    }

    public void setSK(PrivateKey SK) {
        this.SK = SK;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSYMBOL() {
        return SYMBOL;
    }

    // Method generateKeyPair, responsible for generating and assigning a public and private key to Address.
    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        assert pair != null;
        setPK(pair.getPublic());
        setSK(pair.getPrivate());
    }

    @Override
    public String toString(){
        return "Public Address: " + getPK().hashCode() + '\n' +
                "Balance: " + getBalance() + '\n';
    }
}

package edu.pingpong.enzilum;

import java.security.PublicKey;
import java.util.HashMap;

public class TokenContract {

    // Attributes
    private Address owner = null;
    private PublicKey ownerPK = null;
    private String name = "";
    private String symbol = "";
    private double totalSupply = 0;
    private double tokenPrice = 0.0d;

    private final HashMap<PublicKey , Double> balances = new HashMap<>();

    // Constructor
    public TokenContract(Address owner) {
        setOwner(owner);
        setOwnerPK(owner.getPK());
    }

    // Getters and setters
    public Address getOwner() {
        return owner;
    }

    public void setOwner(Address owner) {
        this.owner = owner;
    }

    public PublicKey getOwnerPK() {
        return ownerPK;
    }

    public void setOwnerPK(PublicKey ownerPK) {
        this.ownerPK = ownerPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public double getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrice(double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public HashMap<PublicKey, Double> getBalances() {
        return balances;
    }

    // Method toString Overrided
    @Override
    public String toString() {
        return "Owner PublicKey: " + getOwnerPK().hashCode() + '\n' +
                "Token Name: " + getName() + '\n' +
                "Token SYMBOL: " + getSymbol() + '\n' +
                "Supply Stock: " + getTotalSupply() + '\n';
    }

    // Method encharged of add a owner if not exists to the balances HashMap
    public void addOwner(PublicKey pk, double totalSupply) {
        getBalances().putIfAbsent(pk, totalSupply);
    }

    // Method encharged to return the number of owners in balances.
    public int numOwners() {
        return getBalances().keySet().size();
    }

    // Method encharged to return the value of the introduced key, if it hasn't a value return 0d.
    public double balanceOf(PublicKey pk) {
        return getBalances().getOrDefault(pk, 0d);
    }
}

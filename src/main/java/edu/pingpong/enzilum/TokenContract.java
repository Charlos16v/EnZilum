package edu.pingpong.enzilum;

import java.security.PublicKey;

public class TokenContract {

    // Attributes
    public PublicKey owner = null;
    private String name = "";
    private String symbol = "";
    private int totalSupply = 0;
    private double tokenPrice = 0.0d;

    // Constructor
    public TokenContract(Address owner) {
        setOwner(owner.getPK());
    }

    // Getters and setters
    public PublicKey getOwner() {
        return owner;
    }

    public void setOwner(PublicKey owner) {
        this.owner = owner;
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

    public int getTotalSupply() {
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

    // Method toString Overrided
    @Override
    public String toString() {
        return "Token Name: " + getName() + '\n' +
                "Token SYMBOL: " + getSymbol() + '\n' +
                "Supply Stock: " + getTotalSupply() + 'n';
    }
}

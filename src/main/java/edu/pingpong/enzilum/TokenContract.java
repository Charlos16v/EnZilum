package edu.pingpong.enzilum;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

    // Attributes
    private Address owner = null;
    private PublicKey ownerPK = null;
    private String name = "";
    private String symbol = "";
    private double totalSupply = 0d;
    private Double tokenPrice = 0.0d;
    private Double totalTokenSold = 0.0d;

    private final Map<PublicKey , Double> balances = new HashMap<>();

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

    public Double getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrice(double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public Map<PublicKey, Double> getBalances() {
        return balances;
    }

    public void setTotalTokenSold(double totalTokenSold) {
        this.totalTokenSold = totalTokenSold;
    }

    public Double getTotalTokenSold() {
        return totalTokenSold;
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

    // Method require, mocking require of Solidity.
    private void require(Boolean holds) throws Exception {
        if (! holds) {
           throw new Exception();
        }
    }

    // Method in charge of sending tokends from the owner.
    public void transfer(PublicKey recipient, Double quantity){
        try {
            require(balanceOf(getOwnerPK()) >= quantity); // Check
            getBalances().compute(getOwnerPK(), (pk, tokens) -> tokens - quantity); // We subtract tokens from the owner.
            getBalances().put(recipient, balanceOf(recipient) + quantity); // We sum the tokens to the recipient.
        } catch (Exception e) {
            // silently...
        }
    }

    // Method in charge of sending tokens between 2 public keys.
    public void transfer(PublicKey sender, PublicKey recipient, Double quantity){
        try {
            require(balanceOf(sender) >= quantity); // Check
            getBalances().put(sender, balanceOf(sender) - quantity); // We subtract tokens from the owner.
            getBalances().put(recipient, balanceOf(recipient) + quantity); // We sum the tokens to the recipient.
        } catch (Exception e) {
            // silently...
        }
    }

    // Method encharged of print all the owners of tokens, less the owner of the contract.
    public void owners(){
        getBalances().keySet().forEach(
                (key) -> {
                    if (!key.equals(getOwnerPK())){
                        System.out.println("Owner: " + key.hashCode()
                                + " " + getBalances().get(key) + " "
                                + getSymbol());
                    }
                }
        );
    }

    // Method encharged to return the number of tokens solded.
    public int totalTokensSold(){
        getBalances().values().forEach((tokens) -> setTotalTokenSold( getTotalTokenSold() + tokens ));
        setTotalTokenSold(getTotalTokenSold() - balanceOf(getOwnerPK()));
        return getTotalTokenSold().intValue();
    }
}

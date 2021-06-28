package Model.Entities;

import Model.Exceptions.DomainException;

/**
 * Account
 */
public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double whithDrawLimit;

    public Account(Integer number, String holder, Double whithDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
        this.whithDrawLimit = whithDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

  
    public Double getWhithDrawLimit() {
        return whithDrawLimit;
    }

    public void setWhithDrawLimit(Double whithDrawLimit) {
        this.whithDrawLimit = whithDrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void whithDraw(Double amount) throws DomainException{
        if(amount > balance){
            throw new DomainException("Not enough balance");
        }
        if(amount > whithDrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        this.balance -= amount;
    }
    
}
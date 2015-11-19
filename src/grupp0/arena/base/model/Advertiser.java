/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.base.model;

/**
 * This classa defines the user of the type advertisers
 * @author Zzooki
 */
public class Advertiser extends User{
    private int balance;
    /**
     * Advertiser constructor
     */
    public Advertiser(){
        balance = 0;
    }
    /**
     * Advertiser constructor 
     * @param starterBalance if the advertiser should have a starter balance it
     * can be created with this value
     */
    public Advertiser(int starterBalance){
        this.balance = starterBalance;
    }

    @Override
    public UserType getType() {
        return (UserType.ADVERTISER);
    }
    /**
     * getBalance accessor method in order to retrive the advertisers balance
     * @return the advertiers balance as a int
     */
    public int getBalance(){
        return(balance);
    }
    /**
     * setBalance accessor method in order to change the advertisers balance
     * @param balance this parameter takes a value of int which should represent 
     * the advertisers balance
     */
    public void setBalance(int balance){
        this.balance = balance;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.base.model;

/**
 *
 * @author Zzooki
 */
public class Advertiser extends User{
    private int balance;
    public Advertiser(){
        balance = 0;
    }
    public Advertiser(int starterBalance){
        this.balance = starterBalance;
    }

    @Override
    public UserType getType() {
        return (UserType.ADVERTISER);
    }
}

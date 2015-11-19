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
    private AdvertisementInfo[] ownAds;
    private int numberOfAds;
    /**
     * Advertiser constructor
     */
    public Advertiser(){
        balance = 0;
        numberOfAds = 0;
    }
    /**
     * Advertiser constructor 
     * @param starterBalance if the advertiser should have a starter balance it
     * can be created with this value
     */
    public Advertiser(int starterBalance){
        this.balance = starterBalance;
        this.numberOfAds = 0;
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
    /**
     * getAd accessor method makes it able to return one of the advertisers 
     * ads.
     * @param index the index which is choosen represent the index of the add 
     * which is going to be returned when called for. If index is a higher value
     * then the number of ads the advertiser currently has or is lower than zero
     * the method will return null.
     * @return returns the ad that is stored at the index choosen.
     */
    public AdvertisementInfo getAd(int index){
        if (index > numberOfAds || index < 0){
            System.out.print("index out of bound!");
            return(null);
        }      
        else
            return(ownAds[index]);
    }
    /**
     * setAd accessor method makes it able to add a advertisement to the advertiser
     * which is the owner of the add
     * @param info is the parameter for the advertisement which is a AdvertisementInfo
     * type.
     */
    public void setAd(AdvertisementInfo info){
        ownAds[numberOfAds] = info;
        numberOfAds++;
    }
}

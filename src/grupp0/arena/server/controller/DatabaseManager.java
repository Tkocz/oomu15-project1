/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.server.controller;

import grupp0.arena.base.model.AdvertisementInfo;
import grupp0.arena.base.model.Advertiser;
import grupp0.arena.base.model.GameInfo;
import grupp0.arena.base.model.Player;
import grupp0.arena.base.model.Operator;
import grupp0.arena.base.model.User;
import java.util.ArrayList;

/**
 *
 * @author Darko
 */
public class DatabaseManager {
    private ArrayList<User> users = new ArrayList();
    private ArrayList<GameInfo> games = new ArrayList();
    private ArrayList<AdvertisementInfo> ads = new ArrayList();

    private void createUsers() {
        Player temp = new Player();
        temp.setName("player");
        temp.setPassword("123");
        users.add(temp);

        Operator temp2 = new Operator();
        temp2.setName("operator");
        temp2.setPassword("123");
        users.add(temp2);

        Advertiser temp3 = new Advertiser();
        temp3.setName("advertiser");
        temp3.setPassword("123");
        users.add(temp3);
    }

    private void createGames() {
       games.add(new GameInfo(
                     "Othello",
                     "The best Othello game ever made",
                     "http://cassio.free.fr/cassio/images/Icone_Cassio.png"
                 ));
       
       games.add(new GameInfo(
                     "TicTacToe",
                     "Classic boardgame for two",
                     "http://www.clker.com/cliparts/8/9/d/8/1242809270906368991Tic_tac_toe.svg.hi.png"
                 ));

       /*games.add(new GameInfo(
                     "Counter-Strike",
                     "Strike at the counter and Make the cashier mad",
                     "https://cdn2.iconfinder.com/data/icons/perqui/48/cs.png"
                 ));

       games.add(new GameInfo(
                     "World Of Warcraft",
                     "L2P is for n00bz",
                     "http://img3.wikia.nocookie.net/__cb20080327190257/wowwiki/images/thumb/d/d3/Wow-icon-scalable.svg/48px-Wow-icon-scalable.svg.png"
                 ));*/
    }

    private void createAds() {
        Advertiser advertiser = (Advertiser)getUser("advertiser");
       ads.add(new AdvertisementInfo("Othello","http://oi68.tinypic.com/2aj84z8.jpg", advertiser));
       ads.add(new AdvertisementInfo("hb.se","http://oi68.tinypic.com/20i8mtu.jpg", advertiser));
       //ads.add(new AdvertisementInfo("fra.se","http://oi67.tinypic.com/23h3g4h.jpg", advertiser));
    }

    public DatabaseManager() {
        createUsers();
        createGames();
        createAds();
    }

    public GameInfo[] getGames(){
        return games.toArray(new GameInfo[0]);
    }

    public AdvertisementInfo[] getAds(){
        return ads.toArray(new AdvertisementInfo[0]);
    }

    /**
     * returns a use, if the user don't exists null will be returned.
     * @param name
     * @return User if it exists else null.
     */
    public User getUser(String name){
        if (name == null) return null;
        for(User u : users)
            if(u != null && u.getName().equals(name))
                return u;

        return null;
    }

    /**
     * validates a login. If the login-credentials is valid the user will be
     * returned. If a login is invalid null will be returned.
     * @param name
     * @param password
     * @return Correct login returns user and an incorrect login returns null.
     */
    public User loginUser(String name, String password){
        User temp = getUser(name);
        if(temp == null) return null;
        if(temp.getPassword().equals(password))//Kolla om password stämmer innan det returneras
            return temp;
        else
            return null;
    }

    public ArrayList getUsers(){
        return users;
    }
}

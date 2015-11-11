/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.controller;

import grupp0.arena.model.GameInfo;
import grupp0.arena.model.Player;
import grupp0.arena.model.User;
import java.util.ArrayList;

/**
 *
 * @author Darko
 */
public class DatabaseManager {
    private ArrayList<User> users = new ArrayList();
    private ArrayList<GameInfo> games = new ArrayList();

    public DatabaseManager() {
        Player temp = new Player();
        temp.setName("player");
        temp.setPassword("player");
        users.add(temp);
       
        games.add(new GameInfo("Othello", "The best Othello game ever made",
                "https://cdn2.iconfinder.com/data/icons/crystalproject/crystal_project_256x256/apps/package_games.png"));
        games.add(new GameInfo("adjfkajsdfja", "",
                "https://cdn2.iconfinder.com/data/icons/crystalproject/crystal_project_256x256/apps/package_games.png"));
        games.add(new GameInfo("kadjflasdjfasldfjlad", "",
                "https://cdn2.iconfinder.com/data/icons/crystalproject/crystal_project_256x256/apps/package_games.png"));
        games.add(new GameInfo("asdkjfladjfoapdf", "",
                "https://cdn2.iconfinder.com/data/icons/crystalproject/crystal_project_256x256/apps/package_games.png"));
        
        //users.add(new Operator());
        //users.add(new Advertiser());
    }
    
    public GameInfo[] getGames(){
        return games.toArray(new GameInfo[0]);
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

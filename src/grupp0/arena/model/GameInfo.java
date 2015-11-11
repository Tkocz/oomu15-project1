/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.model;

/**
 * Class that manages information about the different games that's available
 * through the platform.
 * @author Zzooki
 */
public class GameInfo {
    private String name;
    private String description;
    private String imageUrl;
    
    /**
     * Constructor for the GameInfo class
     * @param name is the parameter for the name of the game
     * @param description is the parameter containing the description of the game
     * @param imageUrl is the parameter containing the url for an immage 
     * representing the game
     */
    public GameInfo(String name, String description, String imageUrl){
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    /**
     * setName accessor method to be able to set the game name
     * @param name parameter which contains the name of the game as a string
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * getName accessor method inorder to get the name of the game
     * @return a string which is the name of the game
     */
    public String getName(){
        return(this.name);
    }
    /**
     * setUrl accessor method which makes it able to set the image url
     * @param imgUrl is the parameter which represents the image url and needs 
     * to be a string
     */
    public void setUrl(String imgUrl){
        this.imageUrl = imgUrl;
    }
    /**
     * getUrl accessor method which makes it able to get the image url
     * @return a string which represents the image url.
     */
    public String getUrl(){
        return(this.imageUrl);
    }
    /**
     * setDescription accessor method which makes it able to set the description of the game
     * @param description is the parameter which is a sring and represents the 
     * url for the image.
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * getDescription accessor method makes it able to get the description of the
     * game
     * @return a string which represents the description of the game.
     */
    public String getDescription(){
        return(this.description);
    }
    
}

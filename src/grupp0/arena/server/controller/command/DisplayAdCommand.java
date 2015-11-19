/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.server.controller.command;

/**
 *
 * @author Zzooki
 */
public class DisplayAdCommand extends ServerNetworkCommand{
    /**
     * DisplayAddCommand the command which makes it able to inform the server
     * about the appropriate link and image for an advertisement
     * @param imageURL is a String URL where the image can be found
     * @param linkURL  is a String URL representing where the user should be 
     * directed if it clicks the advertisement banner.
     */
    public DisplayAdCommand(String imageURL, String linkURL){
        setArgs(new String[] { imageURL, linkURL });
    }
    
    @Override
    public String getCommandString() {
        return ("display_ad");
    }
}

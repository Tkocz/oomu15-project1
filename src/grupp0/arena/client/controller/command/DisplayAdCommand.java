/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.client.controller.command;

import grupp0.arena.Arena;
import grupp0.arena.base.model.AdvertisementInfo;
import grupp0.arena.client.controller.Client;

/**
 *
 * @author Zzooki
 */
public class DisplayAdCommand extends ClientNetworkCommand{

    @Override
    public void perform(){
        //Visa ad i lobby
        Arena.trace("visar ad" + getArg(0));
        String imageURL = getArg(0);
        String linkURL  = getArg(1);
        AdvertisementInfo ad = new AdvertisementInfo(imageURL, linkURL, null);
        Client.getInstance().adProperty().setValue(ad);
    }
}

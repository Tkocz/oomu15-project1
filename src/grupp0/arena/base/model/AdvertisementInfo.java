/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.base.model;

/**
 * AdvertisementInfo contains information about the ads shown in the ARENA client.
 * @author Rasmus
 */
 
public class AdvertisementInfo {
    private String linkURL;
    private String imageURL;
    /**
     * Constructor for AdvertisemntInfo.
     * @param link URL to the site that the advertisement redirects to when clicked.
     * @param image The image shown in the ARENA client.
     */
    public AdvertisementInfo(String link, String image){
        linkURL = link;
        imageURL = image;
    }
    /**
     * Sets the link to the advertisers homepage.
     * @param link URL to the adevertisers homepage.
     */
    public void setLinkUrl(String link){
        linkURL = link;
    }
    /**
     * Sets the URL for the ad shown in the ARENA client.
     * @param link URL to the image shown in the client.
     */
    public void setImgURL(String link){
        imageURL = link;
    }
    /**
     * Returns the URL for the advertisers homepage.
     * @return The advertisers URL
     */
    public String getLinkURL(){
        return linkURL;
    }
    /**
     * Return the URL of the image shown in the ad as a String.
     * @return The URL of the image shown in the ARENA client.
     */
    public String getImageUrl(){
        return imageURL;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.client.model;

import grupp0.arena.model.UserType;

/**
 *
 * @author Zzooki
 */
public class Player extends User{

public Player(){

}

@Override
public UserType getType() {
    return (UserType.PLAYER);
}

}

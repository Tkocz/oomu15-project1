/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp0.arena.base.model;

import grupp0.arena.base.model.UserType;

/**
 * Player class extends the abstract class user
 * @author Zzooki
 */
public class Player extends User{


@Override
public UserType getType() {
    return (UserType.PLAYER);
}

}

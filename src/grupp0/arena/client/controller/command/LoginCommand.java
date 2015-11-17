/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package grupp0.arena.client.controller.command;

/**
*
* @author Rasmus
*/
public class LoginCommand extends ClientNetworkCommand{

private String userName;
private String password;

public LoginCommand(String userName, String password){
    this.userName = userName;
    this.password = password;
}


public String getUserName(){
    return userName;
}

public String getPassword(){
    return password;
}

@Override
public void perform() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}

package grupp0.arena.client.controller.command;

import grupp0.arena.client.controller.Client;

/**
 * Created by Darko on 19/11/15.
 */
public class ChatCommand extends ClientNetworkCommand{


    public ChatCommand(){
    }

    public ChatCommand(String name, String text){
        setArgs(new String[]{name, text});
    }

    @Override
    public String getCommandString(){
        return "chat";
    }

    @Override
    public void perform(){
        String text = "<" + getArg(0) + "> " + getArg(1) + "\n";
        String s = Client.getInstance().chatTextProperty().getValue();
        if (s == null)
            s = "";
        Client.getInstance().chatTextProperty().setValue(s + text);
    }
}

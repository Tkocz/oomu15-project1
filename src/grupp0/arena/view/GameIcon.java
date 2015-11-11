package grupp0.arena.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.model.GameInfo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Represents a game icon show in the lobby game library.
 *
 * @author Philip Arvidsson (S133686)
 */
public class GameIcon extends VBox {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

private GameInfo gameInfo;

private ImageView icon;

private Text name;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

public GameIcon(GameInfo gameInfo) {
    this.gameInfo = gameInfo;

    icon = new ImageView(new Image(gameInfo.getImageURL()));
    name = new Text(gameInfo.getName());

    getChildren().add(icon);
    getChildren().add(name);
}

}

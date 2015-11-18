package grupp0.arena.client.view;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import grupp0.arena.client.model.GameInfo;
import javafx.geometry.Pos;

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
    this.setAlignment(Pos.CENTER);

    icon = new ImageView(new Image(gameInfo.getImageURL()));
    name = new Text(gameInfo.getName());

    icon.setFitWidth(48);
    icon.setFitHeight(48);

    getChildren().add(icon);
    getChildren().add(name);
}

}

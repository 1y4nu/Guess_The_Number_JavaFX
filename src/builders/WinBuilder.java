package builders;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

public class WinBuilder implements Builder<Region> {

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        Label label = new Label("You Guessed The Number!");
        TilePane labelPane = new TilePane(label);
        labelPane.setAlignment(Pos.CENTER);
        pane.add(labelPane,0,4);
        return pane;
    }
}

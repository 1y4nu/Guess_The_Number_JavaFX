import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

public class GameBuilder implements Builder<Region> {
    private Label currentPosition;

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        currentPosition = new Label("Guess the number!");
        TilePane positionPane = new TilePane(currentPosition);
        positionPane.setAlignment(Pos.CENTER);
        pane.add(positionPane,0,4);

        TextField guessField = new TextField();
        TilePane fieldPane = new TilePane(guessField);
        fieldPane.setAlignment(Pos.CENTER);
        pane.add(fieldPane,0,5);

        Button guessButton = new Button("Guess!");
        TilePane buttonPane = new TilePane(guessButton);
        buttonPane.setAlignment(Pos.CENTER);
        pane.add(buttonPane,0,6);
        return pane;
    }
}

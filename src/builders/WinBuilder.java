package builders;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

public class WinBuilder implements Builder<Region> {

    private int noOfGuesses;

    public WinBuilder(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        Label label = new Label("You Guessed The Number!");
        TilePane labelPane = new TilePane(label);
        labelPane.setAlignment(Pos.CENTER);
        pane.add(labelPane,0,4);

        Label guessNum = new Label("It took you: " + noOfGuesses + " Guess(es)");
        TilePane numPane = new TilePane(guessNum);
        numPane.setAlignment(Pos.CENTER);
        pane.add(numPane,0,5);
        return pane;
    }
}

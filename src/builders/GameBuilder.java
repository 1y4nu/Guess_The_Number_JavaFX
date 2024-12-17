package builders;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.Node;

public class GameBuilder implements Builder<Region> {
    private Label currentPosition;
    private TextField guessField;
    private int number;

    public  GameBuilder(int number) {
        this.number = number;
    }

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        currentPosition = new Label("Guess the number!");
        TilePane positionPane = new TilePane(currentPosition);
        positionPane.setAlignment(Pos.CENTER);
        pane.add(positionPane,0,4);

        guessField = new TextField();
        TilePane fieldPane = new TilePane(guessField);
        fieldPane.setAlignment(Pos.CENTER);
        pane.add(fieldPane,0,5);

        Button guessButton = (Button) guessButton();
        TilePane buttonPane = new TilePane(guessButton);
        buttonPane.setAlignment(Pos.CENTER);
        pane.add(buttonPane,0,6);
        return pane;
    }

    public Node guessButton() {
        Button guessButton = new Button("Guess!");
        guessButton.setOnAction(evt -> {
            try {
                int guessInput = Integer.parseInt(guessField.getText());
                if (guessInput < number)
                    currentPosition.setText("Guess Higher!");
                else if (guessInput > number)
                    currentPosition.setText("Guess Lower!");
                else
                    currentPosition.setText("You Guessed The Number!");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        });
        return guessButton;
    }
}

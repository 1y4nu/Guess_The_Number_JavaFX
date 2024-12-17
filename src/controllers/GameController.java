package controllers;

import builders.WinBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GameController {

    private int noOfGuesses = 0;

    public void guessAction(TextField guessField, Label currentPosition, int number) {
        try {
            int guessInput = Integer.parseInt(guessField.getText());
            if (guessInput < number) {
                noOfGuesses++;
                currentPosition.setText("Guess Higher!");
            } else if (guessInput > number) {
                noOfGuesses++;
                currentPosition.setText("Guess Lower!");
            } else {
                noOfGuesses++;
                openWinWindow();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
    }

    private void openWinWindow() {
        Stage winStage = new Stage();
        WinBuilder winBuilder = new WinBuilder(noOfGuesses);
        Region winRegion = winBuilder.build();
        Scene scene = new Scene(winRegion, 400, 200);
        winStage.setTitle("Congratulations");
        winStage.setScene(scene);
        winStage.show();
    }
}

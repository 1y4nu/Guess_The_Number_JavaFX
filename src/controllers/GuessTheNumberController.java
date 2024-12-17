package controllers;

import builders.GameBuilder;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Random;

public class GuessTheNumberController {

    private Random random = new Random();

    public void beginAction(TextField inputField) {
        try {
            int userIn = Integer.parseInt(inputField.getText());
            int randomNum = random.nextInt(userIn) + 1;
            System.out.println(randomNum);
            openGuessingWindow(randomNum);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }
    }

    private void openGuessingWindow(int randomNumber) {
        Stage guessingStage = new Stage();

        GameBuilder gameBuilder = new GameBuilder(randomNumber);
        Region gameRegion = gameBuilder.build();

        Scene scene = new Scene(gameRegion, 300, 200);
        guessingStage.setTitle("Guess The Number");
        guessingStage.setScene(scene);
        guessingStage.show();
    }
}

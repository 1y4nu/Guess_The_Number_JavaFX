package builders;

import controllers.GuessTheNumberController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GuessTheNumberBuilder implements Builder<Region> {

    private final GuessTheNumberController controller = new GuessTheNumberController();
    private TextField inputField;

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        Label welcome = new Label("Welcome to the Number Guessing Game!");
        welcome.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        TilePane welcomePane = new TilePane(welcome);
        welcomePane.setAlignment(Pos.CENTER);
        pane.add(welcomePane,0,4);

        Label input = new Label("Please Enter the Maximum Number");
        TilePane inputPane = new TilePane(input);
        inputPane.setAlignment(Pos.CENTER);
        pane.add(inputPane,0,5);

        inputField = new TextField();
        TilePane textField = new TilePane(inputField);
        textField.setAlignment(Pos.CENTER);
        pane.add(textField,0, 6);

        Button begin = (Button) beginButton();
        TilePane beginButton = new TilePane(begin);
        beginButton.setAlignment(Pos.CENTER);
        pane.add(beginButton, 0, 7);

        return pane;
    }

    public Node beginButton() {
        Button begin = new Button("Begin");
        begin.setOnAction(evt -> controller.beginAction(inputField));
        return begin;
    }


}

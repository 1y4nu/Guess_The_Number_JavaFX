import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.Node;

public class GuessTheNumberBuilder implements Builder<Region> {
    private TextField inputField;
    private int userIn;

    @Override
    public Region build() {
        GridPane pane = new GridPane(20,20);
        Label welcome = new Label("Welcome to the Number Guessing Game!");
        TilePane welcomePane = new TilePane(welcome);
        welcomePane.setAlignment(Pos.CENTER);
        pane.add(welcomePane,0,4);

        Label input = new Label("Please Enter a number to begin");
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
        begin.setOnAction(evt -> {
            try {
                userIn = Integer.parseInt(inputField.getText());
                System.out.println(userIn * 100);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        });
        return begin;
    }
}

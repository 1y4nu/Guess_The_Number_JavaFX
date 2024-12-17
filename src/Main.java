import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {
        Builder<Region> builder = new GuessTheNumberBuilder();
        Region region = builder.build();

        Scene scene = new Scene(region,300, 300);
        stage.setTitle("Guess The Number");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

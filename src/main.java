import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application {

    // Instantiation of Start Method
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Creation of Screen Grid
        GridPane gridOrganizer = new GridPane();

        // Creation of 4 Sub-grids
        StackPane clickerPane = new StackPane();
        GridPane progressPane = new GridPane();
        Pane storeNamePane = new Pane();
        GridPane storeShopsPane = new GridPane();

        // Setting size of each grids' sizes.
        gridOrganizer.getColumnConstraints().add(new ColumnConstraints(800));
        gridOrganizer.getColumnConstraints().add(new ColumnConstraints(400));
        gridOrganizer.getRowConstraints().add(new RowConstraints(150));
        gridOrganizer.getRowConstraints().add(new RowConstraints(650));


        // Clicker Area

        //TODO:

        Pane cosmicBackground = new Pane();
        cosmicBackground.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        clickerPane.getChildren().addAll(cosmicBackground);


        // Progress Area

        //TODO:

        // Store Name Area

        Text storeName = new Text("Lunar Loot");
        storeName.setFont(Font.font("Calibiri", 30));
        storeName.setFill(Color.WHITE);
        storeNamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        storeNamePane.getChildren().add(storeName);
        storeName.relocate(70, 20);


        // Shops Area




        // Grid Area

        gridOrganizer.add(storeNamePane, 1, 0);
        gridOrganizer.add(clickerPane,0,1);


        // Establishing setup of Window
        Scene scene = new Scene(gridOrganizer, 1200, 800);
        primaryStage.setTitle("Cosmos Clicker");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Ensures Animations Update
        gridOrganizer.requestFocus();
    }
}


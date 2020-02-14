import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application {

    private int coins = 0;
    private Text score = new Text("Cosmo Coins: 0");

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
        Image earthPicture = new Image("earth.png");
        ImageView earthView = new ImageView(earthPicture);
        earthView.setFitHeight(400);
        earthView.setFitWidth(400);
        Image galaxy = new Image("galaxy.png");
        ImageView galaxyView = new ImageView(galaxy);
        galaxyView.setFitHeight(650);
        galaxyView.setFitWidth(800);

        clickerPane.getChildren().addAll(galaxyView, earthView);



        // Progress Area

        //TODO:

        Pane progressBarTitle = new Pane();
        GridPane progressBar = new GridPane();
        Pane nextLevelPane = new Pane();
        Pane coinPane = new Pane();

        progressBar.setHgap(30);

        for (int i=0; i<4; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / 4);
            progressBar.getColumnConstraints().add(colConst);
        }

        RowConstraints rowConst = new RowConstraints();
        rowConst.setPercentHeight(25);
        progressBar.getRowConstraints().add(rowConst);

        progressBarTitle.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        progressBar.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        nextLevelPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        coinPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Text progressTitle = new Text();
        progressTitle.setText("Progress Title: " + coins);
        progressTitle.setFont(Font.font("Helvetica", 30));
        progressBarTitle.getChildren().add(progressTitle);

        progressPane.add(progressBarTitle, 0, 0);
        progressPane.add(progressBar, 1, 0);
        progressPane.add(nextLevelPane, 2, 0);
        progressPane.add(coinPane, 3, 0);
        displayCoins(coinPane);


        // Store Name Area

        Image storeTitle = new Image("title.png");
        ImageView storeTitleView = new ImageView(storeTitle);
        storeTitleView.setFitHeight(350);
        storeTitleView.setFitWidth(400);
        storeNamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        storeNamePane.getChildren().add(storeTitleView);
        //storeTitleView.relocate(70, 20);


        // Shops Area




        // Grid Area

        gridOrganizer.add(storeNamePane, 1, 0);
        gridOrganizer.add(clickerPane,0,1);
        gridOrganizer.add(progressPane, 0,0 );

        // Click Controls
        Timeline animation;
        animation = new Timeline(
                new KeyFrame(Duration.millis(100), e -> updateCookies(coinPane))
        );

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        earthView.setOnMouseClicked(e -> {
            coins = Earth.updateCoins(coins);
            displayCoins(coinPane);
        });

        // Establishing setup of Window
        Scene scene = new Scene(gridOrganizer, 1200, 800);
        primaryStage.setTitle("Cosmos Clicker");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Ensures Animations Update
        gridOrganizer.requestFocus();
    }

    public void updateCookies(Pane coinPane) {
        displayCoins(coinPane);
    }

    public void displayCoins(Pane coinPane) {
        coinPane.getChildren().remove(score);
        score.setText("Cosmo Coins: " + coins);
        score.setFont(Font.font("Helvetica", 30));
        score.setStroke(Color.WHITE);
        score.relocate(0, 0);
        coinPane.getChildren().add(score);
    }
}


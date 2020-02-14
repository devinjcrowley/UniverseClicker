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
import javafx.scene.layout.Pane;

public class main extends Application {

    private int coins = 0;
    private Text score = new Text("Cosmo Coins: 0");
    private int levelLimit = 10;
    private int level = 1;
    final Color PRIMARYGRAY = Color.valueOf("#575757");
    private int shootingNum =0;
    private int satNum = 0;
    private int redNum = 0;
    private int blackNum = 0;

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
        rowConst.setPercentHeight(150);
        progressBar.getRowConstraints().add(rowConst);

        progressBarTitle.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        progressBar.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        nextLevelPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        coinPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        progressPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Text progressTitle = new Text();
        progressTitle.setText(" Progress:  ");
        progressTitle.setFont(Font.font("Helvetica", 25));
        progressTitle.setStroke(Color.WHITE);
        progressTitle.relocate(0, 50);
        progressBarTitle.getChildren().add(progressTitle);

        Text nextLevel = new Text();
        nextLevel.setText("  Next Level: " + (level+1) + " ");
        nextLevel.setFont(Font.font("Helvetica", 25));
        nextLevel.setStroke(Color.WHITE);
        nextLevel.relocate(0, 50);
        nextLevelPane.getChildren().add(nextLevel);

        Rectangle sq1 = new Rectangle(50, 50, PRIMARYGRAY);
        Rectangle sq2 = new Rectangle(50, 50, PRIMARYGRAY);
        Rectangle sq3 = new Rectangle(50, 50, PRIMARYGRAY);
        Rectangle sq4 = new Rectangle(50, 50, PRIMARYGRAY);


        Rectangle[] progressSquares = {sq1, sq2, sq3, sq4};

        for (int i=0; i<progressSquares.length; i++) {
            progressBar.add(progressSquares[i], i, 0);
        }

        progressBarTitle.setMinHeight(150);
        progressBarTitle.setMinWidth(100);

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
        storeShopsPane.setVgap(5);
        storeShopsPane.getRowConstraints().add(new RowConstraints(160));
        storeShopsPane.getRowConstraints().add(new RowConstraints(160));
        storeShopsPane.getRowConstraints().add(new RowConstraints(160));
        storeShopsPane.getRowConstraints().add(new RowConstraints(160));
        storeShopsPane.getColumnConstraints().add(new ColumnConstraints(400));
        GridPane shootingStar = new GridPane();
        shootingStar.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");
        shootingStar.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane satellite = new GridPane();
        satellite.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");
        satellite.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane redStar = new GridPane();
        redStar.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");
        redStar.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane blackHole = new GridPane();
        blackHole.setStyle("-fx-padding: 2;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");
        blackHole.setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY)));


        storeShopsPane.add(shootingStar, 0, 0);
        storeShopsPane.add(satellite, 0, 1);
        storeShopsPane.add(redStar, 0, 2);
        storeShopsPane.add(blackHole, 0, 3);
        storeShopsPane.setBackground((new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY))));



        // Grid Area
        gridOrganizer.add(storeShopsPane, 1, 1);
        gridOrganizer.add(storeNamePane, 1, 0);
        gridOrganizer.add(clickerPane,0,1);
        gridOrganizer.add(progressPane, 0,0 );

        // Click Controls
        Timeline animation;
        animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    updateCookies(coinPane);
                    changeLevel(nextLevelPane, nextLevel, progressSquares);
                    coins += (satelliteUpdate() + shootingUpdate() + redUpdate() + blackUpdate());
                })
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
        score.setText("  Cosmo Coins: " + coins + "  ");
        score.setFont(Font.font("Helvetica", 25));
        score.setStroke(Color.WHITE);
        score.relocate(0, 50);
        coinPane.getChildren().add(score);
    }

    public void changeLevel(Pane nextLevelPane, Text nextLevel, Rectangle[] progressSquares) {
        if (coins >= levelLimit) {
            nextLevelPane.getChildren().remove(nextLevel);
            level++;
            nextLevel.setText("  Next Level: " + (level + 1) + "  ");

            if (level == 1) {
                levelLimit = 10;
            } else if (level == 2) {
                levelLimit = 100;
            } else if (level == 3) {
                levelLimit = 1000;
            } else if (level == 4) {
                levelLimit = 10000;
            } else if (level == 5) {
                levelLimit = 100000;
            }

            for (Rectangle r : progressSquares) {
                r.setFill(PRIMARYGRAY);
            }

            nextLevelPane.getChildren().add(nextLevel);
        }
        if ((levelLimit / 4.00) * 3 <= coins) {
            progressSquares[0].setFill(Color.PURPLE);
            progressSquares[1].setFill(Color.PURPLE);
            progressSquares[2].setFill(Color.PURPLE);
        } else if ((levelLimit / 4.00) * 2 <= coins) {
            progressSquares[0].setFill(Color.PURPLE);
            progressSquares[1].setFill(Color.PURPLE);
        } else if ((levelLimit / 4.00) <= coins) {
            progressSquares[0].setFill(Color.PURPLE);
        }
    }
    public int shootingUpdate(){
        return shootingNum * 3;
    }

    public int satelliteUpdate(){
        return satNum * 5;
    }

    public int redUpdate(){
        return redNum * 15;
    }

    public int blackUpdate(){
        return blackNum * 25;
    }
}


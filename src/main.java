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

        //shooting star stuff
        shootingStar.getRowConstraints().add(new RowConstraints(100));
        shootingStar.getRowConstraints().add(new RowConstraints(60));
        shootingStar.getColumnConstraints().add(new ColumnConstraints(150));
        shootingStar.getColumnConstraints().add(new ColumnConstraints(250));
        Image shootingPic = new Image("star.png");
        ImageView shootingView = new ImageView(shootingPic);
        shootingView.setFitHeight(100);
        shootingView.setFitWidth(100);
        shootingView.relocate(0, 150);
        shootingStar.add(shootingView, 0, 0);
        Text sName = new Text("Shooting Star");
        sName.setFont(Font.font("Helvetica", 25));
        sName.setStroke(Color.WHITE);
        Text shootCount = new Text("     x" + shootingNum);
        shootCount.setFont(Font.font("Helvetica", 25));
        shootCount.setStroke(Color.WHITE);
        shootingStar.add(shootCount, 0, 1);
        Text shootDes = new Text("Produce 3 CosmoCoins per second \nfor 50 CosmoCoins!");
        shootDes.setFont(Font.font("Helvetica", 15));
        shootDes.setStroke(Color.WHITE);
        shootingStar.add(shootDes, 1, 1);
        shootingStar.add(sName, 1, 0);

        //satellite stuff
        satellite.getRowConstraints().add(new RowConstraints(100));
        satellite.getRowConstraints().add(new RowConstraints(60));
        satellite.getColumnConstraints().add(new ColumnConstraints(150));
        satellite.getColumnConstraints().add(new ColumnConstraints(250));
        Image satPic = new Image("sat.png");
        ImageView satView = new ImageView(satPic);
        satView.setFitHeight(100);
        satView.setFitWidth(100);
        satView.relocate(0, 150);
        satellite.add(satView, 0, 0);
        Text satName = new Text("Satellite");
        satName.setFont(Font.font("Helvetica", 25));
        Text satCount = new Text("     x" + satNum);
        satCount.setFont(Font.font("Helvetica", 25));
        satCount.setStroke(Color.WHITE);
        satellite.add(satCount, 0, 1);
        satName.setStroke(Color.WHITE);
        Text satDes = new Text("Produce 5 CosmoCoins per second \nfor 150 CosmoCoins!");
        satDes.setFont(Font.font("Helvetica", 15));
        satDes.setStroke(Color.WHITE);
        satellite.add(satDes, 1, 1);
        satellite.add(satName, 1, 0);

        // red giant stuff
        redStar.getRowConstraints().add(new RowConstraints(100));
        redStar.getRowConstraints().add(new RowConstraints(60));
        redStar.getColumnConstraints().add(new ColumnConstraints(150));
        redStar.getColumnConstraints().add(new ColumnConstraints(250));
        Image redPic = new Image("red.png");
        ImageView redView = new ImageView(redPic);
        redView.setFitHeight(100);
        redView.setFitWidth(100);
        redView.relocate(0, 150);
        redStar.add(redView, 0, 0);
        Text redName = new Text("Red Star");
        redName.setFont(Font.font("Helvetica", 25));
        redName.setStroke(Color.WHITE);
        Text redCount = new Text("     x" + redNum);
        redCount.setFont(Font.font("Helvetica", 25));
        redCount.setStroke(Color.WHITE);
        Text redDes = new Text("Produce 15 CosmoCoins per second \nfor 500 CosmoCoins!");
        redDes.setFont(Font.font("Helvetica", 15));
        redDes.setStroke(Color.WHITE);
        redStar.add(redDes, 1, 1);
        redStar.add(redCount, 0, 1);
        redStar.add(redName, 1, 0);

        blackHole.getRowConstraints().add(new RowConstraints(100));
        blackHole.getRowConstraints().add(new RowConstraints(60));
        blackHole.getColumnConstraints().add(new ColumnConstraints(150));
        blackHole.getColumnConstraints().add(new ColumnConstraints(250));
        Image blackPic = new Image("black.png");
        ImageView blackView = new ImageView(blackPic);
        blackView.setFitHeight(100);
        blackView.setFitWidth(100);
        blackView.relocate(0, 150);
        blackHole.add(blackView, 0,0);
        Text blackName = new Text("Black Hole");
        blackName.setFont(Font.font("Helvetica", 25));
        blackName.setStroke(Color.WHITE);
        Text blackCount = new Text("     x" + blackNum);
        blackCount.setFont(Font.font("Helvetica", 25));
        blackCount.setStroke(Color.WHITE);
        Text blackDes = new Text("Produce 25 CosmoCoins per second \nfor 1000 Cosmo Coins!");
        blackDes.setFont(Font.font("Helvetica", 15));
        blackDes.setStroke(Color.WHITE);
        blackHole.add(blackDes, 1, 1);
        blackHole.add(blackCount, 0, 1);
        blackHole.add(blackName, 1, 0);

        satellite.getColumnConstraints().add(new ColumnConstraints(150));
        satellite.getColumnConstraints().add(new ColumnConstraints(250));

        redStar.getColumnConstraints().add(new ColumnConstraints(150));
        redStar.getColumnConstraints().add(new ColumnConstraints(250));

        blackHole.getColumnConstraints().add(new ColumnConstraints(150));
        blackHole.getColumnConstraints().add(new ColumnConstraints(250));

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
            changeLevel(nextLevelPane, nextLevel, progressSquares);
        });

        blackView.setOnMouseClicked(e -> {
            System.out.println("in black\n");
            buyBlack(blackHole, blackCount);
        });

        satView.setOnMouseClicked(e -> {
            System.out.println("in sat\n");
            buySat(satellite, satCount);
        });

        redView.setOnMouseClicked(e -> {
            System.out.println("in red\n");
            buyRed(redStar, redCount);
        });

        shootingView.setOnMouseClicked(e -> {
            System.out.println("in shoot\n");
            buyRed(shootingStar, shootCount);
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

    public void buySat (GridPane satillite, Text satCount) {
        if (coins >= 150) {
            satillite.getChildren().remove(satCount);
            satNum++;
            coins -= 150;
            satCount = new Text("     x" + satNum);
            satCount.setFont(Font.font("Helvetica", 25));
            satCount.setStroke(Color.WHITE);
            satillite.add(satCount, 0, 1);
        }
    }

    public void buyBlack (GridPane blackHole, Text blackCount) {
        if (coins >= 1000) {
            blackHole.getChildren().remove(blackCount);
            blackNum++;
            coins -= 1000;
            blackCount = new Text("     x" + blackNum);
            blackCount.setFont(Font.font("Helvetica", 25));
            blackCount.setStroke(Color.WHITE);
            blackHole.add(blackCount, 0, 1);
        }
    }

    public void buyRed (GridPane redStar, Text redCount) {
        if (coins >= 500) {
            redStar.getChildren().remove(redCount);
            redNum++;
            coins -= 500;
            redCount = new Text("     x" + redNum);
            redCount.setFont(Font.font("Helvetica", 25));
            redCount.setStroke(Color.WHITE);
            redStar.add(redCount, 0, 1);
        }
    }

    public void buyShoot (GridPane shootingStar, Text shootCount) {
        if (coins >= 50) {
            shootingStar.getChildren().remove(shootCount);
            shootingNum++;
            coins -= 50;
            shootCount = new Text("     x" + shootingNum);
            shootCount.setFont(Font.font("Helvetica", 25));
            shootCount.setStroke(Color.WHITE);
            shootingStar.add(shootCount, 0, 1);
        }
    }
}


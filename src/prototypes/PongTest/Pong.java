

import java.util.Random;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Pong extends Application {

    // Game Settings
    private static final int width = 800;
    private static final int height = 600;
    private static final int PLAYER_WIDTH = 15;
    private static final int PLAYER_HEIGHT = 100;
    private static final double BALL_R = 15;
    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = height/2;
    private double playerTwoYPos = height/2;
    private double ballXPos = width/2;
    private double ballYPos = height/2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private boolean gameStarted;
    private int playerOneXPos = 0;
    private double playerTwoXPos = width - PLAYER_WIDTH;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("START");
        stage.setTitle("P O N G");
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        // mouse controls
        canvas.setOnMouseMoved(e -> playerOneYPos = e.getY());
        canvas.setOnMouseClicked(e -> gameStarted = true);

        //begin rendering
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc){
        // set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,height);

        //set textcolor
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if (gameStarted) {
            // move ball
            ballXPos += ballXSpeed;
            ballYPos += ballYSpeed;

            // computer movement


            // draw ball
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
        } else {
            // set start text
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("on Click", width / 2, height / 2);

            // reset ball to start position
            ballXPos = width / 2;
            ballYPos = height / 2;

            //reset speed and direction
            ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
            ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
        }

        // bounce ball off walls
        if (ballYPos > height - BALL_R || ballYPos < 0) ballYSpeed *= -1;

        //computer point check
        if (ballXPos < playerOneXPos - PLAYER_WIDTH) {
            scoreP2++;
            gameStarted = false;
        }

         //player point check
         if (ballXPos > playerTwoXPos + PLAYER_WIDTH) {
            scoreP1++;
            gameStarted = false;
        }

        //collision check
        if (((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) ||
        ((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)){
            ballXSpeed *= -1.1;
            ballYSpeed *= 1.1;
        }

        // draw score
        gc.fillText(scoreP1 + "\t\t\t\t" + scoreP2, width/2, 100);

        //draw players
        gc.fillRect(playerOneXPos,playerOneYPos, PLAYER_WIDTH,PLAYER_HEIGHT);
        gc.fillRect(playerTwoXPos,playerTwoYPos, PLAYER_WIDTH,PLAYER_HEIGHT);


    }

}
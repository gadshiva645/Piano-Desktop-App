import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.util.Duration;
import org.jfugue.player.Player;


import java.util.Random;



public class Main extends Application {
    private Button Sce3_btn1, Sce3_btn2, Sce3_btn3, Sce3_btn4, Sce3_btn5, Sce3_btn6, Sce3_btn7;
    private String colorCode;
    private int points;
    private int round;
    private Label roundLabel;
    private Label pointsLabel;
    private boolean gameModeEasy, gameModeNormal, gameModeHard;
    private int timerInterval;



    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        //initialize points to 0
        points = 0;

        //initialize round to 0
        round = 0;

        //the max rounds before it changes from scene 3 to 4
        int finalRound = 2;

        //intialize gameModes to false
        gameModeEasy = false;
        gameModeNormal = false;
        gameModeHard = false;


        //Scene 1
        //button creator code for scene1
        Button Sce1_btn1 = new Button("Start Game");


        //Scene 2
        //button creator code for scene1
        Button Sce2_btn1 = new Button("Easy");
        Button Sce2_btn2 = new Button("Medium");
        Button Sce2_btn3 = new Button("Hard");


        //Scene 3
        //new keyword - used for objects to allocating memory
        //create a player object for the piano sounds
        final Player player = new Player();

        //Text label for the points
        pointsLabel = new Label("Points: " + points);
        pointsLabel.setMinSize(50, 50);

        //Text label for the round
        roundLabel = new Label("Round: " + round);
        roundLabel.setMinSize(50, 50);

        //button creator code for scene3
        Sce3_btn1 = new Button("btn1");
        Sce3_btn2 = new Button("btn2");
        Sce3_btn3 = new Button("btn3");
        Sce3_btn4 = new Button("btn4");
        Sce3_btn5 = new Button("btn5");
        Sce3_btn6 = new Button("btn6");
        Sce3_btn7 = new Button("btn7");


        //Scene 4
        //Text label for the win text
        Label winLabel = new Label("You win!" );
        winLabel.setMinSize(50, 50);


        //generate a random hex color for the colorCode variable
        randomHexGenerator();


        //scene 1
        //object holder for buttons and labels for scene 1
        HBox hbox1 = new HBox(pointsLabel, Sce1_btn1);

        //scene and stage creater and setter
        Scene scene1 = new Scene(hbox1, 500, 500);


        //scene 2
        //object holder for buttons and labels for scene 2
        HBox hbox2 = new HBox(Sce2_btn1, Sce2_btn2, Sce2_btn3);

        //scene and stage creater and setter
        Scene scene2 = new Scene(hbox2, 500, 500);


        //scene 3
        //object holder for buttons and labels for scene
        //vertical box for labels and horizontal box for buttons and vbox
        VBox vBox1 = new VBox(pointsLabel, roundLabel);
        HBox hbox3 = new HBox(vBox1, Sce3_btn1, Sce3_btn2, Sce3_btn3, Sce3_btn4, Sce3_btn5, Sce3_btn6, Sce3_btn7);

        //scene and stage creater and setter
        Scene scene3 = new Scene(hbox3, 500, 500);


        //Scene 4
        //object holder for buttons and labels for scene 1
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(winLabel);

        //scene and stage creater and setter
        Scene scene4 = new Scene(borderPane, 500, 500);



        //Scene 1
        //button starts scene 2
        Sce1_btn1.setOnAction(event -> primaryStage.setScene(scene2));


        //Scene 2
        //button starts scene3
        Sce2_btn1.setOnAction(event -> {
            gameModeEasy = true;
            primaryStage.setScene(scene3);
            System.out.println("gameModeEasy = " + gameModeEasy);
            timerInterval = 5000;
            timer();
        });
        Sce2_btn2.setOnAction(event -> {
            gameModeNormal = true;
            primaryStage.setScene(scene3);
            System.out.println("gameModeNormal = " + gameModeNormal);
            timerInterval = 4000;
            timer();
        });
        Sce2_btn3.setOnAction(event -> {
            gameModeHard = true;
            primaryStage.setScene(scene3);
            System.out.println("GameModeHard = " + gameModeHard);
            timerInterval = 2000;
            timer();
        });



        //Scene 3
        //buttons functionality when clicked Scene 3
        Sce3_btn1.setMinSize(50, 200);
        Sce3_btn1.setOnAction(event -> {
            player.play("Cqq");
            String btn1Style = Sce3_btn1.getStyle();
            System.out.println(btn1Style);
            if (!Sce3_btn1.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }
        });

        Sce3_btn2.setMinSize(50, 200);
        Sce3_btn2.setOnAction(event -> {
            player.play("Dqq");
            if (!Sce3_btn2.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }
        });

        Sce3_btn3.setMinSize(50, 200);
        Sce3_btn3.setOnAction(event -> {
            player.play("Eqq");
            if (!Sce3_btn3.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }

        });

        Sce3_btn4.setMinSize(50, 200);
        Sce3_btn4.setOnAction(event -> {
            player.play("Fqq");
            if (!Sce3_btn4.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }

        });

        Sce3_btn5.setMinSize(50, 200);
        Sce3_btn5.setOnAction(event -> {
            player.play("Gqq");
            if (!Sce3_btn5.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }
        });

        Sce3_btn6.setMinSize(50, 200);
        Sce3_btn6.setOnAction(event -> {
            player.play("Aqq");
            if (!Sce3_btn6.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }
        });

        Sce3_btn7.setMinSize(50, 200);
        Sce3_btn7.setOnAction(event -> {
            player.play("Bqq");
            if (!Sce3_btn7.getStyle().equals("-fx-accent: #0093ff")) {
                pointsIncrement();
                roundIncrement();
            }
            if (round == finalRound){
                primaryStage.setScene(scene4);
            }
        });




        primaryStage.setScene(scene1);
        primaryStage.show();


    }

    //generate a random hex number for the buttons random color that needs to be clicked
    private void randomHexGenerator() {
        Random random = new Random();
        int nextInt = random.nextInt(0xffffff + 1);
        colorCode = String.format("#%06x", nextInt);
    }

    //timer that sets the colors of the buttons randomly based on the random number
    private void timer(){
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(timerInterval),
                ae -> {
                    int randomVar = (int) (Math.random() * ((6) + 1));
                    System.out.println(randomVar);
                    if (randomVar == 0) {
                        Sce3_btn1.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 1) {
//                    btn2.setStyle("-fx-background-color: #3e2863");
                        Sce3_btn2.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 2) {
                        Sce3_btn3.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 3) {
//                    btn4.setStyle("-fx-background-color: #3e2863");
                        Sce3_btn4.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 4) {
//                    btn5.setStyle("-fx-background-color: #3e2863");
                        Sce3_btn5.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 5) {
                        Sce3_btn6.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn7.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    } else if (randomVar == 6) {
                        Sce3_btn7.setStyle("-fx-background-color:" + colorCode);
                        Sce3_btn1.setStyle("-fx-accent: #0093ff");
                        Sce3_btn2.setStyle("-fx-accent: #0093ff");
                        Sce3_btn3.setStyle("-fx-accent: #0093ff");
                        Sce3_btn4.setStyle("-fx-accent: #0093ff");
                        Sce3_btn5.setStyle("-fx-accent: #0093ff");
                        Sce3_btn6.setStyle("-fx-accent: #0093ff");
                        randomHexGenerator();
                    }
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    //method to increment points
    private void pointsIncrement(){
        points++;
        System.out.println("Your color is differnt ");
        System.out.println("Your total points = " + points);
        pointsLabel.setText(String.valueOf("Points: " + points));
        System.out.println("Round: " + round);
    }

    //method to increment round
    private void roundIncrement(){
        if (points % 5 == 0){
            round++;
            roundLabel.setText(String.valueOf("Round: " + round));
        }

    }


}

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


    public class Main extends Application {
        public void start(Stage primaryStage) {

            GameScene.timer.start();
            GameScene.lifebar.setAttitude(3);

            primaryStage.setTitle("Runner");
            Group root = new Group();
            Pane pane = new Pane(root);
            Scene scene = new Scene(pane, 700, 400);

            GameScene.life();
            GameScene.hidegameOver();
            GameScene.hideclickRestart();

            primaryStage.setScene(scene);
            primaryStage.show();

            // Utilisation du clic : sauter + recommencer quand la partie est terminée
            pane.setOnMouseClicked( (event)->{

                // Saut
                if ((GameScene.heroRun.getAttitude() == 1)&(GameScene.lifebar.getAttitude()!=0)){
                    GameScene.heroRun.setAttitude(2);}

                // Recommencer le jeu
                if (GameScene.lifebar.getAttitude()==0){
                    GameScene.timer.start();
                    GameScene.fantome.restartGame();
                    GameScene.hidegameOver();
                    GameScene.hideclickRestart();

                }
            });

            // Pour que nos éléments s'affichent
            root.getChildren().add(GameScene.left.imageview);
            root.getChildren().add(GameScene.right.imageview);
            root.getChildren().add(GameScene.life.imageview);
            root.getChildren().add(GameScene.gameover.imageview);
            root.getChildren().add(GameScene.restartGame.imageview);
            root.getChildren().add(GameScene.lifebar.spriteSheet);
            root.getChildren().add(GameScene.heroRun.spriteSheet);
            root.getChildren().add(GameScene.fantome.spriteSheet);


        }

        public static void main(String[] args) {
            launch(args);
        }
    }


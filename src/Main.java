import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

    public class Main extends Application {

        public void start(Stage primaryStage) {
            primaryStage.setTitle("Background");
            Group root = new Group();
            Pane pane = new Pane(root);
            Scene scene = new Scene(pane, 1000, 400);

            GameScene.background();
            GameScene.lifebar();
            GameScene.hero();

            primaryStage.setScene(scene);
            primaryStage.show();


            // Pour faire afficher nos StaticThing dans notre fenêtre
            root.getChildren().add(GameScene.left.imageview);
            root.getChildren().add(GameScene.right.imageview);
            root.getChildren().add(GameScene.lifebar.imageview);
            //root.getChildren().add(GameScene.hero.imageview);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;

    public ImageView spriteSheet;
    private int attitude;

    private int index;      // index
    private static double duration;// durée entre 2 frames
    private int maxIndex;   // indice max
    private double lfen;    // longueur de la fenêtre
    private double hfen;    // hauteur de la fenêtre
    private static double offset;  // offset entre chaque frame

    // Setter
    public void setImageview(String fileName) {
        this.spriteSheet = new ImageView(fileName);
    }

    public void setDuration(double Duree) {
        this.duration = Duree;
    }

    public void setOffset(double offset){
        this.offset = offset;
    }

    // Constructeur
    public AnimatedThing(double x, double y, int attitude, int index, int maxIndex, double lfen, double hfen){
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
        this.lfen = lfen;
        this.hfen = hfen;

        spriteSheet.setViewport(new Rectangle2D(10,1,73,97));
    }

    // Getter
    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
}

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private double x;
    private double y;
    private double l;
    private double h;
    //Camera cam = new Camera(x,y);

    public static staticThing left = new staticThing(0,0,"C:\\Users\\Marin\\OneDrive - ensea.fr\\Documents\\Marine\\ENSEA\\2A\\2A - S7\\Informatique - Java\\runner\\desert.png");   // instanciation de 2 staticThing pour afficher le background
    public static staticThing right = new staticThing(800,0,"C:\\Users\\Marin\\OneDrive - ensea.fr\\Documents\\Marine\\ENSEA\\2A\\2A - S7\\Informatique - Java\\runner\\desert.png");   // instanciation de 2 staticThing pour afficher le background);

    public static staticThing lifebar = new staticThing(12,12,"C:\\Users\\Marin\\OneDrive - ensea.fr\\Documents\\Marine\\ENSEA\\2A\\2A - S7\\Informatique - Java\\runner\\lifebar.png");

    public static staticThing hero = new staticThing(200,255,"C:\\Users\\Marin\\OneDrive - ensea.fr\\Documents\\Marine\\ENSEA\\2A\\2A - S7\\Informatique - Java\\runner\\heros.png");

    //AnimationTimer timer = new AnimationTimer()
    //public void handle(long time){
    //    hero.update(time);
    //    camera.update(time);
    //    gameScene.update(time);
    //    }
    //}

    // Constructeur
    public GameScene(double x, double y, double l, double h, Group g){
        super(g);
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = h;
    }

    public static void background() {
        left.imageview.setX(left.getSTx()); // getSTx et getSTy sont les getters de staticThing
        left.imageview.setY(left.getSTy()); // cela nous permettra d'obtenir le x et le y de left et right

        right.imageview.setX(right.getSTx());
        right.imageview.setY(right.getSTy());
    }

    public static void lifebar(){
        lifebar.imageview.setX(lifebar.getSTx());
        lifebar.imageview.setY(lifebar.getSTy());
    }

    public static void hero(){
        hero.imageview.setViewport(new Rectangle2D(423,332,162,95));
        hero.imageview.setX(hero.getSTx());
        hero.imageview.setY(hero.getSTy());

    }
}


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

    public static staticThing left = new staticThing(0,0,"C:\\Users\\Marin\\IdeaProjects\\Runner\\img\\desert.png");   // instanciation de 2 staticThing pour afficher le background
    public static staticThing right = new staticThing(800,0,"C:\\Users\\Marin\\IdeaProjects\\Runner\\img\\desert.png");   // instanciation de 2 staticThing pour afficher le background);
    public static staticThing lifebar = new staticThing(20,12,"C:\\Users\\Marin\\IdeaProjects\\Runner\\img\\lifebar.png");
    public static Hero heroRun = new Hero(200,255,1,0,420,10,103,"C:\\Users\\Marin\\IdeaProjects\\Runner\\img\\heros.png");
    public static Hero heroJump = new Hero(200,255,2,0,85,10,103,"C:\\Users\\Marin\\IdeaProjects\\Runner\\img\\heros.png");

    // Animation du héro, timer
    static AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            try {
                Thread.sleep(40);             // Permet de contrôler la vitesse du héro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            heroRun.update(time);
            //camera.update(time);
            left.update(time);
            right.update(time);
        }
    };

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

    public static void heroRun(){
        heroRun.setAttitude(1);
        heroRun.spriteSheet.setViewport(new Rectangle2D(heroRun.getIndex(),0,80,100));
        heroRun.spriteSheet.setX(heroRun.getX());
        heroRun.spriteSheet.setY(heroRun.getY());
    }

    // L'update pour faire l'animation du background se situe dans staticThing


}



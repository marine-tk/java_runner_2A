import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {
    private double x;
    private double y;
    private double l;
    private double h;
    //Camera cam = new Camera(x,y);

    static Random rand = new Random();

    public static staticThing left = new staticThing(0,0,"desert.png");   // instanciation de 2 staticThing pour afficher le background
    public static staticThing right = new staticThing(800,0,"desert.png");   // instanciation de 2 staticThing pour afficher le background);

    public static Lifebar lifebar = new Lifebar(15,25,3,0,84,81,27,"lifebar.png");
    public static staticThing life = new staticThing(15,11,"life.png");
    public static staticThing gameover = new staticThing(150,174,"gameover.png");

    public static Hero heroRun = new Hero(200,255,1,0,425,10,103,"heros.png");
    public static Foe fantome = new Foe(801,280,0,0,0,74,57,"foe.png");


    // Animation du héro, timer
    static AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            try {
                Thread.sleep(60);             // Permet de contrôler la vitesse du héro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Perte de toutes les vies
            if (GameScene.lifebar.getAttitude()==0){
                GameScene.timer.stop();
                GameScene.gameOver();}

            // Invincibilité
            heroRun.invincibilite(time);
            if (fantome.getAttitude() == 0){ fantome.collision(time);}

            lifebar();
            heroRun.update(time);
            //camera.update(time);
            left.update(time);
            right.update(time);
            fantome.animationFoe(time);


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

    public static void life(){
        life.imageview.setX(life.getSTx());
        life.imageview.setY(life.getSTy());
    }

    public static void lifebar(){
        if (lifebar.getAttitude() == 3){
        lifebar.spriteSheet.setViewport(new Rectangle2D(lifebar.getIndex(),0,82,27));
        lifebar.spriteSheet.setX(lifebar.getX());
        lifebar.spriteSheet.setY(lifebar.getY());}

        if (lifebar.getAttitude() == 2){
            lifebar.spriteSheet.setViewport(new Rectangle2D(lifebar.getIndex()+28,0,82,27));
            lifebar.spriteSheet.setX(lifebar.getX());
            lifebar.spriteSheet.setY(lifebar.getY());}

        if (lifebar.getAttitude() == 1){
            lifebar.spriteSheet.setViewport(new Rectangle2D(lifebar.getIndex()+56,0,82,27));
            lifebar.spriteSheet.setX(lifebar.getX());
            lifebar.spriteSheet.setY(lifebar.getY());}

        if (lifebar.getAttitude() == 0){
            lifebar.spriteSheet.setViewport(new Rectangle2D(lifebar.getIndex()+84,0,82,27));
            lifebar.spriteSheet.setX(lifebar.getX());
            lifebar.spriteSheet.setY(lifebar.getY());}
    }

    public static void gameOver(){
        gameover.imageview.setX(gameover.getSTx());
        gameover.imageview.setY(gameover.getSTy());
    }

    public static void hidegameOver(){
        gameover.imageview.setX(-99999);
        gameover.imageview.setY(-99999);
    }

    public static void heroRun(){
        heroRun.setAttitude(1);
        heroRun.spriteSheet.setViewport(new Rectangle2D(heroRun.getIndex(),0,80,100));
        heroRun.spriteSheet.setX(heroRun.getX());
        heroRun.spriteSheet.setY(heroRun.getY());
    }

    public static void insertFantome(){
        int n = rand.nextInt(300);
        fantome.spriteSheet.setViewport(new Rectangle2D(fantome.getIndex(),0,74,57));
        fantome.spriteSheet.setX(fantome.getX());
        fantome.spriteSheet.setY(fantome.getY());
    }

    // L'update pour faire l'animation du background se situe dans staticThing


}



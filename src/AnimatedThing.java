import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    public ImageView spriteSheet;
    private int attitude;
    private int index;      // index
    private static double duration;// durée entre 2 frames
    private int maxIndex;   // indice max
    private double l;    // longueur de la fenêtre
    private double h;    // hauteur de la fenêtre
    private static double offset;  // offset entre chaque frame

    // Setter
    public void setImageview(String fileName) {
        this.spriteSheet = new ImageView(fileName);
    }
    public void setIndex(int ind) {this.index = ind;}
    public void setMaxIndex(int maxind) {this.maxIndex = maxind;}
    public void setAttitude(int att) {
        this.attitude = att;
    }

    // Constructeur
    public AnimatedThing(double x, double y, int attitude, int index, int maxIndex, double l, double h, String fileName) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
        this.l = l;
        this.h = h;
        setImageview(fileName);
    }

    // Getter
    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getIndex() {
        return index;
    }
    public int getAttitude() { return attitude;}

    // Remet tous les éléments en place pour le restart du jeu
    public void restartGame(){
        GameScene.lifebar.setAttitude(3);
        GameScene.heroRun.setAttitude(1);
        GameScene.fantome.setAttitude(0);
        GameScene.gaussianblur.setRadius(0);
        this.x = 1000;
    }

    // Animation du fantôme
    public void animationFoe(long time) {
        GameScene.insertFantome();
        if (this.x < -801) {
            this.x = 700;
        } else {
            this.x = this.x - 30;
        }
    }

    // Enlève l'invincibilité quand un ennemi réapparaît
    public void invincibilite(long time) {
        if (GameScene.fantome.getX() >= 695){ GameScene.fantome.setAttitude(0);}
    }

    // Collision du héros et de l'ennemi
    public void collision(long time) {
        if ((this.x <= 240  & this.x>200)& GameScene.heroRun.getY() >= 180) {

            this.setAttitude(1); // active l'invincibilité après collision
            GameScene.lifebar.setAttitude(GameScene.lifebar.getAttitude() - 1);

        }
    }

    // Update - Pour les animations du héros
    public void update(long time) {

        // Attitude 1 => le héros court
        if (this.attitude == 1) {
            GameScene.heroRun();
            if (this.index < this.maxIndex) {
                this.index = this.index + 85;
            } else {
                this.index = 0;
            }
        }

        // Attitude 2 => jump up
        if (this.attitude == 2) {
            GameScene.heroRun.jumpUp();
            this.y = this.y-25;
            if (this.y <=110){ this.setAttitude(3);}
        }

        // Attitude 3 => jump down
        if (this.attitude == 3) {
            GameScene.heroRun.jumpDown();

            if (this.y <= 255) {
                this.y = this.y + 25;
            }
            if (this.y >= 255) {
                this.setAttitude(1);
            }
        }




    }
}



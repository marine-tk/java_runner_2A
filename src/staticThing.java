import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    public ImageView imageview;

    // Setter
    public void setImageview(String fileName){
        imageview = new ImageView(fileName);
    }

    // Constructeur
    public staticThing(double x, double y, String fileName){
        this.x = x;
        this.y = y;
        setImageview(fileName);
    }

    // Getter
    public double getSTx(){
        return x;
    }
    public double getSTy(){
        return y;
    }

}

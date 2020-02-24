package imagegeneration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author me
 */
public class CanvasCreator extends Application{
    
    private static Pixel[][]    pixels_;
    private static int          width_;
    private static int          height_;
    private static final Canvas canvas_ = new Canvas();
    //private static boolean      sharp_;

    CanvasCreator(Pixel[][] pixels) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        pixels_ = pixels;
        width_  = pixels_.length;
        height_ = pixels_[0].length;
        genImage();

    }
    
    public void CanvasCreator(Pixel[][] pixels)
    {
        pixels_ = pixels;
        width_  = pixels_.length;
        height_ = pixels_[0].length;
        //sharp_  = sharp;
        
        genImage();
    }
    
    public static void genImage() //pass width, height, Pixel array
    {
        canvas_.setHeight(height_);
        canvas_.setWidth(width_);
        
        PixelWriter pw = canvas_.getGraphicsContext2D().getPixelWriter();
        
        for(int x = 0; x < width_; x++)
        {
            for(int y = 0; y < height_; y++)
            {
                //canvas.getGraphicsContext2D().getPixelWriter();
                pw.setColor(x, y, Color.rgb(pixels_[x][y].gr(), pixels_[x][y].gg(), pixels_[x][y].gb(), pixels_[x][y].ga()));
                
                //https://stackoverflow.com/questions/27846659/how-to-draw-an-1-pixel-line-using-javafx-canvas
                //https://stackoverflow.com/questions/28417623/the-fastest-filling-one-pixel-in-javafx
            }
        }
        
                

    }//end genImage
    
    @Override
    public void start(Stage primaryStage)
    {
        genImage();
        VBox root = new VBox(5, canvas_);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    
}

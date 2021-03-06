
package imagegeneration;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


//bg 34,38,44
//bt 121,152,255
//bt? 0,76,153
//fg 210,210,210
//tf 54,58,64




public class ImageGeneration extends Application {
    
    
    static Color bg = Color.rgb(34,  38,  44);
    static Color fg = Color.rgb(210, 210, 210);
    static Color bt = Color.rgb(121, 152, 255);
    static Color tf = Color.rgb(54,  58,  64);

    @Override
    public void start(Stage primaryStage) 
    {
        
        
        primaryStage.setTitle("Mapper");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(grid, bounds.getWidth()/2, bounds.getHeight()/2, bg);
        
        scene.getStylesheets().add("imagegeneration/imgGenSS.css");
        
        Text info = new Text("Select a button below to generate an image map.");
        info.setX(bounds.getWidth()/5);
        info.setY(bounds.getHeight()/5);
        info.setFont(Font.font("Ubuntu", FontWeight.BOLD, FontPosture.REGULAR, 25));
        info.setFill(fg);
        grid.add(info, 0,0);
        
        
        Button btn = new Button();
        btn.setText("RGB Noise");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attempting to launch new windo...");
                ConfigHandler config = new ConfigNoiseRGB(); 
                config.start(primaryStage);
            }
        });

        grid.add(btn, 0, 2);
        
        

        

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

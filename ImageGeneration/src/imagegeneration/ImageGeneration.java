
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
        
        //grid.setStyle("-fx-background-color: 34,38,44");
        //grid.setId("GridPane");


        

        
        //Group root = new Group();
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
        btn.setText("This is a Button");
//        btn.setStyle
//        (
//                " -fx-background-color: 121, 152, 255;\n"
//                //+ "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n"
//                //+ "        linear-gradient(#20262b, #191d22),\n"
//                //+ "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n"
//                + "    -fx-background-radius: 5,4,3,5;\n"
//                + "    -fx-background-insets: 0,1,2,0;\n"
//                + "    -fx-text-fill: white;\n"
//                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n"
//                + "    -fx-font-family: \"Ubuntu\";\n"
//                + "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n"
//                + "    -fx-font-size: 20px;\n"
//                + "    -fx-font-weight: bold;\n"
//                + "    -fx-padding: 10 20 10 20;"
//        );


        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Attempting to launch new windo...");
                ConfigHandler config = new ConfigHandler();
                
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagegeneration;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author me
 */
abstract public class ConfigHandler extends ImageGeneration {
    
    private static Pixel[][]    pixels_;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Generate Image Map");
        
        pixels_ = genMap();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                CanvasCreator cc = new CanvasCreator(pixels_); 
                cc.start(primaryStage);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add("imagegeneration/imgGenSS.css");
        
        primaryStage.setTitle("Configuration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    abstract Pixel[][] genMap();

}

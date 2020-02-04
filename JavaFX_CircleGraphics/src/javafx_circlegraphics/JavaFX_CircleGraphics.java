package javafx_circlegraphics;

import static java.lang.Math.random;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFX_CircleGraphics extends Application
{//begin Class
    
    public static void main(String[] args)
    {//begin main
        launch(args);
    }//end main
    
    @Override
    public void start(Stage primaryStage)
    {//Begin start

        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK); //create new scene with window 800x600px black background
        primaryStage.setScene(scene);
        
        
        Group circles = new Group();
        for (int i = 0; i < 30; i++) 
        {
            Circle circle = new Circle(150, Color.web("white", 0.05)); //create a white circle .05 alpha
            circle.setStrokeType(StrokeType.OUTSIDE); 
            //stroke is applied by extending the boundary of a closed Shape node outside its interior by a distance specified by the strokeWidth.
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle); //adding new circle to circles group
        }

        Rectangle colors = new Rectangle
        (
                
            scene.getWidth(), //pass scene width to rectangle
            scene.getHeight(), //pass scene height to rectangle
            new LinearGradient
            (
                0f, //startX    the X coordinate of the gradient axis start point
                1f, //startY    the Y coordinate of the gradient axis start point
                1f, //endX      the X coordinate of the gradient axis end point
                0f, //endY      the Y coordinate of the gradient axis end point
                true, //bool proportional   whether the coordinates are proportional to the shape which this gradient fills
                CycleMethod.NO_CYCLE, //cycleMethod     cycle method applied to the gradient
                new Stop[] //stops      the gradient's color specification (Can also pass a list of stops)
                {
                    /*
                    new Stop(0.00,   Color.web("#f8bd55")),
                    new Stop(0.14,   Color.web("#c0fe56")),
                    new Stop(0.28,   Color.web("#5dfbc1")),
                    new Stop(0.43,   Color.web("#64c2f8")),
                    new Stop(0.57,   Color.web("#be4af7")),
                    new Stop(0.71,   Color.web("#ed5fc2")),
                    new Stop(0.85,   Color.web("#ef504c")),
                    new Stop(1.00,   Color.web("#f2660f")),
                    */
                    
                    /*
                    new Stop(0.00,   Color.RED),
                    new Stop(0.14,   Color.ORANGE),
                    new Stop(0.28,   Color.YELLOW),
                    new Stop(0.43,   Color.GREEN),
                    new Stop(0.57,   Color.TURQUOISE),
                    new Stop(0.71,   Color.BLUE),
                    new Stop(0.85,   Color.BLUEVIOLET),
                    new Stop(1.00,   Color.VIOLET),
                    */
                    
                    new Stop(0.00,   Color.RED),
                    new Stop(0.14,   Color.ORANGE),
                    new Stop(0.28,   Color.RED),
                    new Stop(0.43,   Color.ORANGE),
                    new Stop(0.57,   Color.TURQUOISE),
                    new Stop(0.71,   Color.RED),
                    new Stop(0.85,   Color.ORANGE),
                    new Stop(1.00,   Color.RED),
                    
                }
            )
        );
        
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        
        //root.getChildren().add(colors);
        //root.getChildren().add(circles);
        
        Group blendModeGroup =
                new Group
                (
                    new Group
                    (
                        new Rectangle
                        (
                            scene.getWidth(),
                            scene.getHeight(),
                            Color.BLACK
                        ), circles
                    ), colors
                );
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        
        circles.setEffect(new BoxBlur(10, 10, 3));
        
        //Start displacement
        
        FloatMap waveMap = new FloatMap();
        waveMap.setWidth((int)(scene.getWidth()));
        waveMap.setHeight((int)(scene.getHeight()));
        
        FloatMap fractalMap = new FloatMap();
        fractalMap.setWidth((int)(scene.getWidth()));
        fractalMap.setHeight((int)(scene.getHeight()));
        
        //WAVY floatmap
        
        for (int i = 0; i < (int)(scene.getWidth()); i++) 
        {
            double v = (Math.sin(i / 20.0 * Math.PI) - 0.5) / 40.0;
            for (int j = 0; j < (int)(scene.getHeight()); j++)
            {
                waveMap.setSamples(i, j, 0.0f, (float) v);
            }
        }
        
        
        //Random displacement fractal
        Noise noise = new Noise(null, 5, (int)(scene.getWidth()), (int)(scene.getHeight())); //rand, roughness, width, height
        //Noise noise = new Noise(null, 1.0f, 10, 10); //rand, roughness, width, height
        noise.initialise();
        //noise.printAsCSV();

        for (int i = 0; i < (int)(scene.getWidth()); i++) 
        {

            for (int j = 0; j < (int)(scene.getHeight()); j++)
            {
                fractalMap.setSamples(i, j, 0.0f, (float)noise.gridValue(i, j)*2);
            }
        }
        
        DisplacementMap displacementMap = new DisplacementMap();
        //displacementMap.setMapData(waveMap);
        displacementMap.setMapData(fractalMap);

        
        circles.setEffect(displacementMap);
        
        //End Displacement
        
        Timeline timeline = new Timeline();
        for (Node circle: circles.getChildren()) //creates a set of positions on scene for each circle in circle group
        {
            timeline.getKeyFrames().addAll
                (
                    new KeyFrame
                    (
                        Duration.ZERO, // set start position at 0
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600)
                    ),

                    new KeyFrame(new Duration(1000), //pos at 10s
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600)
                    ),
                    
                    new KeyFrame(new Duration(2000), //20s
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600)
                    ),
                    
                    new KeyFrame(new Duration(3000), //30s
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600)
                    ),
                    
                    new KeyFrame(new Duration(4000), // set end position at 40s
                        new KeyValue(circle.translateXProperty(), random() * 800),
                        new KeyValue(circle.translateYProperty(), random() * 600)
                    )
                );
        }
        // play 40s of animation
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event) 
            {
                timeline.setRate(timeline.getRate()*-1);
                timeline.play();
            }
        });
        primaryStage.show();
    }//end start


    
}//end Class

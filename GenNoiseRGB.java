/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagegeneration;

import java.util.Random;

/**
 *
 * @author mwhitmore5
 */
public class GenNoiseRGB {
    
    private int width;
    private int height;
    
    public GenNoiseRGB()
    {
        
    }
    
    public GenNoiseRGB(int width )
    {
        this.width = width;
    }
    public static Pixel[][] getMap()
    {
        Pixel pixels[][] = new Pixel[1000][1000];
        
        Random rand = new Random();
        
        for(int i = 0; i<1000; i++)
        {
            for(int j = 0; j<1000; j++)
            {

                pixels[i][j] = new Pixel(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),1);
                
            }
        }
        
        return pixels;
    }
    
        public static Pixel[][] getMap(int width, int height)
    {
        Pixel pixels[][] = new Pixel[width][height];
        
        Random rand = new Random();
        
        for(int i = 0; i<height; i++)
        {
            for(int j = 0; j<width; j++)
            {

                pixels[i][j] = new Pixel(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),1);
                
            }
        }
        
        return pixels;
    }
}

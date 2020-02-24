/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagegeneration;

/**
 *
 * @author mwhitmore5
 */
public class ConfigNoiseRGB extends ConfigHandler{
    

    @Override
    Pixel[][] genMap()
    {
        return GenNoiseRGB.getMap();
    }
}

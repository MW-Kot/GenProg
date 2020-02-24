
package imagegeneration;

/**
 *
 * @author me
 */
public class Pixel {
    
    private int r_;
    private int g_;
    private int b_;
    private int a_;

    public Pixel(int r, int g, int b)
    {
        r_ = r;
        g_ = g;
        b_ = b;
        a_ = 255;
    }
    
    public Pixel(int r, int g, int b, int a)
    {
        r_ = r;
        g_ = g;
        b_ = b;
        a_ = a;
    }
    
    public Pixel(int v)
    {
        r_ = v;
        g_ = v;
        b_ = v;
        a_ = 255;
    }
    
    public Pixel(int v, int a)
    {
        r_ = v;
        g_ = v;
        b_ = v;
        a_ = a;
    }
    
    public Pixel()
    {
        r_ = 0;
        g_ = 0;
        b_ = 0;
        a_ = 255;
    }
    
    public void sr(int r) //set red
    {
        r_ = r;
    }
    
    public void sg(int g) //set green
    {
        g_ = g;
    }

    public void sb(int b) //set blue
    {
        b_ = b;
    }

    public void sa(int a) //set alpha
    {
        a_ = a;
    }

    public int gr() //get red
    {
        return r_;
    }
    
    public int gg() //get green
    {
        return g_;
    }

    public int gb() //get blue
    {
        return b_;
    }

    public int ga() //get alpha
    {
        return a_;
    } 
    
    public String grgb() //get alpha
    {
        return "" + r_ + ", " + g_ + ", " + b_ + "";
    }   
}

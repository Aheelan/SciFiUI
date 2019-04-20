package ie.tudublin;

import java.util.ArrayList;
import processing.core.*;

public class test extends PApplet
{
     ShipDesign ship;

     public void settings()
    {
        size(800, 700);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        ship= new ShipDesign(this);
    }

    public void draw()
    {
        background (255);
        ship.design();
}
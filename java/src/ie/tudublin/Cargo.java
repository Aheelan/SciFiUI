package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Cargo extends PApplet
{
    UI ui;
    public float x= 400;
    public float y= 300;
    public float nx= 150;
    public float ny= 100;

    public Cargo(UI ui)
    {
       this. ui= ui;
    }

    public void cargo1()
    {
        ui.fill(10,100,20);
        ui.rect(x,y,nx,ny);
        
        ui.stroke(0);
        ui.line(x+nx/3,y,x+nx/3,y+ny);
        ui.line(x+(nx/3)*2,y,x+(nx/3)*2,y+ny);

        ui.line(x,y+ny/3,x+nx,y+ny/3);
        ui.line(x,y+(ny/3)*2,x+nx,y+(ny/3)*2);
    }
}
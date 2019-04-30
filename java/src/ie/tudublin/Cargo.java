package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Cargo extends PApplet
{
    UI ui;
    private float x= 400;
    private float y= 300;
    private float nx= 150;
    private float ny= 100;
    private float nny= ny/4;
    private float nnx= nx/4;
    private float spc;
    private float space;


    public Cargo(UI ui)
    {
       this. ui= ui;
    }

    public void cargo1()
    {
        spc= 0;
        space= 0;

        ui.fill(10,100,20);
        ui.rect(x,y,nx,ny);
        
        ui.stroke(0);
        for(int i=0;i<5;i++)
        {
            ui.line(x+spc,y,x+spc,y+ny);
            ui.line(x,y+space,x+nx,y+space);

            spc= spc+nnx;
            space= space+nny;
        }
    }

    public void bomb()
    {
        spc= 20;
        space= 20;

        ui.fill(100,10,20);
        ui.rect(x,y,nx,ny);

        ui.stroke(0);
        ui.fill(10);
        ui.rect(x+10,y,10,ny);
        ui.rect(x+nx-20,y,10,ny);
        
      /* ui.stroke(0);
        for(int i=0;i<3;i++)
        {
            ui.line(x+spc,y,x+spc,y+ny);
            ui.line(x,y+space,x+nx,y+space);

            spc= spc+30;
            space= space+nny;
        }*/
    }
}
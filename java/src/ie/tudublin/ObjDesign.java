package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class ObjDesign extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float r1=10;
    private float r2=20;
    private PShape star;
    private float choice= random(4);
    private float scount =0;

    public ObjDesign(UI ui, float x, float y)
    {
       this.ui= ui;
       this.x= x;
       this.y= y;
    }

    public void str()
    {
        star= ui.createShape();
        ui.beginShape();
        ui.vertex(x-2, y+2);
        ui.vertex(x, y);
        ui.vertex(x+2, y+2);
        ui.vertex(x, y+4);
        ui.endShape();

        ui.shape(star);
    }

    public void shoot()
    {
        if (scount>200)
        {
            x=random(1000);
            y=random(700);
            choice= random(4);
            scount=0;
        }
        scount++;

        switch((int)choice) {
            case 0:
                x+=random(r1,r2);
                y-=random(r1,r2);
              break;
            case 1:
                x+=random(r1,r2);
                y+=random(r1,r2);
            break;
            case 2:
                x-=random(r1,r2);
                y+=random(r1,r2);
            break;
            case 3:
                x-=random(r1,r2);
                y-=random(r1,r2);
            break;
            default:
        }
    }
}
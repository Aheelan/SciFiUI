package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Textbox extends PApplet
{
    UI ui;
    private float x;
    private float y;

    public Textbox(UI ui, float x, float y)
    {
       this.ui= ui;
       this.x= x;
       this.y= y;
    }

    public void render()
    {
        ui.fill(240,230,250);
        ui.rect(x,y,50,30);
    }
}
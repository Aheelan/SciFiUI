package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Textbox extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private String text;

    public Textbox(UI ui, float x, float y, String text)
    {
       this.ui= ui;
       this.x= x;
       this.y= y;
       this.text = text;
    }

    public void render()
    {
        ui.fill(100,180,100,150);
        ui.rect(x,y,x,y);
        ui.fill(250,110,180);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + x/2, y+y/2);
    }
}
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Textbox extends PApplet
{
    UI ui;
    private float x;
    private float y;
    private float x1;
    private String text;

    public Textbox(UI ui, float x, float y, String text)
    {
       this.ui= ui;
       this.x= x;
       this.y= y;
       this.text = text;
       this.x1= x+20;
    }

    public void render()
    {
        ui.fill(100,180,100,150);
        ui.noStroke();

        ui.triangle(x,y+25, x1,y, x1,y+50);
        ui.rect(x1,y,x,50);

        ui.fill(250,110,180);

        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x1 + x/2, y+25);
    }
}
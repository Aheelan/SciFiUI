package ie.tudublin;

import processing.core.PApplet;

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

    public float getVar(int y1)
    {
        y1+=y;
        return y1;
    }

    public void sMessage()
    {
        ui.rect(x,y-100,x,50);
       
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(0);
        ui.text(text, x + x/2, y-75);
    }

    public void render()
    {
        ui.fill(100,100,180,100);
        ui.noStroke();

        ui.triangle(x,y+25, x1,y, x1,y+50);
        ui.rect(x1,y,x,50);

        ui.fill(255);

        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x1 + x/2, y+25);
    }
}
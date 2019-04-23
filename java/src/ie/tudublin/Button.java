package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private int opVal;

    public Button(UI ui, float x, float y, float width, float height, String text, int opVal)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.opVal=opVal;
    }

    public float getVar()
    {
        return width;
    }

    public int getOp()
    {
        return opVal;
    }

    public void render()
    {
        ui.fill(100,20,20);
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.fill(100,120,250);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }
}
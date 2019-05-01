package ie.tudublin;

public class Hud
{
    UI ui;
    private float width;
    private float height;
    private float alpha = 50;

    public Hud(UI ui, float width, float height)
    {
        this.ui = ui;
        this.width = width;
        this.height = height;
    }

    public void render()
    {   
        //ui.noStroke();
        ui.fill(50, 150, 255, alpha);
        //ui.rect(width/4*3, 0, width, height);
        ui.rect(0, 0, width/4, height);
    }
}
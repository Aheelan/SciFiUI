package ie.tudublin;

public class radar
{
    UI ui;
    private float circleX;
    private float circleY;
    private float diameter;
    private float radius;
    private float x;
    private float y;   
    private float theta; 
    private float frequency =1;
    private float timeDelta = 1.0f/60.0f;
    private double TWO_PI = 6.2831855; 

    public radar(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    public void render()
    {
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(x, y, diameter, diameter);
        circleX = x + (float) Math.sin(theta) * radius;
        circleY = y - (float) Math.cos(theta) * radius;
        ui.line(x, y, circleX, circleY);
    }

    public void update()
    {
        theta += TWO_PI * timeDelta * frequency;
    }
}

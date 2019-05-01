package ie.tudublin;

public class RadarScan
{
    UI ui;
    protected float circleX;
    protected float circleY;
    protected float diameter;
    protected float radius;
    protected float x;
    protected float y;   
    protected float theta; 
    protected float freq =1;
    private float timeDelta = 1.0f/60.0f;
    protected double TwoPi = 6.2831855; 

    public RadarScan(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    public void face()
    {
        ui.strokeWeight(5);
        ui.ellipse(x, y, diameter, diameter);
    }

    public void render()
    {
        ui.strokeWeight(5);
        circleX = x + (float) Math.sin(theta) * radius;
        circleY = y - (float) Math.cos(theta) * radius;
        ui.line(x, y, circleX, circleY);
        ui.strokeWeight(1);
    }

    public void update()
    {
        ui.fill(240);
        ui.stroke(10,20,30);
        timeDelta = 1.0f/60.0f;
        theta += TwoPi * timeDelta * freq;
    }
}

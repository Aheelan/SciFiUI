package ie.tudublin;

public class Radar
{
    UI ui;
    private float circleX;
    private float circleY;
    private float diameter;
    private float radius;
    private float x;
    private float y;   
    private float theta; 
    private float freq =1;
    private float timeDelta = 1.0f/60.0f;
    private double TwoPi = 6.2831855; 

    public Radar(UI ui, float x, float y, float diameter)
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

    public void time()
    {
        float cirx= circleX;
        float ciry= circleY;
        float circx= circleX;
        float circy= circleY;
        float tht=0;
        float td= 1.0f/60.0f;

        for(int i=0;i<100;i++)
        {
            ui.stroke(255);
            ui.strokeWeight(2);
            cirx = x + (float) Math.sin(tht) * (radius/100*95);
            ciry = y - (float) Math.cos(tht) * (radius/100*95);
            circx = x + (float) Math.sin(tht) * (radius/100*85);
            circy = y - (float) Math.cos(tht) * (radius/100*85);
            ui.line(circx, circy, cirx, ciry);
            ui.strokeWeight(1);
            tht += TwoPi * td * freq;
        }
    }

    public void update()
    {
        ui.fill(240);
        ui.stroke(10,20,30);
        theta += TwoPi * timeDelta * freq;
    }

    public void timer()
    {
        ui.fill(10,30,50);
        ui.stroke(0);
        timeDelta = 0.1f/160.0f;
        theta += TwoPi * timeDelta * freq;
    }
}

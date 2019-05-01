package ie.tudublin;

public class Timer extends RadarScan
{
    private float cirx;
    private float ciry;
    private float circx;
    private float circy;
    private float timeDelta = 0.1f/160.0f; 

    public Timer(UI ui, float x, float y, float diameter)
    {
        super(ui,x,y,diameter);
    }

    public void time()
    {
        cirx= circleX;
        ciry= circleY;
        circx= circleX;
        circy= circleY;
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
        ui.fill(10,30,50);
        ui.stroke(0);
        theta += TwoPi * timeDelta * freq;
    }
}
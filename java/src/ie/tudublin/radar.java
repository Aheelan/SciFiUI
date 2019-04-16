package ie.tudublin;

public class radar
{
    private float circleX;
    private float circleY;
    private float lineX;
    private float lineY= 0;
    private float diameter;
    private float radius;
    UI ui;

    public radar(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.circleX = x;
        this.circleY = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
        lineX = circleX+radius;
        lineY = circleY;
    }

    public void render()
    {
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(circleX, circleY, diameter, diameter);
        ui.line(circleX, circleY, lineX, lineY);
    }

    public void update()
    {
        if(lineX<=circleX-radius)
        {
            lineX++;
        }
        else
        {
            lineX--;
        }
        if(lineY<=circleY-radius)
        {
            lineY++;
        }
        else
        {
            lineY--;
        }
    }
}

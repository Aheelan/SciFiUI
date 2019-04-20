package ie.tudublin;

import java.util.ArrayList;

import processing.core.*;

public class ShipDesign extends PApplet
{
    UI ui;
    public float swidth;
    public float sheight;
    public float cwidth;
    public float cheight;
    public float bwidth;
    public float bheight;
    public PShape baseShip, nose, body, rear;

    public ShipDesign(UI ui)
    {
       this. ui= ui;
    }

    public void design()
    {
        baseShip = ui.createShape(GROUP);
        ui.fill(255);
        ui.noStroke();

        rear = ui.createShape();
        ui.beginShape();
        ui. vertex(350, 250);
        ui.bezierVertex(200, 250, 200, 450, 350, 450);
        ui.endShape();
        
        nose = ui.createShape();
        ui.beginShape();
        ui.vertex(450, 250);
        ui.bezierVertex(600, 280, 600, 420, 450, 450);
        ui.endShape();
        
        body = ui.createShape(RECT,350,250,100,200);

        baseShip.addChild(nose);
        baseShip.addChild(body);
        baseShip.addChild(rear);

        ui.shape(baseShip);
    }

    public void design1()
    {
        ui.fill(200,110,120);
        ui.triangle(310, 270, 450, 250, 310, 170);
        ui.triangle(310, 430, 450, 450, 310, 530);

        ui.stroke(255, 255, 255);
        ui.fill(255, 255, 255);
        //ui.ellipse(350, 350, 150, 50); 

        ui.bezier(350, 250, 200, 250, 200, 450, 350, 450);

        ui.rect(350,250,100,200);

        //ui.stroke(255, 102, 0);
        //ui.line(350, 250, 500, 250);
        //ui.line(500, 450, 350, 450);
        ui.bezier(450, 250, 600, 280, 600, 420, 450, 450);

        ui.fill(200,110,120);
        //ui.stroke(255, 102, 0);
        //ui.line(300, 320, 400, 320);
        //ui.line(400, 380, 300, 380);
        ui.bezier(300, 320, 400, 320, 400, 380, 300, 380);
   
        ui.stroke(200,110,120);
        //ui.line(450, 250, 450, 350);
        //ui.line(450, 350, 570, 350);
        ui.triangle(450, 250, 450, 350, 563, 350);
        //ui.fill(100,210,120);
        ui.bezier(450, 250, 500, 250, 565, 300, 563, 350);
    }

    /*public void render()
    {
        ui.translate(50, 15);
        ui.shape(baseShip);
    }*/

    public void movement()
    {
           
    }
}
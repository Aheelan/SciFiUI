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
    public PShape layer1, subLayer1, wing1, wing2, thruster, window1, window2;

    public ShipDesign(UI ui)
    {
       this. ui= ui;
    }

    public void bDesign1()
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

        //ui.shape(subLayer1);
        ui.shape(baseShip);
    }

    public void l1design1()
    {
        layer1 = ui.createShape(GROUP);
        subLayer1 = ui.createShape(GROUP);

        ui.fill(200,110,120);
        ui.stroke(200,110,120);

        wing1 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(310, 270,200);
        ui.vertex(450, 250,200);
        ui.vertex(310, 170,200);
        ui.endShape();
        
        wing2 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(310, 430);
        ui.vertex(450, 450);
        ui.vertex(310, 530);
        ui.endShape();
       
        window1 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(450, 250);
        ui.vertex(450, 350);
        ui.vertex(563, 350);
        ui.endShape();

        window2 = ui.createShape();
        ui.beginShape();
        ui.vertex(450, 250);
        ui.bezierVertex(500, 250, 565, 300, 563, 350);
        ui.endShape();

        thruster = ui.createShape();
        ui.beginShape();
        ui.vertex(300, 320);
        ui.bezierVertex(400, 320, 400, 380, 300, 380);
        ui.endShape();

        subLayer1.addChild(wing1);
        subLayer1.addChild(wing2);
        layer1.addChild(window1);
        layer1.addChild(window2);
        layer1.addChild(thruster);

        ui.shape(layer1);
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
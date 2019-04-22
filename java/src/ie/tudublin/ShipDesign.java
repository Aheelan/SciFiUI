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
    public PShape layer1, Layer2, wing1, wing2, thruster, window1, window2;

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

        ui.shape(baseShip);
    }

    public void l1Design1()
    {
        layer1 = ui.createShape(GROUP);

        ui.fill(200,110,120);
        ui.stroke(200,110,120);
       
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

        layer1.addChild(window1);
        layer1.addChild(window2);
        layer1.addChild(thruster);

        ui.shape(layer1);
    }

    public void l2Design1()
    {
        Layer2 = ui.createShape(GROUP);

        ui.fill(200,110,120);
        ui.stroke(200,110,120);

        wing1 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(310, 270);
        ui.vertex(450, 250);
        ui.vertex(310, 170);
        ui.endShape();
        
        wing2 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(310, 430);
        ui.vertex(450, 450);
        ui.vertex(310, 530);
        ui.endShape();

        Layer2.addChild(wing1);
        Layer2.addChild(wing2);

        ui.shape(Layer2);
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
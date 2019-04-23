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
        ui. vertex(450, 250);
        ui.bezierVertex(300, 250, 300, 450, 450, 450);
        ui.endShape();
        
        nose = ui.createShape();
        ui.beginShape();
        ui.vertex(550, 250);
        ui.bezierVertex(700, 280, 700, 420, 550, 450);
        ui.endShape();
        
        body = ui.createShape(RECT,450,250,100,200);

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
        ui.vertex(550, 250);
        ui.vertex(550, 350);
        ui.vertex(663, 350);
        ui.endShape();

        window2 = ui.createShape();
        ui.beginShape();
        ui.vertex(550, 250);
        ui.bezierVertex(600, 250, 665, 300, 663, 350);
        ui.endShape();

        thruster = ui.createShape();
        ui.beginShape();
        ui.vertex(400, 320);
        ui.bezierVertex(500, 320, 500, 380, 400, 380);
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
        ui.vertex(410, 270);
        ui.vertex(550, 250);
        ui.vertex(410, 170);
        ui.endShape();
        
        wing2 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(410, 430);
        ui.vertex(550, 450);
        ui.vertex(410, 530);
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
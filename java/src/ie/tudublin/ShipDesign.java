package ie.tudublin;

import java.util.ArrayList;

import processing.core.*;

public class ShipDesign extends PApplet
{
    UI ui;
   // private float maxm= 450;
   // private float mx= 5;
   // private float my= 0;
    private float rx= 450;
    private float ry= 250;
    private float bx= 450;
    private float by= 250;
    private float nx= 550;
    private float ny= 250;
    private PShape baseShip, nose, body, rear;

    private float wx= 550;
    private float wy= 250;
    private float winx= 550;
    private float winy= 250;
    private float tx= 400;
    private float ty= 320;
    private PShape layer1, Layer2, wing1, wing2, thruster, window1, window2;

    public float ent= 0;
    private float trax= -700;

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
        ui. vertex(rx, ry);
        ui.bezierVertex(rx-150, ry, rx-150, 450, rx, ry+200);
        ui.endShape();
        
        nose = ui.createShape();
        ui.beginShape();
        ui.vertex(nx, ny);
        ui.bezierVertex(nx+150, ny+30, nx+150, ny+170, nx, 450);
        ui.endShape();
        
        body = ui.createShape(RECT,bx,by,100,200);

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
        ui.vertex(wx, wy);
        ui.vertex(wx, wy+100);
        ui.vertex(wx+113, wy+100);
        ui.endShape();

        window2 = ui.createShape();
        ui.beginShape();
        ui.vertex(winx, winy);
        ui.bezierVertex(winx+50, winy, winx+115, winy+50, winx+113, 350);
        ui.endShape();

        thruster = ui.createShape();
        ui.beginShape();
        ui.vertex(tx, ty);
        ui.bezierVertex(tx+100, ty, tx+100, ty+60, tx, 380);
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
        ui.vertex(wx-140, wy+20);
        ui.vertex(wx, wy);
        ui.vertex(wx-140, wy-80);
        ui.endShape();
        
        wing2 = ui.createShape();
        ui.beginShape(TRIANGLE_STRIP);
        ui.vertex(wx-140, wy+180);
        ui.vertex(wx, wy+200);
        ui.vertex(wx-140, wy+280);
        ui.endShape();

        Layer2.addChild(wing1);
        Layer2.addChild(wing2);

        ui.shape(Layer2);
    }

    public void move()
    {   
        if(ent==10)
        {
            ent=20;
            trax=0;
        }
        if(ent==0)
        {
            ui.translate(trax,0);
            trax+=20;

            if(trax==0)
            {
                ent=1;
            }
        }
        else if(ent==20)
        {
            ui.translate(trax,0);
            trax+=20;

            if(trax==1200)
            {
                ent=0;
                trax=-600;
            }
        }
        
    }
}
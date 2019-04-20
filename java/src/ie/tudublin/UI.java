package ie.tudublin;

import java.util.ArrayList;
import processing.core.*;

public class UI extends PApplet
{
    Button b;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    MovingCircle mc;
    radar r;
    Hud hud;
    Textbox tbox;

    ShipDesign ship;
    ship move;
    Cargo cargo;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 700);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 0, 50, width/4, 50, "Scan first Layer");
        b1 = new Button(this, 0, 150, width/4, 50, "I am a button");
        b2 = new Button(this, 0, 250, width/4, 50, "I am a button");
        b3 = new Button(this, 0, 350, width/4, 50, "I am a button");
        b4 = new Button(this, 0, 450, width/4, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new radar(this, width / 2, height / 2, 120);
        ship= new ShipDesign(this);
        hud = new Hud(this, width, height);
        tbox = new Textbox(this, width/4, 50);
        cargo = new Cargo(this);
        move =new ship(this);
    }

    public void draw()
    {
        background(0);
        
        pushMatrix();
        //translate(20,20);

        //cargo.cargo1();
        
        /*for(int i=0; i<10; i++)
        {
            move.movement();
           
        }*/
        ship.design1();
        popMatrix();

        hud.render();
        b.render();
        b1.render();
        b2.render();
        b3.render();
        b4.render();
        
        tbox.render();

      
        /*mc.update();
        mc.render();

        r.update();
        r.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }*/
    }
}


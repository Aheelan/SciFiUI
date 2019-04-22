package ie.tudublin;

import java.util.*;
import processing.core.*;

public class UI extends PApplet
{
    MovingCircle mc;
    radar r;
    Hud hud;

    ShipDesign ship;
    ship move;
    Cargo cargo;

    ArrayList<Button> buttons =new ArrayList<Button>();
    ArrayList<Textbox> tbox =new ArrayList<Textbox>();
   
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
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new radar(this, width / 2, height / 2, 120);
        ship= new ShipDesign(this);
        hud = new Hud(this, width, height);
        cargo = new Cargo(this);
        move =new ship(this);
        
        float y = 50;
        for(int i=0; i<5 ;i++)
        {
            buttons.add(new Button(this, 0, y, width/4, 50, "I am a button"));
            tbox.add(new Textbox(this, width/4, y, "Help"));
            y+=100;
        }
    }

    public void draw()
    {
        background(110);
    
        /*pushMatrix();
        //translate(20,20);

        //cargo.cargo1();
        
        for(int i=0; i<10; i++)
        {
            move.movement();
           
        }*/

        ship.l2Design1();
        ship.bDesign1();
        ship.l1Design1();
        
        //popMatrix();

        hud.render();
        
        int i=0;
        for (Button butt : buttons)
        {
            butt.render();
            Textbox bx= tbox.get(i);
            bx.render();
            i++;
        }
        /*b1.render();
        b2.render();
        b3.render();
        b4.render();*/
      
        //if(mouseX>0 && mouseX<b.getVar() && mouseY>50 && mouseY<100)
        //if(pmouseX<b.getVar() )

        /*mc.update();
        mc.render();

        r.update();
        r.render();*/

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}


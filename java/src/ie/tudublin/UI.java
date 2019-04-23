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
    BtOps btop;

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

    public void mousePressed()
    {
        if(btop.bol==0)
        {
            btop.bol= 1;
        }
        else{
            btop.bol= 0;
        }
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
        btop = new BtOps(this);
        
        String[]bText={"x-ray","zoom in","zoom out","scan","pass","fail"};
        String[]hText={"See inside ship","enlarge ship","reduce ship size","Detect ship contents","let ship through",
                        "detain ship"};

        int counter =0;
        float y = 50;
        for(int i=0; i<6 ;i++)
        {
            buttons.add(new Button(this, 0, y, width/4, 50, bText[i],counter));
            tbox.add(new Textbox(this, width/4, y, hText[i]));
            y+=100;
            counter++;
        }
    }

    public void draw()
    {
        background(110);
    
        /*pushMatrix();
        //translate(20,20);
        
        for(int i=0; i<10; i++)
        {
            move.movement();
           
        }*/

        ship.l2Design1();
        ship.bDesign1();

        if(btop.bol==1)
        {
            cargo.cargo1();
        }
        else{
            ship.l1Design1();
        }
        
        //popMatrix();

        hud.render();

        int i=0;
        for (Button but : buttons)
        {
            but.render();
            Textbox bx= tbox.get(i);

            if(mouseX>0 && mouseX<but.getVar() && mouseY> bx.getVar(0) && mouseY< bx.getVar(50))
            {
                bx.render();

                if(mousePressed){
                    btop.selOps(but.getOp());
                    
                    mousePressed();
                }
            }
            else
            {
                i++;
            }
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


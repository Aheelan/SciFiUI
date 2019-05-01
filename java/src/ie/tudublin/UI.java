package ie.tudublin;

import java.util.*;
import processing.core.*;

public class UI extends PApplet
{
    ObjDesign obj;
    Radar r;
    Hud hud;

    ShipDesign ship;
    Cargo cargo;
    BtOps btop;
    Textbox mes;
    Textbox mbad;
    Textbox success;
    Textbox failure;

    ArrayList<ObjDesign> stars =new ArrayList<ObjDesign>();
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

    public void mouseReleased()
    {
        btop.rnOps();
    }

    public void settings()
    {
        size(1000, 700);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        obj = new ObjDesign(this,random(1000),random(700));
        r = new Radar(this, width / 2, height / 2, 250);
        ship= new ShipDesign(this);
        hud = new Hud(this, width, height);
        cargo = new Cargo(this);
        btop = new BtOps(this);
        mes= new Textbox(this, width/3, height/3, "Ship is Clean");
        mbad= new Textbox(this, width/3, height/3, "Contraband Found");
        success= new Textbox(this, width/3, height/3, "Success");
        failure= new Textbox(this, width/3, height/3, "You Failed to Evaluate Correctly");
        
        String[]bText={"x-ray","zoom in","zoom out","scan","pass","fail"};
        String[]hText={"See ship interior","enlarge image","minimise image","Detect ship contents","let ship through",
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

        for(int i=0; i<400 ;i++)
        {
            stars.add(new ObjDesign(this, random(1000), random(700)));
        }
    }

    public void draw()
    {
        background(0);
        fill(255);

        for (ObjDesign star : stars)
        {
            star.str();
        }

        obj.str();
        obj.shoot();
      
        if (btop.verdict==10)
        {
            for(int i=0;i<10000;i++)
            {
                fill(240,220,4);
                success.sMessage();
            }
        }
        if (btop.verdict==1)
        {
            for(int i=0;i<10000;i++)
            {
                fill(240,220,4);
                failure.sMessage();
            }
        }
        if (btop.verdict==1||btop.verdict==10)
        {
            btop.scount = 0;
            btop.bol= 0;
            ship.ent= 0;
            ship.trax= -700;
            btop.bmb= random(11);
            btop.verdict= 0;
        }

        pushMatrix();
        
        if(btop.scount == 1)
        {
            translate(-700,-550);
            scale((float)2.5);
        }
        if(btop.scount == 10)
        {
            btop.bol=2;
            translate(-2350,-1780);
            scale((float)6);
        }

        pushMatrix();
        ship.move();
        ship.l2Design1();
        ship.bDesign1();

        if(ship.ent==0)
        {
            ship.l1Design1();
        }
        popMatrix();

        if(btop.bol==1)
        {
            cargo.cargo1();
            popMatrix();
        }
        else if(btop.bol==2)
        {
            btop.req=1;
            
            if(btop.bmb<6)
            {
                cargo.bomb();
                popMatrix();
                r.face();
                r.timer();
                r.time();
                r.render();

                fill(240,220,4);
                mbad.sMessage();
            }
            else
            {
                cargo.cargo1();
                popMatrix();
                fill(240);
                r.face();
                r.update();
                r.render();
                btop.scan();

                fill(200,100,200);
                mes.sMessage();
            }
        }
        else if(ship.ent==0)
        {
            popMatrix();
        }
        else{
            ship.l1Design1();
            popMatrix();
        }

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
                    btop.selOps(buttons.get(i).getOp());

                    mouseReleased();
                }
            }
            else
            {
                i++;
            }
        }

        //mc.update();
        //mc.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}


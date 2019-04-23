package ie.tudublin;

import java.util.*;
import processing.core.PApplet;

public class BtOps
{
    UI ui;
    public int bol =0;
    public int scount =0;
    private int opsVal=7;

    public BtOps(UI ui)
    {

    }

    public void selOps(int opsVal)
    {
        this.opsVal=opsVal;
    }

    public void mousePressed()
    {
        //rnOps();
        ui.fill(0);
        ui.rect(200,200,200,200);
    }

    public void rnOps()
    {
        switch(opsVal) {
            case 0:
            if(bol==0)
            {
                bol= 1;
            }
            else{
                bol= 0;
            }
              break;
            case 1:
            scount =1;
              break;
            case 2:
            scount =2;
              break;
            case 3:
              
              break;
            case 4:
              
              break;
            case 5:
             
              break;
            default:
          }
    }
}
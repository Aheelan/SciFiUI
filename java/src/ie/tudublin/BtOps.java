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
              scount= 1;
              bol= 0;
              break;
            case 2:
              scount=0;
              bol= 0;
              break;
            case 3:
              scount=10;
              break;
            case 4:
              
              break;
            case 5:
             
              break;
            default:
          }
    }
}
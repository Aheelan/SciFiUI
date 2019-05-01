package ie.tudublin;

import processing.core.PApplet;

public class BtOps extends PApplet
{
    UI ui;
    public int bol =0;
    public float bmb = random(11);
    public float req =0;
    public float verdict =0;
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
              if (bmb<6||req==0)
              {
                verdict=1;
              }
              else if(req==1){
                verdict=10;
              }
              break;
            case 5:
            if (bmb<6 && req==1)
            {
              verdict=10;
            }
            else{
              verdict=1;
            }
              break;
            default:
          }
    }

    public void scan()
    {
      for(int i=0;i<10000;i++)
      {}
    }
}
# SciFi UI Project

Name: Aaron Heelan

Student Number: C17317821

# Description of the assignment
My assignment was created to be a security checkpoint for some kind of spacestation, 
that would check what a ship was carrying before allowing it into the spacestation.

# Instructions
The UI consists of Six buttons that function once clicked
1. XRay: shows ships cargo
1. Zoom in: makes the ship bigger
1. Zoom out: returns the ship to normal size
1. Scan: Identifies the ship's cargo type
1. pass: clears the ship for entry (ship leaves screen)
1. fail: imprisons ship (ship leaves screen)
Buttons 1 to 4 can be used limitlessly
Buttons 5 or 6 create a new ship

# How it works
My assignment contains 11 class files
- Main.java
- UI.java
- ShipDesign.java
- Cargo.java
- Hud.java
- Button.java
- BtOps.java
- Textbox.java
- ObjDesign.java
- RadarScan.java
- Timer.java (subclass of RadarScan)

#### UI.java
Has objects of every class in the assignment and is where all classes are called.

has three array lists of objects and two arrays of strings
```Java
ArrayList<ObjDesign> stars =new ArrayList<ObjDesign>();
    ArrayList<Button> buttons =new ArrayList<Button>();
    ArrayList<Textbox> tbox =new ArrayList<Textbox>();
```
checks size of image to draw using button operation(BtOps)
```Java
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
```
Checks what objects should be drawn according to current button operation
```Java
        if(ship.ent!=1||ship.kx!=0||ship.ky!=0)
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
                t.face();
                t.time();
                t.update();
                t.render();

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
        else if(ship.ent!=1||ship.kx!=0||ship.ky!=0)
        {
            popMatrix();
        }
        else{
            ship.l1Design1();
            popMatrix();
        }

        hud.render();
```
draws buttons, takes input
```Java
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
    }
```

#### ShipDesign.java
Creates the image of a spaceship through methods that make unique shapes using PShapes.
```JAVA
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
```
Has two other Pshape methods for different layers of ship model

Move method to control ships entry and exit
```JAVA
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
```
#### Cargo.java
creates the image of the ships cargo.
```JAVA
public void cargo1()
    {
        spc= 0;
        space= 0;

        ui.fill(10,100,20);
        ui.rect(x,y,nx,ny);
        
        ui.stroke(0);
        for(int i=0;i<5;i++)
        {
            ui.line(x+spc,y,x+spc,y+ny);
            ui.line(x,y+space,x+nx,y+space);

            spc= spc+nnx;
            space= space+nny;
        }
    }
```
Seperate method for other style of cargo

#### Hud.java
creates the transparent menu that contains the buttons.
```JAVA
public void render()
    {   
        ui.fill(50, 150, 255, alpha);
        ui.rect(0, 0, width/4, height);
    }
```
#### Button.java
creates a button that can be used for mouse events.
```JAVA
    public void render()
    {
        ui.fill(100,20,20);
        ui.stroke(255);
        ui.rect(x, y, width, height);
        ui.fill(100,120,250);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }
```
create multiple button objects and assigns it a string from string array
```JAVA
    String[]bText={"x-ray","zoom in","zoom out","scan","pass","fail"};
        String[]hText={"See Ship Interior","Enlarge image","Set Image to Default Size","Detect Ship Contents",
                        "Let Ship Through", "Detain Ship"};

        int counter =0;
        float y = 50;
        for(int i=0; i<6 ;i++)
        {
            buttons.add(new Button(this, 0, y, width/4, 50, bText[i],counter));
            tbox.add(new Textbox(this, width/4, y, hText[i]));
            y+=100;
            counter++;
        }
```
uses for and if statement to control textboxes and button operations.
```JAVA
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
```
#### BtOps.java
takes the button value the user clicked and changes how functions operate 
through variables and a switch statement.
```Java
        if (btop.verdict==1)
        {
            for(int i=0;i<10000;i++)
            {
                fill(240,220,4);
                failure.sMessage();
            }
        }
        if (btop.verdict==10)
        {
            for(int i=0;i<12000;i++)
            {
                fill(240,220,4);
                //fill(200,100,200);
                success.sMessage();
            }
        }
        
        if (btop.verdict!= 0)
        {
            btop.verdict= 0;
            btop.scount = 0;
            btop.bol= 0;
            ship.ent= 10;
            btop.bmb= random(11);
            btop.req= 0;
        }
```
#### Textbox.java
creates a transparent tipbox that is drawn on a mouse event using if statement
```JAVA
public void render()
    {
        ui.fill(100,100,180,100);
        ui.noStroke();

        ui.triangle(x,y+25, x1,y, x1,y+50);
        ui.rect(x1,y,x,50);

        ui.fill(255);
        
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x1 + x/2, y+25);
    }
```
create multiple Textbox objects and assigns it a string from string array
```JAVA
    String[]bText={"x-ray","zoom in","zoom out","scan","pass","fail"};
        String[]hText={"See Ship Interior","Enlarge image","Set Image to Default Size","Detect Ship Contents",
                        "Let Ship Through", "Detain Ship"};

        int counter =0;
        float y = 50;
        for(int i=0; i<6 ;i++)
        {
            buttons.add(new Button(this, 0, y, width/4, 50, bText[i],counter));
            tbox.add(new Textbox(this, width/4, y, hText[i]));
            y+=100;
            counter++;
        }
```
Also has generic method for all system messages to user (sMessage())

#### ObjDesign.java
creates stars for background image through a object arraylist called in UI.java
```Java
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
	
	public void str()
    {
        star= ui.createShape();
        ui.beginShape();
        ui.vertex(x-2, y+2);
        ui.vertex(x, y);
        ui.vertex(x+2, y+2);
        ui.vertex(x, y+4);
        ui.endShape();

        ui.shape(star);
    }
```
shoot() picks a random direction for a star object to travel 
at varying speeds using a switch statement

#### RadarScan.java
creates a circle with a rotating line using trigonometry
```JAVA
 public void face()
    {
        ui.strokeWeight(5);
        ui.ellipse(x, y, diameter, diameter);
    }

    public void render()
    {
        ui.strokeWeight(5);
        circleX = x + (float) Math.sin(theta) * radius;
        circleY = y - (float) Math.cos(theta) * radius;
        ui.line(x, y, circleX, circleY);
        ui.strokeWeight(1);
    }

    public void update()
    {
        ui.fill(240);
        ui.stroke(10,20,30);
        timeDelta = 1.0f/60.0f;
        theta += TwoPi * timeDelta * freq;
    }
```
#### Timer.java
creates a stylised radar
with slowed rotation and extra lines
```JAVA
    public Timer(UI ui, float x, float y, float diameter)
    {
        super(ui,x,y,diameter);
    }
    
    public void time()
    {
        cirx= circleX;
        ciry= circleY;
        circx= circleX;
        circy= circleY;
        float tht=0;
        float td= 1.0f/60.0f;

        for(int i=0;i<100;i++)
        {
            ui.stroke(255);
            ui.strokeWeight(2);
            cirx = x + (float) Math.sin(tht) * (radius/100*95);
            ciry = y - (float) Math.cos(tht) * (radius/100*95);
            circx = x + (float) Math.sin(tht) * (radius/100*85);
            circy = y - (float) Math.cos(tht) * (radius/100*85);
            ui.line(circx, circy, cirx, ciry);
            ui.strokeWeight(1);
            tht += TwoPi * td * freq;
        }
    }

    public void update()
    {
        ui.fill(10,30,50);
        ui.stroke(0);
        theta += TwoPi * timeDelta * freq;
    }
```
Overrides update of super class.

# What I am most proud of in the assignment
I am most proud of my tip boxs that only appear when the user hovers over a button.
This uses two synced object arraylists and an if statement using mouse coordinates.

```Java
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
```

[![YouTube](https://i9.ytimg.com/vi/xxCIr1BEeqM/mq2.jpg?sqp=CMjBpOYF&rs=AOn4CLAS2QNJCHYxQeP4XZX9YzHEst_VJQ)](https://www.youtube.com/embed/xxCIr1BEeqM)




















# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |


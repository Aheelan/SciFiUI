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

[![YouTube]https://www.youtube.com/embed/xxCIr1BEeqM]

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


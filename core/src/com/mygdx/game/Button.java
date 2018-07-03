package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Button {

    private int x, y, width, height;

    private Rectangle bounds;

    private Texture texture;

    //click returns to false first time the program acceses it in its true state, pressed remains true, released accessed once at the end
    private boolean clicked = false, draw = true, pressed = false, released = false;

    public Button(String path, int x, int y, int width, int height){
        texture = new Texture(path);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(x, y, width, height);
    }

    public Button(String path, int x, int y){
        texture = new Texture(path);
        this.x = x;
        this.y = y;
        width = texture.getWidth();
        height = texture.getHeight();
        bounds = new Rectangle(x, y, width, height);
    }

    public void update(){

        if(bounds.contains(Inputs.x,Inputs.y) && Inputs.pressed){
            clicked = pressed = true;
            released = false;
        }else if(pressed == true){
            clicked = pressed = false;
            released = true;
        }else{
            clicked = pressed = false;
        }

    }

    public boolean isClicked(){
        boolean ret = clicked;
        clicked = false;
        return ret;
    }

    public boolean isReleased(){
        boolean ret = released;
        released = false;
        return ret;
    }

    public void setDraw(boolean draw){
        this.draw = draw;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void render(Batch batch){
        if(!pressed && draw){
            batch.draw(texture, x, y, width, height);
        }else {
            batch.draw(texture, x + (int)(width*0.05), y + (int)(height*0.05), (int)(width*0.9), (int)(height*0.9));
        }
    }

}

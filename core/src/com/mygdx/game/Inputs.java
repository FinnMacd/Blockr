package com.mygdx.game;

import com.badlogic.gdx.InputAdapter;

public class Inputs extends InputAdapter {

    public static boolean pressed = false, lastpressed = false, tapped = false;

    public static float x = -1, y = -1, pointer = -1;

    private static long timer = 0;

    public boolean touchDown(int screenX, int screenY, int pointer, int button){

        if(pointer != -1){
            x = screenX;
            y = screenY;
            this.pointer = pointer;
            timer = System.currentTimeMillis();
            tapped = false;
            pressed = false;
        }

        return true;

    }

    public boolean touchDragged(int screenX, int screenY, int pointer){

        if(this.pointer == pointer){
            x = screenX;
            y = screenY;
        }

        return true;

    }

    public boolean touchUp(int screenX, int screenY, int pointer){

        if(this.pointer == pointer){
            this.pointer = -1;
            if(System.currentTimeMillis() - timer > 500) tapped = true;
            pressed = false;
        }

        return true;

    }

}

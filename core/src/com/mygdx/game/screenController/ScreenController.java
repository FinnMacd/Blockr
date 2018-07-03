package com.mygdx.game.screenController;

import com.badlogic.gdx.graphics.g2d.Batch;

public class ScreenController {

    public static int MENUSCREEN = 0, GAMESCREEN = 1;

    private Screen[] screens;

    private int currentScreen = 0;

    private boolean screenChange = true;

    public ScreenController(){

        screens = new Screen[]{new MenuScreen(this)};

    }

    public void render(Batch batch){
        screens[currentScreen].render(batch);
    }

    public void update(){
        if(screenChange)init();
        screens[currentScreen].update();
    }

    private void init(){

        if(!screens[currentScreen].initOnce() ||
                (!screens[currentScreen].init())){
            screens[currentScreen].initialize();
        }

        screenChange = false;
    }

    public void changeScreen(int screen){
        currentScreen = screen;
        screenChange = true;
    }

}

package com.mygdx.game.screenController;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Screen {

    private ScreenController screenController;
    private boolean initialized = false, initOnce = true;

    public Screen(ScreenController screenController){
        this.screenController = screenController;
    }

    public void initialize(){
        initialized = true;
    }
    public void terminate(){}

    public abstract void update();
    public abstract void render(Batch batch);

    public Boolean init(){
        return initialized;
    }

    public Boolean initOnce(){
        return initOnce;
    }

}

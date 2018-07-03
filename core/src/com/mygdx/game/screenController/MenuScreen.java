package com.mygdx.game.screenController;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MenuScreen extends Screen {

    private Texture title;

    public MenuScreen(ScreenController screenController) {
        super(screenController);
        title = new Texture("menu/Title.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Batch batch) {

        batch.draw(title, 100,100, 800,200);

    }
}

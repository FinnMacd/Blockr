package com.mygdx.game.screenController;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Button;

public class MenuScreen extends Screen {

    private Texture title;

    private Button start, achievments;

    public MenuScreen(ScreenController screenController) {
        super(screenController);
        title = new Texture("menu/Title.png");
        start = new Button("menu/Start.png", 100, 800);
        achievments = new Button("menu/Achievments.png", 100, 1000);
    }

    @Override
    public void update() {

        start.update();
        achievments.update();

    }

    @Override
    public void render(Batch batch) {

        batch.draw(title, 100,100, 800,200);
        start.render(batch);
        achievments.render(batch);

    }
}

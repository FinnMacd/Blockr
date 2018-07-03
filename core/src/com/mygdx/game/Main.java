package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screenController.ScreenController;

public class Main extends ApplicationAdapter implements Runnable{

	UtilBatch batch;

	private ScreenController screenController;

	private Thread gameThread;

	private int fps, ups, fc = 0,uc = 0;

	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new UtilBatch();
		screenController = new ScreenController();
		Gdx.input.setInputProcessor(new Inputs());

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		gameThread = new Thread(this);
		gameThread.start();

	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		screenController.render(batch);
		batch.end();
		fc++;
	}

	public void update(){
		screenController.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ms = 1000000000.0/25.0;
		double delta = 0;

		while(true){

			long now = System.nanoTime();
			delta += (now-lastTime)/ms;
			lastTime = now;
			while(delta >= 1){
				update();
				uc++;
				delta--;
			}

			if(System.currentTimeMillis()-timer >= 1000){
				timer = System.currentTimeMillis();
				ups = uc;
				fps = fc;
				uc = fc = 0;
				System.out.println("ups: " + ups + " || fps: " + fps);
			}

		}

	}

	public class UtilBatch extends SpriteBatch{

		public void draw(Texture texture, float x, float y){
			if(texture == null){
				System.out.println("could not render resource");
				return;
			}
			this.draw(texture, x, y, texture.getWidth(), texture.getHeight(), 0, 0, texture.getWidth(), texture.getHeight(), false, true);
		}

		public void draw(Texture texture, float x, float y, float width, float height){
			if(texture == null){
				System.out.println("could not render resource");
				return;
			}
			this.draw(texture, x, y, width, height, 0, 0, texture.getWidth(), texture.getHeight(), false, true);
		}

	}

}

package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PauseMenu implements Screen {
	
	Button quitButton, playButton, restartButton, pauseButton;
	ButtonStyle quitBS, playBS, restartBS, pauseBS;
	Skin skin;
	Stage stage;
	TextureAtlas buttonAtlas;
	SpriteBatch batch;	
	float w, h;
	boolean pauseScreenStatus;
	
	Game game;
	
	
	public PauseMenu(){			
		
	}
	
	public PauseMenu(Game game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		if (pauseButton.isPressed()){
			setPauseScreenStatus(true);
			
		}
		
		if (getPauseScreenStatus() == true){
			stage.setViewport(w, h, true);
			//TODO also show all dem buttons
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {  //like the create method
		// TODO Auto-generated method stub
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		stage = new Stage(w/8,w/8, true);
		skin = new Skin();
		buttonAtlas = new TextureAtlas("Buttons/Menu Buttons.pack");
		skin.addRegions(buttonAtlas);
		

		
		playBS = new ButtonStyle();
		quitBS = new ButtonStyle();
		restartBS = new ButtonStyle();
		pauseBS = new ButtonStyle();
		
		playButton = new Button();
		quitButton = new Button();
		restartButton = new Button();
		
		playBS.up = skin.getDrawable("buttonPlayUp");
		playBS.down = skin.getDrawable("buttonPlayDown");
		
		pauseBS.up = skin.getDrawable("buttonPlayUp");
		pauseBS.down = skin.getDrawable("buttonPauseDown");
		
		restartBS.up = skin.getDrawable("buttonRestartUp");
		restartBS.down = skin.getDrawable("buttonRestartDown");
		
		quitBS.up = skin.getDrawable("buttonQuitUp");
		quitBS.down = skin.getDrawable("buttonQuitDown");
		
		if (getPauseScreenStatus() == false){
		stage.setViewport(w/8, w/8, false, w - w/8, h/2 - w/16, w/8, w/8);
		//(stageWidth, stageHeight, keepAspectRatio, viewportX, viewportY, viewportWidth, viewportHeight)
		}
		

		
		batch = new SpriteBatch();
		
		stage.addActor(playButton);
		stage.addActor(pauseButton);
		stage.addActor(restartButton);
		stage.addActor(quitButton);
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	void setPauseScreenStatus(boolean newStatus){
	pauseScreenStatus = newStatus;
	}
	
	boolean getPauseScreenStatus(){
		return pauseScreenStatus;
	}

}

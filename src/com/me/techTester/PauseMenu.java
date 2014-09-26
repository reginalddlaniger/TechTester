package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
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
	float w, h, buttonX;
	boolean pauseScreenStatus;
	TechTester game;
	
	
	public PauseMenu(){			
		
	}
	
	public PauseMenu(TechTester game){
		this.game = game;
		
	}

	@Override
	public void render( float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.end();
		
		stage.act();
		
		stage.draw();

		System.out.println("pause status: " + getPauseScreenStatus() + "ButtonX = " + buttonX);

		if (OnePlayerPlayScreen.getGameStatus() == "paused"){
			setPauseScreenStatus(true);
		}
		
		if (getPauseScreenStatus() == true && buttonX > w/2-w/16){
			buttonX -= w/32;
			playButton.setPosition(buttonX, h/2 - w/16);
			quitButton.setPosition(buttonX, h/4 - w/16);
			restartButton.setPosition(buttonX, h * 3/4 - w/16);
		}
		
		if (pauseButton.isPressed()){
			setPauseScreenStatus(true);			
		}

		
		if (playButton.isPressed() == true ){
			setPauseScreenStatus(false);
		}
		
		if (getPauseScreenStatus() == false){
			buttonX = w;
			game.setScreen(ScreenHandler.onePlayerPlayScreen);
			//OnePlayerPlayScreen.setGameStatus("playing");
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
		
		batch = new SpriteBatch();
		
		
		playBS = new ButtonStyle();
		quitBS = new ButtonStyle();
		restartBS = new ButtonStyle();
		pauseBS = new ButtonStyle();
		
		playButton = new Button(playBS);
		quitButton = new Button(quitBS);
		restartButton = new Button(restartBS);
		pauseButton = new Button(pauseBS);
		
		stage = new Stage(w,h, true);
		skin = new Skin();
		buttonAtlas = new TextureAtlas("Buttons/Menu Buttons.pack");
		skin.addRegions(buttonAtlas);
		

		

		
		buttonX = w;
		
		playBS.up = skin.getDrawable("buttonPlayUp");
		playBS.down = skin.getDrawable("buttonPlayDown");
		
		pauseBS.up = skin.getDrawable("buttonPauseUp");
		pauseBS.down = skin.getDrawable("buttonPauseDown");
		
		restartBS.up = skin.getDrawable("buttonRestartUp");
		restartBS.down = skin.getDrawable("buttonRestartDown");
		
		quitBS.up = skin.getDrawable("buttonQuitUp");
		quitBS.down = skin.getDrawable("buttonQuitDown");
		
		playButton.setSize(w/8,w/8);
		playButton.setPosition(buttonX, h/2 - w/16);
		
		quitButton.setSize(w/8, w/8);
		quitButton.setPosition(buttonX, h/4 - w/16);
		
		restartButton.setSize(w/8,  w/8);
		restartButton.setPosition(buttonX, h * 3/4 - w/16);
		
		pauseButton.setSize(w/8, w/8);
		pauseButton.setPosition(w - w/7, h/2 - w/16);
		/*
		if (getPauseScreenStatus() == false){
		stage.setViewport(w/8, w/8, false, w - w/8, h/2 - w/16, w/8, w/8);
		//(stageWidth, stageHeight, keepAspectRatio, viewportX, viewportY, viewportWidth, viewportHeight)
		}
		*/
		

		
		
		
		Gdx.input.setInputProcessor(stage);
		
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

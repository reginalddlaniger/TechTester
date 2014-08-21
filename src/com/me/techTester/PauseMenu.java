package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PauseMenu implements Screen {
	
	Button quitButton, playButton, restartButton;
	ButtonStyle quitBS, playBS, restartBS;
	Skin skin;
	Stage stage;
	TextureAtlas buttonAtlas;
	SpriteBatch batch;	
	
	Game game;
	
	
	public PauseMenu(){			
		
	}
	
	public PauseMenu(Game game){

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {  //like the create method
		// TODO Auto-generated method stub
		
		stage = new Stage();
		skin = new Skin();
		buttonAtlas = new TextureAtlas();
		
		playBS = new ButtonStyle();
		quitBS = new ButtonStyle();
		restartBS = new ButtonStyle();
		
		batch = new SpriteBatch();
		
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

}

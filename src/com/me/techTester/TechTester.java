package com.me.techTester;


import com.badlogic.gdx.Game;


public class TechTester extends Game {	
	 
	//Game game;
	ScreenHandler screenHandler;

	
	@Override
	public void create() {
		
		//game = this;
		screenHandler = new ScreenHandler(this);
		setScreen(ScreenHandler.mainMenu);		
		
	}

	@Override
	public void dispose() {


	}

	@Override
	public void render() {	
		super.render();
		
	}


	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	

	
}
	

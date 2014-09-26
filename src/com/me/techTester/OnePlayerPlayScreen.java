package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;

public class OnePlayerPlayScreen implements Screen{
	

	
	WorldInput wInput; //THIS  SHOULD BE GONE WHEN I BRING BACK THE OTHER VERSION.//but now i don't know why
	WorldRenderer wRenderer;
	TimeHandler mainGameTimeHandler; 	
	PlayerHandler playerHandler;
	PauseMenu pauseMenu;
	TechTester game;
	
	static float h, w;	
	int stopper1, stopper2; //these should act like counters, a touch on the screen will cause them to go up by one. when they go up to one, they will cut off further activity.  they will then be reset to 0 on release
	public static float stateTime;	
	boolean showPauseScreen, showEndScreen;
	float choice;

	static public String gameStatus;  //gameStatus = paused, over, playing, resuming
	
	public OnePlayerPlayScreen(TechTester game){
		this.game = game;  
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		
		//if (getGameStatus() == "playing"){
		

		
		if (Gdx.input.isKeyPressed(Keys.J)){
			setGameStatus("paused");
		}		
	
	
		if (Gdx.input.isKeyPressed(Keys.K)){
			setGameStatus("playing");
		}		
		
		if (getGameStatus() == "paused"){
			game.setScreen(ScreenHandler.pauseMenu);
			//ScreenHandler.pauseMenu.render(delta);
		}
			
		
		if (getGameStatus() == "playing"){
		stateTime += Gdx.graphics.getDeltaTime() * 1.5f;
		}
		
		//}
		
		//else{
		
		
		mainGameTimeHandler.update(getGameStatus(),stateTime);
		
		
		if (mainGameTimeHandler.getTimePassed() >= 99){
			setGameStatus("over");
		}
		if (playerHandler.player1.getHP() <= 0 || playerHandler.player2.getHP() <= 0){
			setGameStatus("over");
		}
		
		
		/*
		if (playerHandler.player1.getHP() == 0 || playerHandler.player2.getHP() == 0){
			showEndScreen = true;
		}
		*/	
		
		
		//stateTime += mainGameTimeHandler.getStateTime();
		//stateTime += Gdx.graphics.getDeltaTime();	

		
		wInput.update(getGameStatus());
		wRenderer.update(getGameStatus(), playerHandler, stateTime, wInput, mainGameTimeHandler);
		playerHandler.update(getGameStatus(), stateTime, wInput);
		
		
		
		/*
		//animeClock.update();
		if (animeClock.getTimePassed() > 4){
			animeClock.setTimePassed(0);
		}
		*/		
		
		/*
		THE GETCLICKPOS PARTS NEED TO BE REPLACED WITH NEW BUTTONS  DONE
		if (wInput.p1Button.isPressed()){
			setClickPos(Gdx.input.getX(), Gdx.input.getY());
		}
		*/
		//}
		
		
		if (getGameStatus() == "paused"){
			
			mainGameTimeHandler.timerPause();
			//wRenderer.p1AnimeClock.timerPause();
			//wRenderer.p2AnimeClock.timerPause();
			//playerHandler.p1TimeHandler.timerPause();
			//playerHandler.p2TimeHandler.timerPause();

			
			
		}
		
		else if (getGameStatus() == "resuming"){
			//resume timers
			setGameStatus("playing");
		}
		
		
		else if ( getGameStatus() == "over"){
			
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
		
		//TODO  create foe selector - switch statements
		//TODO create
		
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		stateTime = 0;
		
		pauseMenu = new PauseMenu();
		
		mainGameTimeHandler = new TimeHandler(stateTime);
		mainGameTimeHandler.setTimerDuration(99);
		mainGameTimeHandler.setName("Game Clock");


		showPauseScreen = false;
		showEndScreen = false;
		
		
		//clock.setPlayerInput(Gdx.input.isButtonPressed(Buttons.LEFT));	
		
		
		wInput = new WorldInput();
		wRenderer = new WorldRenderer(mainGameTimeHandler);
		playerHandler = new PlayerHandler(stateTime, "onePlayer");
		playerHandler.setGameMode("onePlayer");
		setGameStatus("playing");
		
		//setScreen(new MainMenu(game));
		
	}// end of show/create method

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
	

	static public void setGameStatus(String givenGameStatus){
		gameStatus = givenGameStatus;
	}
	
	static public String getGameStatus(){
		return gameStatus;
	}

}

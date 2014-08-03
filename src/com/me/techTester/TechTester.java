package com.me.techTester;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.math.Vector2;

public class TechTester implements ApplicationListener {
	
	WorldInput wInput;
	WorldRenderer wRenderer;
	TimeHandler mainGameTimeHandler; 	
	PlayerHandler playerHandler;
	
	
	static float h, w;	
	int stopper1, stopper2; //these should act like counters, a touch on the screen will cause them to go up by one. when they go up to one, they will cut off further activity.  they will then be reset to 0 on release
	public static float stateTime;	
	boolean showPauseScreen, showEndScreen;

	String gameStatus;  //gameStatus = paused, over, playing, resuming

	
	@Override
	public void create() {	
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		stateTime = 0;
		
		mainGameTimeHandler = new TimeHandler(stateTime);
		mainGameTimeHandler.setTimerDuration(99);
		mainGameTimeHandler.setName("Game Clock");


		showPauseScreen = false;
		showEndScreen = false;
		
		
		//clock.setPlayerInput(Gdx.input.isButtonPressed(Buttons.LEFT));	
		
		
		wInput = new WorldInput();
		wRenderer = new WorldRenderer(mainGameTimeHandler);
		playerHandler = new PlayerHandler(stateTime);
		setGameStatus("playing");

		
		
	}

	@Override
	public void dispose() {


	}

	@Override
	public void render() {		

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		
		//if (getGameStatus() == "playing"){
			
		
		
		stateTime += Gdx.graphics.getDeltaTime() * 1.5f;
		
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
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	

	
	void setGameStatus(String givenGameStatus){
		gameStatus = givenGameStatus;
	}
	
	String getGameStatus(){
		return gameStatus;
	}
}
	

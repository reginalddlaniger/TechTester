package com.me.techTester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class WorldInput {
	
	Vector2 clickPos;
	Button p1Button, p2Button, pause;
	float h, w;
	Stage playerInputArea, pauseMenu;
	ButtonStyle pauseBS;
	boolean pauseStatus;
	

	
	

	
	public WorldInput(){
		h = Gdx.graphics.getHeight();
		w = Gdx.graphics.getWidth();
		
		clickPos = new Vector2();

		
		playerInputArea = new Stage(w, h, true);
		//playerInputArea.
		p1Button = new Button();
		p2Button = new Button();
		pause = new Button();		

		
		
		p1Button.setSize(w, h/2);
		p2Button.setSize( w, h/2);
		pause.setSize(w/8, h/32);
		//playerInputArea.
		
		p1Button.setPosition(0 - w/2, 0 - h/2);
		p2Button.setPosition(0 - w/2, 0);
		pause.setPosition(0, h/2 - w/16);

		
		
		
		playerInputArea.addActor(p1Button);
		playerInputArea.addActor(p2Button);
		playerInputArea.addActor(pause);
		
		
		
		
		Gdx.input.setInputProcessor(playerInputArea);
		

		
		setPauseStatus(false);
		
		
	}
	
	
	void update(String gameState){
		
		//playerInputArea.draw();
		playerInputArea.act();		
		
		
		if (p1Button.isPressed()){
			System.out.println("p1Button Pressed~");
		}
		
		if (p2Button.isPressed()){
			System.out.println("p2Button Pressed!");
		}
		
		if (pause.isPressed()){
			setPauseStatus(true);
		}
		

		///////////////////////////////////////PRESS J TO PAUSE
		if (Gdx.input.isKeyPressed(Keys.J)){
			setPauseStatus(true);
		}
		
		if (getPauseStatus() == true){
			if (Gdx.input.isKeyPressed(Keys.J)){
				setPauseStatus(false);
			}
		}
		////////////////////////////////////////////
		
		if (pauseStatus == true){
			TechTester.setGameStatus("paused");
		}
		
	}
	
	void setClickPos(int x, int y){
		clickPos.x = x;
		clickPos.y = y;
	}
	
	Vector2 getClickPos(){
		return clickPos;
	}
	
	void setPauseStatus(boolean givenPauseStatus){
		pauseStatus = givenPauseStatus;
	}
	
	boolean getPauseStatus(){
		return pauseStatus;
	}
}

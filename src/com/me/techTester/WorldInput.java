package com.me.techTester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class WorldInput {
	
	Vector2 clickPos;
	Button p1Button, p2Button, pause;
	ButtonStyle p1BS, p2BS;
	float h, w;
	TechTester game;
	//Stage playerInputArea, pauseMenu;
	//ButtonStyle pauseBS;
	
	

	//Stuff from pause menu
	
	Button quitButton, playButton, pauseButton2, restartButton;
	ButtonStyle quitBS, playBS, restartBS, pauseBS;
	Skin skin;
	Stage stage;
	TextureAtlas buttonAtlas;	
	float buttonX;
	boolean pauseScreenStatus;	
	
	//end of stuff from pause menu
	

	
	

	
	public WorldInput(TechTester game){ 
		//imported [techtester game]to enable screen switching

		h = Gdx.graphics.getHeight();
		w = Gdx.graphics.getWidth();
		
		clickPos = new Vector2();

		this.game = game;
		 
		//playerInputArea = new Stage(w, h, true);
		//playerInputArea.
		
		p1BS = new ButtonStyle();
		p2BS = new ButtonStyle();
		pauseBS = new ButtonStyle();
		
		p1Button = new Button(p1BS);
		p2Button = new Button(p2BS);
		//pause = new Button(pauseBS);		

		
		
		p1Button.setSize(w, h/2);
		p2Button.setSize( w, h/2);
		//pause.setSize(playerInputArea.getWidth()/32, playerInputArea.getWidth()/32);
		//playerInputArea.
		
		p1Button.setPosition(0, 0);
		p2Button.setPosition(0, h/2);
		//pause.setPosition(-1, 0);

		
		
		/*
		playerInputArea.addActor(p1Button);
		playerInputArea.addActor(p2Button);
		playerInputArea.addActor(pause);
		*/
		

		
		
		
		
		//Gdx.input.setInputProcessor(playerInputArea);
		
		if (Gdx.input.isKeyPressed(Keys.J)){
			
		}
		
		//from pausemenu
		playBS = new ButtonStyle();
		quitBS = new ButtonStyle();
		restartBS = new ButtonStyle();
		pauseBS = new ButtonStyle();
		
		playButton = new Button(playBS);
		quitButton = new Button(quitBS);
		restartButton = new Button(restartBS);
		pauseButton2 = new Button(pauseBS);
		
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
		
		pauseButton2.setSize(w/8, w/8);
		pauseButton2.setPosition(w - w/7, h/2 - w/16);
		/*
		if (getPauseScreenStatus() == false){
		stage.setViewport(w/8, w/8, false, w - w/8, h/2 - w/16, w/8, w/8);
		//(stageWidth, stageHeight, keepAspectRatio, viewportX, viewportY, viewportWidth, viewportHeight)
		}
		*/
		

		
		
		
		Gdx.input.setInputProcessor(stage);
		

		
		stage.addActor(p1Button);
		stage.addActor(p2Button);
		//stage.addActor(pause);
		
		stage.addActor(pauseButton2);
		stage.addActor(playButton);
		stage.addActor(restartButton);
		stage.addActor(quitButton);
		//end of pause menu
		
	}
	
	void update(String gameState, String gameMode){
		
		//playerInputArea.draw();
		//playerInputArea.act();		
		
		
		if (p1Button.isPressed()){
			System.out.println("p1Button Pressed~");
		}
		
		if (p2Button.isPressed()){
			System.out.println("p2Button Pressed!");
		}
		
		//from pauseMenu
		
		stage.act();
		
		stage.draw();

		System.out.println("pause status: " + getPauseScreenStatus() + "ButtonX = " + buttonX);

		if (OnePlayerPlayScreen.getGameStatus() == "paused"){
			setPauseScreenStatus(true);
		}
		
		if (TwoPlayerPlayScreen.getGameStatus() == "paused"){
			setPauseScreenStatus(true);
		}
		
		if (getPauseScreenStatus() == true && buttonX > w/2-w/16){
			buttonX -= w/32;
			playButton.setPosition(buttonX, h/2 - w/16);
			quitButton.setPosition(buttonX, h/4 - w/16);
			restartButton.setPosition(buttonX, h * 3/4 - w/16);
			
			p1Button.setPosition(w, 0);
			p2Button.setPosition(w,h/2);
		}
		
		/*
		if (pauseButton2.isPressed()){
			
			OnePlayerPlayScreen.setGameStatus("paused");
			setPauseScreenStatus(true);			
		}
		*/

		
		if (playButton.isPressed() == true ){
			OnePlayerPlayScreen.setGameStatus("playing");
			TwoPlayerPlayScreen.setGameStatus("playing");
			setPauseScreenStatus(false);
		}
		
		if (getPauseScreenStatus() == false){
			if (buttonX < w){
				buttonX += w/32;
				playButton.setPosition(buttonX, h/2 - w/16);
				quitButton.setPosition(buttonX, h/4 - w/16);
				restartButton.setPosition(buttonX, h * 3/4 - w/16);
			}
			else {
				p1Button.setPosition(0, 0);
				p2Button.setPosition(0, h/2);
			}

			//game.setScreen(ScreenHandler.onePlayerPlayScreen);
			//OnePlayerPlayScreen.setGameStatus("playing");
		}
		
		//end of pause menu
		
		//TRYING TO IMPLEMENT A PAUSE MENU
		if (pauseButton2.isPressed()){
			OnePlayerPlayScreen.setGameStatus("paused");
			TwoPlayerPlayScreen.setGameStatus("paused");
			
		}
		

		
		//end of pause menu
		
		
		if (gameMode == "onePlayer"){
			
			if (restartButton.isPressed()){
				
				playButton.setPosition(buttonX, h/2 - w/16);
				quitButton.setPosition(buttonX, h/4 - w/16);
				restartButton.setPosition(buttonX, h * 3/4 - w/16);
				
				OnePlayerPlayScreen.setGameStatus("playing");
				TwoPlayerPlayScreen.setGameStatus("playing");
				setPauseScreenStatus(false);
				
				game.setScreen(ScreenHandler.onePlayerPlayScreen);
			}
		}
		else if (gameMode == "twoPlayer"){
			if (restartButton.isPressed()){
				
				playButton.setPosition(buttonX, h/2 - w/16);
				quitButton.setPosition(buttonX, h/4 - w/16);
				restartButton.setPosition(buttonX, h * 3/4 - w/16);
				
				OnePlayerPlayScreen.setGameStatus("playing");
				TwoPlayerPlayScreen.setGameStatus("playing");
				setPauseScreenStatus(false);
				
				game.setScreen(ScreenHandler.twoPlayerPlayScreen);
			}
		}
		
		
		if (quitButton.isPressed()){
			
			playButton.setPosition(buttonX, h/2 - w/16);
			quitButton.setPosition(buttonX, h/4 - w/16);
			restartButton.setPosition(buttonX, h * 3/4 - w/16);
			
			OnePlayerPlayScreen.setGameStatus("playing");
			TwoPlayerPlayScreen.setGameStatus("playing");
			setPauseScreenStatus(false);
			
			game.setScreen(ScreenHandler.mainMenu);
		}

		

		
	}
	
	void setClickPos(int x, int y){
		clickPos.x = x;
		clickPos.y = y;
	}
	
	Vector2 getClickPos(){
		return clickPos;
	}
	
	void setPauseScreenStatus(boolean newStatus){
	pauseScreenStatus = newStatus;
	}
	
	boolean getPauseScreenStatus(){
		return pauseScreenStatus;
	}
}

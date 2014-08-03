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
		//pause.setSize(playerInputArea.getWidth()/32, playerInputArea.getWidth()/32);
		//playerInputArea.
		
		p1Button.setPosition(0 - w/2, 0 - h/2);
		p2Button.setPosition(0 - w/2, 0);
		pause.setPosition(-1, 0);

		
		
		
		playerInputArea.addActor(p1Button);
		playerInputArea.addActor(p2Button);
		playerInputArea.addActor(pause);
		
		
		
		
		Gdx.input.setInputProcessor(playerInputArea);
		
		if (Gdx.input.isKeyPressed(Keys.J)){
			
		}
		
		
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
		
	}
	
	void setClickPos(int x, int y){
		clickPos.x = x;
		clickPos.y = y;
	}
	
	Vector2 getClickPos(){
		return clickPos;
	}
}

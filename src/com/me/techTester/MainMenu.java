package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenu implements Screen{
	
	Stage stage;
	Button onePGame, twoPGame, quitGame;
	ButtonStyle p1BS, p2BS, qGBS;  //p1ButtonStyle, player2ButtonStyle, Quit Game ButtonStyle
	ShapeRenderer bgColor;
	float h = Gdx.graphics.getHeight();
	float w = Gdx.graphics.getWidth();
	Skin skin;
	TextureAtlas buttonAtlas;
	
	SpriteBatch batch;
	
	TechTester game;
	
	public MainMenu(TechTester game){
		this.game = game;
	}
	

	@Override
	public void render(float delta) { //is the render - constantly updated content
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//batch.begin();
		
		//batch.end();
		
		bgColor.begin(ShapeType.Filled);
		bgColor.setColor(Color.DARK_GRAY);
		bgColor.rect(0, 0, w, h);
		bgColor.end();
		
		stage.act();		
		
		//batch.begin();		
		//batch.end();	
		
		stage.draw();		//needs to have buttons and their pack information	
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {  //like the create method
		
		bgColor = new ShapeRenderer();

		
		
		stage = new Stage(w,h, true);

		p1BS = new ButtonStyle();
		p2BS = new ButtonStyle();
		qGBS = new ButtonStyle();
		
		onePGame = new Button(p1BS);
		twoPGame = new Button(p2BS);
		quitGame = new Button(qGBS);

		batch = new SpriteBatch();	

		skin = new Skin();
		buttonAtlas = new TextureAtlas("Buttons/Menu Buttons.pack");
		skin.addRegions(buttonAtlas);
		
		p1BS.up = skin.getDrawable("button1Pup");
		p1BS.down = skin.getDrawable("button1Pdown");
		
		p2BS.up = skin.getDrawable("button2Pup");
		p2BS.down = skin.getDrawable("button2Pdown");
		
		qGBS.up = skin.getDrawable("buttonQuitUp");
		qGBS.down = skin.getDrawable("buttonQuitDown");
		
		onePGame.setSize(w/8, w/8);
		onePGame.setPosition(w/2 - w/16, (h * 3/4) - w/8);
		
		twoPGame.setSize(w/8, w/8);
		twoPGame.setPosition(w/2 - w/16, h * 1/4);
		
		quitGame.setSize(w/8, w/8);
		quitGame.setPosition(w/2 - w/16, h * 1/16);
		
		
		
		
		Gdx.input.setInputProcessor(stage);
		

		
		stage.addActor(onePGame);
		stage.addActor(twoPGame);
		stage.addActor(quitGame);
		

		
		onePGame.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("p1 choice clicked");
				game.setScreen(ScreenHandler.onePlayerPlayScreen);
				return true;
			}
		});
		
		twoPGame.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("p2 choice clicked");
				game.setScreen(ScreenHandler.twoPlayerPlayScreen);
				return true;
			}
		});
		
		quitGame.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("quit choice clicked");
				Gdx.app.exit();
				return true;
			}
		});
		
		
		
		
		
		
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

package com.me.techTester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenu implements Screen{
	
	Stage stage;
	Button onePGame, twoPGame;
	ButtonStyle p1BS, p2BS;
	float h = Gdx.graphics.getHeight();
	float w = Gdx.graphics.getWidth();
	Skin skin;
	TextureAtlas buttonAtlas;
	
	SpriteBatch batch;
	
	Game game;
	
	public MainMenu(Game game){
		this.game = game;
	}
	

	@Override
	public void render(float delta) { //is the render - constantly updated content
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		stage.act();
		
		batch.begin();
		stage.draw();		//needs to have buttons amd their pack information
		
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {  //like the create method
		
		stage = new Stage(w,h, true);

		p1BS = new ButtonStyle();
		p2BS = new ButtonStyle();
		onePGame = new Button(p1BS);
		twoPGame = new Button(p2BS);

		batch = new SpriteBatch();	

		skin = new Skin();
		buttonAtlas = new TextureAtlas("Buttons/Menu Buttons.pack");
		skin.addRegions(buttonAtlas);
		
		p1BS.up = skin.getDrawable("button1Pup");
		p1BS.down = skin.getDrawable("button1Pdown");
		
		p2BS.up = skin.getDrawable("button2Pup");
		p2BS.down = skin.getDrawable("button2Pdown");
		
		onePGame.setSize(w/8, w/8);
		onePGame.setPosition(w/2 - w/16, (h * 3/4) - w/8);
		
		twoPGame.setSize(w/8, w/8);
		twoPGame.setPosition(w/2 - w/16, h * 1/4);
		
		
		Gdx.input.setInputProcessor(stage);
		
		stage.addActor(onePGame);
		stage.addActor(twoPGame);
		

		
		onePGame.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("p1 choice clicked");
				return true;
			}
		});
		
		twoPGame.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("p2 choice clicked");
				game.setScreen(new TwoPlayerPlayScreen(game));
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

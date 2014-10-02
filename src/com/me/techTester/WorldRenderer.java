package com.me.techTester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class WorldRenderer {
	float w;
	float h;
	
	TimeHandler p1AnimeClock, p2AnimeClock, p1TauntClock, p2TauntClock;
	boolean pauseStatus;
	
	private OrthographicCamera camera;

//	private Texture texture;
//	private Sprite sprite;

	ShapeRenderer markerCase, HPlines, backgroundRect;
	ShapeRenderer player1HPBar, p1HPBorder, player1Timer, sr2, p1Status;
	ShapeRenderer player2HP, p2HPBorder, enemyTime, p2Status;
	Texture marker;
	Vector2 cursorPosition;
	SpriteBatch batch, batch2, pauseBatch, timerBatch;
	Texture background;
	TextureRegion[] p1Background, p2Background;
	float p1FrameStart, p1AnimeFrameTime;
	float p1x, p1y, p2x, p2y;  //player 1 x and y coordinates, player 2 x and y coordinates
	float p1AttackMS, p2AttackMS, p1DamagedMS, p2DamagedMS;  //attack movement speed and damaged movement speeds
	
	Texture darkenedScreen;
	Texture timerNumberPic;
	TextureRegion[] timerNumbers;
	Texture winner;
	TextureRegion[] TRWinner;
	
	
	Texture playbackTextures;
	TextureRegion[] playBackButtons;
	TextureRegion pauseButton;
	//Texture playButton;
	//Texture restartButton;
	//Texture blankButton;
	
	Texture fullSlimeSpriteSheet;
	TextureRegion[] allSlimeSprites;
	Animation allSlimes;
	
	
	
	
	Animation p1fireNormal;
	Animation p1fireAttack;
	Animation p1fireHit;
	
	Animation p2fireNormal;
	Animation p2fireAttack;
	Animation p2fireHit;
	
	Animation p1waterNormal;
	Animation p1waterAttack;
	Animation p1waterHit;
	
	Animation p2waterNormal;
	Animation p2waterAttack;
	Animation p2waterHit;
	
	Animation p1earthNormal;
	Animation p1earthAttack;
	Animation p1earthHit;
	Animation p1earthLeaves;

	Animation p2earthNormal;
	Animation p2earthAttack;
	Animation p2earthHit;
	Animation p2earthLeaves;
	
	Animation p1NeutralNormal;
	Animation p1NeutralHit;
	
	Animation p2NeutralNormal;
	Animation p2NeutralHit;
	
	Animation p1fireTransform;
	Animation p1waterTransform;
	Animation p1earthTransform;
	
	Animation p2fireTransform;
	Animation p2waterTransform;
	Animation p2earthTransform;
	
	Animation p1Hearts;
	Animation p2Hearts;
	
	
	TextureRegion[] TRp1fireNormal;
	TextureRegion[] TRp1fireAttack;
	TextureRegion[] TRp1fireHit;
	
	TextureRegion[] TRp2fireNormal;
	TextureRegion[] TRp2fireAttack;
	TextureRegion[] TRp2fireHit;
	
	TextureRegion[] TRp1waterNormal;
	TextureRegion[] TRp1waterAttack;
	TextureRegion[] TRp1waterHit;
	
	TextureRegion[] TRp2waterNormal;
	TextureRegion[] TRp2waterAttack;
	TextureRegion[] TRp2waterHit;
	
	TextureRegion[] TRp1earthNormal;
	TextureRegion[] TRp1earthAttack;
	TextureRegion[] TRp1earthHit;
	TextureRegion[] TRp1earthLeaves;

	TextureRegion[] TRp2earthNormal;
	TextureRegion[] TRp2earthAttack;
	TextureRegion[] TRp2earthHit;
	TextureRegion[] TRp2earthLeaves;
	
	TextureRegion[] TRp1NeutralNormal;
	TextureRegion[] TRp1NeutralHit;
	
	TextureRegion[] TRp2NeutralNormal;
	TextureRegion[] TRp2NeutralHit;
	
	TextureRegion[] TRp1fireTransform;
	TextureRegion[] TRp1waterTransform;
	TextureRegion[] TRp1earthTransform;
	
	TextureRegion[] TRp2fireTransform;
	TextureRegion[] TRp2waterTransform;
	TextureRegion[] TRp2earthTransform;
	
	TextureRegion[] TRp1Hearts;
	TextureRegion[] TRp2Hearts;
	
	


	


	

	Color red;
	static Texture timerGameIcons;
	TextureRegion[] rpsIcons;
	Texture CSX;  //Circle Square X
	Texture damageWords;
	TextureRegion[] p1DmgWords;
	TextureRegion[] p2DmgWords;
	Texture boxer;
	TextureRegion[] p1BoxerPics;
	TextureRegion[] p2BoxerPics;
	Texture effects;
	TextureRegion[] p1EffectIcons;
	TextureRegion[] p2EffectIcons;
	Animation p1Boxer;
	Animation p2Boxer;
	Texture taunts;
	TextureRegion[] p1Taunt;
	TextureRegion[] p2Taunt;
	Texture bgTexture;
	

	
	int col;
	int row;
	
	TextureRegion p1CurrentFrame;
	TextureRegion p2CurrentFrame;	
	
	Label mainGameTimer;
	LabelStyle MGTStyle;  //Main Game Timer Style
	BitmapFont font;
	Stage timerStage;
	
	

	
	
	public WorldRenderer(TimeHandler timeHandler){
		/*
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		*/
		
		Texture.setEnforcePotImages(false); //enables textures of various dimensions to be loaded.
		
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		p1AnimeClock = new TimeHandler(TwoPlayerPlayScreen.stateTime);
		p2AnimeClock = new TimeHandler(TwoPlayerPlayScreen.stateTime);
		p1AnimeClock.setName("p1AnimeClock");
		p2AnimeClock.setName("p2AnimeClock");
		p1AnimeClock.setTimerDuration(3);
		p2AnimeClock.setTimerDuration(3);
		p1AnimeClock.resetTimer();
		p2AnimeClock.resetTimer();	
		
		p1y = h * 5/16;
		p2y = h * 5/8;
		
		
		p1AttackMS = h/128;
		p2AttackMS = h/128;
		p1DamagedMS = h/256;
		p2DamagedMS = h/256;

		
		
		//setPauseStatus(false);
		/*
		if (p1AnimeFrameTime > 3){
			
			p1AnimeFrameTime = timeHandler.getCurrentMomentInTime();
		}
		
		*/
		
		p1AnimeFrameTime = timeHandler.getCurrentMomentInTime();
		
		
		
		camera = new OrthographicCamera(1, h/w);
		
		batch = new SpriteBatch();
		batch2 = new SpriteBatch();
		pauseBatch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		

		player1Timer = new ShapeRenderer();
		sr2 = new ShapeRenderer();
		enemyTime = new ShapeRenderer();
//		texture = new Texture(Gdx.files.internal("cursor.png"));

		

		player1HPBar = new ShapeRenderer();
		p1HPBorder = new ShapeRenderer();
		p1Status = new ShapeRenderer();

		player2HP = new ShapeRenderer();
		p2HPBorder = new ShapeRenderer();
		p2Status = new ShapeRenderer();		

		backgroundRect = new ShapeRenderer();
		//markerCase = new ShapeRenderer();
		//cursorPosition = new Vector2();

		HPlines = new ShapeRenderer();
		
		background = new Texture(Gdx.files.internal("fwefloor2.png"));


		red = new Color(180,4,6,0);
		Texture.setEnforcePotImages(false);
		darkenedScreen = new Texture(Gdx.files.internal("darkenedScreen.png"));		
		
		
		CSX = new Texture(Gdx.files.internal("fwe2.png"));
		//timerGameIcons = new Texture("timergameicons2.png");
		//timerGameIcons.
		
		rpsIcons = new  TextureRegion[6];
		TextureRegion[][] tmp = TextureRegion.split(CSX, 16, 16);
		int index = 0;
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 3; j++){
				rpsIcons[index] = tmp[j][i];
				System.out.println("good!");
				index++;
			}
		}		
		
		/*
		Texture damageWords;
		TextureRegion[] dmgWords;
		Texture boxer;
		TextureRegion[] boxerPics;
		Texture effects;
		TextureRegion[] effectIcons;
		*/
		
		
		damageWords = new Texture(Gdx.files.internal("damageAndEffects.png"));
		p1DmgWords = new TextureRegion[6];
		TextureRegion[][] temp = TextureRegion.split(damageWords, 16, 16);
		index = 0;
		for (int i = 0; i < 6; i++){			
			p1DmgWords[i] = temp[1][i];	
		}
		
		
		p2DmgWords = new TextureRegion[6];
		for (int i = 0; i < 6; i++){
			p2DmgWords[i] = temp[2][i];
		}
		
		
		
		//boxer pic assignment
		
		boxer = new Texture(Gdx.files.internal("puncha.png"));
		p1BoxerPics = new TextureRegion[5];
		TextureRegion[][] temp1 = TextureRegion.split(boxer,16,16);
		index = 0;
		for (int i = 0; i < 2;  i++){
			for (int j = 0; j < 4; j++){
				
				if (index < 5){
					p1BoxerPics[index] = temp1[j][i];
					}
				index++;
			}

		}
		//end of p1 boxer pic assignment
		
		
		//p2 boxer pic assignement
		
		p2BoxerPics = new TextureRegion[8];
		
		temp1 = TextureRegion.split(boxer, 16, 16);
		index = 0;
		for (int i = 3; i > 1; i-- ){
			for (int j = 0; j < 4; j++){
				if (index < 6){
					p2BoxerPics[index] = temp1[j][i];
					index++;
				}
			}
		}
		
		
		
		
		//end of p2 boxer pic assignment
		
		//effects
		effects = new Texture(Gdx.files.internal("damageAndEffects.png"));
		
		//beginning of p1 effects
		p1EffectIcons = new TextureRegion[3];
		temp1 = TextureRegion.split(effects, 16, 16);
		//index = 0;
		for (int i = 0; i < 3; i++){
			p1EffectIcons[i] = temp1[0][i];
		}
		
		//end of p1 effects
		
		//beginning of p2 effects
		p2EffectIcons = new TextureRegion[3];
		temp1 = TextureRegion.split(effects, 16, 16);
		//index = 0;
		for (int i = 3; i < 6; i++){
			p2EffectIcons[i- 3] = temp1[0][i];
		}
		
		//end of p2 effects
		
		//p1 texture for the taunt
		taunts = new Texture(Gdx.files.internal("HAHA.png"));
		temp1 = TextureRegion.split(taunts, 32, 32);
		
		p1Taunt = temp1[0];
		p2Taunt = temp1[1];
		
		p1Background = new TextureRegion[3];
		temp1 = TextureRegion.split(background,48,32);
		for (int i =0; i < 1; i++){
			for (int j = 0; j < 3; j++){
				p1Background[j] = temp1[j][i];
				
			}
		}
		
		p2Background = new TextureRegion[3];
		temp1 = TextureRegion.split(background,48, 32);
		index = 0;
		for (int i = 1; i < 2; i++){
			for (int j = 0; j < 3; j++){
				p2Background[j] = temp1[j][i];
				index++;
			}
		}
		
		

		
		
		p1Boxer = new Animation(1, p1BoxerPics);
		p2Boxer = new Animation(1, p2BoxerPics);
		p1Boxer.setPlayMode(Animation.LOOP_PINGPONG);
		p2Boxer.setPlayMode(Animation.LOOP_PINGPONG);
		
		p1CurrentFrame = p1Boxer.getKeyFrame(0);
		p2CurrentFrame = p2Boxer.getKeyFrame(0);
		
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		MGTStyle = new LabelStyle(font, Color.BLACK);  //Main Game Timer Style
		timerStage = new Stage(w,h,true);
		mainGameTimer = new Label("0", MGTStyle);
		mainGameTimer.rotate(90);
		mainGameTimer.setPosition(0, h/2 + mainGameTimer.getWidth() * 2);
		
		
		
		timerBatch = new SpriteBatch();
		timerStage.addActor(mainGameTimer);
		
		timerNumberPic = new Texture(Gdx.files.internal("timerGameNumbers.png"));
		
		timerNumbers = new TextureRegion[10];
		temp1 = TextureRegion.split(timerNumberPic, 16, 16);
		for (int i = 0; i < 10; i++){
			int j = 0;
			timerNumbers[i] = temp1[i][j];
		}
		
		playbackTextures = new Texture(Gdx.files.internal("playbackButtons3.png"));
		playBackButtons = new TextureRegion[5];
		temp1 = TextureRegion.split(playbackTextures, 16, 16);
		for (int i = 0; i < 5; i++){
			int j = 0;
			playBackButtons[i] = temp1[i][j];
		}
		
		pauseButton = playBackButtons[0];
		
		winner = new Texture(Gdx.files.internal("winner2.png"));
		TRWinner = new TextureRegion[2];
		temp1= TextureRegion.split(winner, 64, 32);
		for (int i = 0; i < 2; i++){
			TRWinner[i] = temp1[i][0];
		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////gathering the slime sprites
		fullSlimeSpriteSheet = new Texture(Gdx.files.internal("slimeSpriteSheet2.png"));
		allSlimeSprites = new TextureRegion[90];
		
		temp1 = TextureRegion.split(fullSlimeSpriteSheet,16,16);
		int k = 0;
		for (int i = 0; i < 10; i++){
			
			for (int j = 0; j <9; j++){
				
				allSlimeSprites[k] = temp1[j][i];
						k++;
						//System.out.println(k);
			}
		}
		
		allSlimes = new Animation(0.6f,allSlimeSprites);
		allSlimes.getKeyFrame(0);
		
		
		TRp1fireNormal = new TextureRegion[3];
		TRp1fireAttack = new TextureRegion[3];
		TRp1fireHit = new TextureRegion[3];
		
		TRp2fireNormal = new TextureRegion[3];
		TRp2fireAttack = new TextureRegion[3];
		TRp2fireHit = new TextureRegion[3];
		
		TRp1waterNormal = new TextureRegion[3];
		TRp1waterAttack = new TextureRegion[3];
		TRp1waterHit = new TextureRegion[2];
		
		TRp2waterNormal = new TextureRegion[3];
		TRp2waterAttack = new TextureRegion[3];
		TRp2waterHit = new TextureRegion[2];
		
		TRp1earthNormal = new TextureRegion[3];
		TRp1earthAttack = new TextureRegion[3];
		TRp1earthHit = new TextureRegion[3];

		TRp2earthNormal = new TextureRegion[3];
		TRp2earthAttack = new TextureRegion[3];
		TRp2earthHit = new TextureRegion[3];
		
		TRp1earthLeaves = new TextureRegion[3];
		TRp2earthLeaves = new TextureRegion[3];
		
		TRp1NeutralNormal  = new TextureRegion[3];
		TRp1NeutralHit = new TextureRegion[2];
		
		TRp2NeutralNormal = new TextureRegion[3];
		TRp2NeutralHit = new TextureRegion[2];
		
		TRp1fireTransform = new TextureRegion[3];
		TRp1waterTransform = new TextureRegion[3];
		TRp1earthTransform = new TextureRegion[3];
		
		TRp2fireTransform = new TextureRegion[3];
		TRp2waterTransform = new TextureRegion[3];
		TRp2earthTransform = new TextureRegion[3];
		
		TRp1Hearts = new TextureRegion[2];
		TRp2Hearts = new TextureRegion[2];
		
		//////////////////////////////////////////////////////////////////////////assigning sprites to their animations
		//in sequence of the sprite sheet

		
		for (int i = 0; i <3; i++){
			TRp2fireNormal[i] = allSlimeSprites[i];
		}		
		
		for (int i = 3; i < 6; i++){
			TRp1fireNormal[i - 3] = allSlimeSprites[i];
		}		
		
		for (int i = 6; i < 9; i++){
			TRp2waterNormal[i - 6] = allSlimeSprites[i];
		}		
		
		for (int i = 9; i < 12; i++){
			TRp2fireAttack[i - 9] = allSlimeSprites[i];
		}
		
		for (int i = 12; i < 15; i++){
			TRp1fireAttack[i-12] = allSlimeSprites[i];
		}
		
		for (int i = 15; i < 18; i++){
			TRp2waterAttack[i-15] = allSlimeSprites[i];
		}
		
		for (int i = 18; i < 21; i ++){
			TRp2fireHit[i-18] = allSlimeSprites[i];
		}
		
		for (int i = 21; i < 24; i++){
			TRp1fireHit[i-21] = allSlimeSprites[i];
		}
		
		for (int i = 24; i < 26; i++){
			TRp2waterHit[i-24] = allSlimeSprites[i];
		}
		
		for (int i = 27; i < 30; i ++){
			TRp1waterNormal[i-27] = allSlimeSprites[i];
		}
		
		for (int i = 30; i < 33; i++){
			TRp2earthNormal[i-30] = allSlimeSprites[i];
		}
		
		for (int i = 33; i < 36; i++){
			TRp1earthNormal[i-33] = allSlimeSprites[i];			
		}
		
		for (int i = 36; i < 39; i++){
			TRp1waterAttack[i-36] = allSlimeSprites[i];			
		}
		
		for (int i = 39; i < 42; i++){
			TRp2earthAttack[i-39] = allSlimeSprites[i];
		}
		
		for (int i = 42; i < 45; i++){
			TRp1earthAttack[i-42] = allSlimeSprites[i];
		}
		
		for (int i = 45; i < 47; i++){
			TRp1waterHit[i-45] = allSlimeSprites[i];
		}
		
		for (int i = 48; i < 51; i++){
			TRp2earthHit[i-48] = allSlimeSprites[i];
		}
		
		for (int i = 51; i < 54; i++){
			TRp1earthHit[i-51] = allSlimeSprites[i];
		}		
		
		for (int i = 54; i <57; i++){
			TRp1NeutralNormal[i-54] = allSlimeSprites[i];
		}
		
		for (int i = 57; i < 60; i++){
			TRp2earthLeaves[i-57] = allSlimeSprites[i];
		}
		
		for (int i = 60; i < 63; i++){
			TRp1earthLeaves[i-60] = allSlimeSprites[i];			
		}
		
		for (int i = 63; i < 66; i++){
			TRp2NeutralNormal[i-63] = allSlimeSprites[i];
		}
		
		for (int i = 66; i < 69; i++){
			TRp1fireTransform[i-66] = allSlimeSprites[i];
		}
		
		for (int i = 69; i < 72; i++){
			TRp2fireTransform[i-69] = allSlimeSprites[i];
		}
		
		for (int i = 72; i < 74; i++){
			TRp1NeutralHit[i-72] = allSlimeSprites[i];
		}
		
		for (int i = 75; i < 78; i++){
			TRp2waterTransform[i-75] = allSlimeSprites[i];
		}
		
		for (int i = 78; i < 81; i++){
			TRp1waterTransform[i-78] = allSlimeSprites[i];
		}
		
		for (int i = 81; i < 83; i++){
			TRp2NeutralHit[i-81] = allSlimeSprites[i];
		}
		
		for (int i = 84; i < 86; i++){
			TRp2earthTransform[i-84] = allSlimeSprites[i];
		}
		
		for (int i = 87; i < 90; i++){
			TRp1earthTransform[i-87] = allSlimeSprites[i];
		}
		
		TRp1Hearts[0] = allSlimeSprites[26];
		TRp1Hearts[1] = allSlimeSprites[47];
		
		TRp2Hearts[0] = allSlimeSprites[74];
		TRp2Hearts[1] = allSlimeSprites[83];
		
		
		
		
		
		/////////////////////////////////////////////////////P2 Fire
		p2fireNormal = new Animation(0.5f, TRp2fireNormal);
		p2fireAttack = new Animation(0.2f, TRp2fireAttack);
		p2fireHit = new Animation(0.2f, TRp2fireHit);
		
		//////////////////////////////////////////////////////P1 Fire
		p1fireNormal = new Animation(0.5f, TRp1fireNormal);
		p1fireAttack = new Animation(0.2f, TRp1fireAttack);
		p1fireHit = new Animation(0.5f, TRp1fireHit);
		
		/////////////////////////////////////////////////////////P2 Water
		p2waterNormal = new Animation(0.5f, TRp2waterNormal);
		p2waterAttack = new Animation(0.2f, TRp2waterAttack);
		p2waterHit = new Animation(0.5f, TRp2waterHit);
		
		////////////////////////////////////////////////////////P1Water
		p1waterNormal = new Animation(0.5f, TRp1waterNormal);
		p1waterAttack = new Animation(0.2f, TRp1waterAttack);
		p1waterHit = new Animation(0.5f, TRp1waterHit);
		
		////////////////////////////////////////////////////////P2 Earth
		p2earthNormal = new Animation(0.5f, TRp2earthNormal);
		p2earthAttack = new Animation(0.6f, TRp2earthAttack);
		p2earthHit = new Animation(0.5f, TRp2earthHit);
		
		//////////////////////////////////////////////////////////P1Earth
		p1earthNormal = new Animation(0.5f, TRp1earthNormal);
		p1earthAttack = new Animation(1f, TRp1earthAttack);
		p1earthHit = new Animation(0.5f, TRp1earthHit);
		
		p1earthLeaves = new Animation(0.6f, TRp1earthLeaves);
		p2earthLeaves = new Animation(0.6f, TRp2earthLeaves);	
		///////////////////////////////////////////////////////////////Neutral
		p1NeutralNormal = new Animation(0.6f, TRp1NeutralNormal);
		p1NeutralHit = new Animation(0.6f, TRp1NeutralHit);
		
		p2NeutralNormal = new Animation(0.6f, TRp2NeutralNormal);
		p2NeutralHit = new Animation( 0.6f, TRp2NeutralHit);	
		

		///////////////////////////////////////////////////////////////HENSHIN
		p1fireTransform = new Animation(0.6f, TRp1fireTransform);
		
		p2waterTransform = new Animation(0.6f, TRp2waterTransform);
		p1waterTransform = new Animation(0.6f, TRp1waterTransform);

		p1earthTransform = new Animation(0.6f, TRp1earthTransform);
		p2earthTransform = new Animation(0.6f, TRp2earthTransform);
		
		////////////////////////////////////////////////////////////////HEART
		
		p1Hearts = new Animation(0.2f, TRp1Hearts);
		p2Hearts = new Animation(0.2f, TRp2Hearts);
	
		
		p1NeutralNormal.setPlayMode(Animation.LOOP_PINGPONG);
		p2NeutralNormal.setPlayMode(Animation.LOOP_PINGPONG);
		p2fireNormal.setPlayMode(Animation.LOOP_PINGPONG);
		
		
		/*
		p1fireNormal
		p1fireAttack
		p1fireHit
		
		p2fireNormal
		p2fireAttack
		p2fireHit
		
		p1waterNormal
		p1waterAttack
		p1waterHit
		
		p2waterNormal
		p2waterAttack
		p2waterHit
		
		p1earthNormal
		p1earthAttack
		p1earthHit

		p2earthNormal
		p2earthAttack
		p2earthHit
		
		p1earthLeaves;
		p2earthLeaves;
*/




		
		/*
		p1TauntClock = new Clocker();
		p2TauntClock = new Clocker();
		p1TauntClock.setName("p1TauntClock");
		p2TauntClock.setName("p2TauntClock");
		*/
		
		
		
		
		
		//texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		//sprite = new Sprite(region);
		//sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		

		

		//animeClock = new Clocker();
		

	}
	
	void update(String gameState, PlayerHandler playerHandler, float stateTime, WorldInput inputs, TimeHandler mainGameTimeHandler){
		
		

		//if (gameState == "playing"){
			//p1AnimeClock.update();
			//p2AnimeClock.update();
			
	
			//DRAWS THE ICON THAT INDICATES WHAT THEIR STATUS IS NOW RED/BLUE/GREEN
			/*
			batch.begin();
			//batch.draw(background, 0 - w/2, 0 - h/2, w, h);
	
			batch.end();
			*/
			backgroundRect.begin(ShapeType.Filled);
			backgroundRect.rect(0,0,w,h);
			backgroundRect.setColor(Color.valueOf("919191"));
			backgroundRect.end();
			p1AnimeClock.update(gameState, stateTime);
			p2AnimeClock.update(gameState, stateTime);
			
	
			
			if (p1AnimeClock.getTimeLeft() <= 0){
				p1AnimeClock.resetTimer();
			}
			
			if (p2AnimeClock.getTimeLeft() <= 0){
				p2AnimeClock.resetTimer();
			}
			

	
			
			/*
			p1Status.begin(ShapeType.Filled);
			if (playerHandler.player1.getStatus() == "green"){
				p1Status.rect(0, (float)(Gdx.graphics.getHeight() * 1/4), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p1Status.setColor(Color.valueOf("339900"));//green
			}
			else if (playerHandler.player1.getStatus() == "blue"){
				p1Status.rect(0, (float)(Gdx.graphics.getHeight() * 1/4), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p1Status.setColor(Color.valueOf("333366")); //blue
			}
			else if (playerHandler.player1.getStatus() == "red"){
				p1Status.rect(0, (float)(Gdx.graphics.getHeight() * 1/4), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p1Status.setColor(Color.valueOf("980000"));//red
			}
			p1Status.end();
			
			p2Status.begin(ShapeType.Filled);
			if (playerHandler.player2.getStatus() == "green"){
				p2Status.rect(0, (float)(Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight() * 1/16), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p2Status.setColor(Color.valueOf("339900"));//green
			}
			else if (playerHandler.player2.getStatus() == "blue"){
				p2Status.rect(0, (float)(Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight() * 1/16), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p2Status.setColor(Color.valueOf("333366")); //blue
			}
			else if (playerHandler.player2.getStatus() == "red"){
				p2Status.rect(0, (float)(Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight() * 1/16), Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 3/16);
				p2Status.setColor(Color.valueOf("980000"));//red
			}
			p2Status.end();
			*/
			
	
			
			
			
			batch.begin();
			//sprite.draw(batch);
	
			//then the same should be done for the player...perhaps.  Taken care of
			
			batch2.begin();
			
			//placement of floor icons for bottom player
			if (playerHandler.player1.getElementStatus() == "green"){
				batch2.draw(p1Background[2],0,h * 7/32, w, h * 1/4);  //height was originally h * 3/6 // orginal y coordinate: h * 7/32
			}
			else if (playerHandler.player1.getElementStatus() == "blue"){
				batch2.draw(p1Background[1],0,h * 7/32, w, h * 1/4);
			}
			else if (playerHandler.player1.getElementStatus() == "red"){
				batch2.draw(p1Background[0],0,h * 7/32, w, h * 1/4);
			}
			
			//placement of floor icons for top player
			if (playerHandler.player2.getElementStatus() == "green"){
				batch2.draw(p2Background[2],0,h * 17/32, w, h * 1/4);
			}
			else if (playerHandler.player2.getElementStatus() == "blue"){
				batch2.draw(p2Background[1],0,h * 17/32, w, h * 1/4);
			}
			else if (playerHandler.player2.getElementStatus() == "red"){
				batch2.draw(p2Background[0],0,h * 17/32, w, h * 1/4); //original height y location: h * 19/32
			}
			
			
			//draws the attack icons on the player 1 side
			
			for (int i = 0; i < 3; i++){
				batch2.draw(rpsIcons[i], (i * w/6) + w/16, w * 3/32, w/16, w/16);
			}
			
			for (int i = 0; i < 3; i++){
				batch2.draw(rpsIcons[i], ((i  + 3) * w/6 ) + w * 1/32, w/16, w/8, w/8);// in the x argument, the part in parentheses spaces the icons. the part after adjusts the icons
			}
			
			//draws attack icons on the player 2 side
			for (int i = 3; i < 6; i++){			
				batch2.draw(rpsIcons[i], (8 - i) * w/6 + w /16  , (h * 15/16) - ( w/32), w/16, w/16);			
			}
			
			for (int i = 3; i < 6; i++){
				batch2.draw(rpsIcons[i], (5 - i) * w/6 + w/32, h  - (w * 3/16), 2* w/16, 2 * w/16);
			}
			
			
			//placement of the lil icon for available action for enemy (P2) 
			if (playerHandler.p2TimeHandler.getTimePassedPercent() > 0 && playerHandler.p2TimeHandler.getTimePassedPercent() < (100/7) ){			
			}
			else if (playerHandler.p2TimeHandler.getTimePassedPercent() >= 100/7 && playerHandler.p2TimeHandler.getTimePassedPercent() < (100/7)*2){
				batch2.draw(playBackButtons[3], w - w/8 - (w * 1/128) , h - (w *3/16), w/8, w/8);
				//%%batch2.draw(icons[1], Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()                SET ICONS HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEXXX
			}
			else if(playerHandler.p2TimeHandler.getTimePassedPercent() >= (100/7 ) * 2 && playerHandler.p2TimeHandler.getTimePassedPercent() < (100/7)*3){
				batch2.draw(playBackButtons[3], w* 5/6 - w/8 - (w * 1/128) , h - (w *3/16), w/8, w/8);
			}
			else if(playerHandler.p2TimeHandler.getTimePassedPercent() >= (100/7) * 3 && playerHandler.p2TimeHandler.getTimePassedPercent() < (100/7)*4){
				batch2.draw(playBackButtons[3], w * 4/6 - w/8 - (w * 1/128), h - (w * 3/16), w/8, w/8);
			}
			else if(playerHandler.p2TimeHandler.getTimePassedPercent() >= (100/7)* 4  && playerHandler.p2TimeHandler.getTimePassedPercent() < (100/7)*5){
				batch2.draw(playBackButtons[3], w*3/6 - w/8 - (w * 1/128) , h - (w * 3/16), w/8, w/8);
			}
			else if(playerHandler.p2TimeHandler.getTimePassedPercent() >= (100/7) * 5 && playerHandler.p2TimeHandler.getTimePassedPercent() <= (100/7)*6){
				batch2.draw(playBackButtons[3], w*2/6 - w/8 - (w * 1/128), h - (w * 3/16), w/8, w/8);
			}
			else if(playerHandler.p2TimeHandler.getTimePassedPercent() >= 100/7 * 6 && playerHandler.p2TimeHandler.getTimePassedPercent() <= 100){
				batch2.draw(playBackButtons[3],  w/6 - w/8 - (w * 1/128), h - (w * 3/16), w/8, w/8);
			}
			else{			
			}
			
			//placement of the lil icon for available action for player (P1)  
			if (playerHandler.p1TimeHandler.getTimePassedPercent() > 0 && playerHandler.p1TimeHandler.getTimePassedPercent() < 100/7){
				
			}
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 && playerHandler.p1TimeHandler.getTimePassedPercent() < ((100/7) * 2)){
				batch2.draw(playBackButtons[3], w/6 - w/8 - (w * 1/128) , w/16, w/8, w/8);
			}
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 * 2 && playerHandler.p1TimeHandler.getTimePassedPercent() < 100/7 * 3){
				batch2.draw(playBackButtons[3], w * 2/6 - w/8 - (w * 1/128) , w/16, w/8, w/8);
			}
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 * 3 && playerHandler.p1TimeHandler.getTimePassedPercent() < 100/7 * 4){
				batch2.draw(playBackButtons[3], w/2 - w/8 - (w * 1/128) , w/16, w/8, w/8);
			}
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 * 4 && playerHandler.p1TimeHandler.getTimePassedPercent() < 100/7 * 5){
				batch2.draw(playBackButtons[3], w * 2/3 - w/8 - (w * 1/64) , w/16, w/8, w/8);
			}		
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 * 5 && playerHandler.p1TimeHandler.getTimePassedPercent() < 100/7 * 6){
				batch2.draw(playBackButtons[3], w * 5/6 - w/8 - (w * 1/128), w/16, w/8, w/8);
			}
			else if(playerHandler.p1TimeHandler.getTimePassedPercent() >= 100/7 * 6 && playerHandler.p1TimeHandler.getTimePassedPercent() <= 100){
				batch2.draw(playBackButtons[3], w - w/8 - (w * 1/128), w/16, w/8, w/8);
			}
			
			else{			
			}
			batch2.end();
			
			//batch.end();		
			//playerHandler.p1TimeHandler.setPlayerInput(Gdx.input.isButtonPressed(Buttons.LEFT));
			//playerHandler.p2TimeHandler.setPlayerInput(Gdx.input.isKeyPressed(Keys.SPACE));
	
			
			//PLACEMENT OF THE AREA WHERE THE ATTACK SELECTER ICON SHOULD SHOW UP
			/*
			markerCase.begin(ShapeType.Line);
			markerCase.rect(Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight() * 12/15, texture.getWidth(), texture.getHeight());
			markerCase.rect(Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight() * 2/15, texture.getWidth(), texture.getHeight());
			for (int i = 2; i <7; i++){
				markerCase.rect(Gdx.graphics.getWidth() * i/7, Gdx.graphics.getHeight() * 2/15, texture.getWidth(), texture.getHeight());
				markerCase.rect(Gdx.graphics.getWidth() * i/7, Gdx.graphics.getHeight() * 12/15, texture.getWidth(), texture.getHeight());		
			}
			//gotta make a way to maintain the locations of the empty squares where the marker will show up
			markerCase.setColor(Color.BLUE);
			markerCase.end();
			*/
			
			
			
			
			//PLAYER TIMERS AND HP BARS
			/*
			player1Timer.begin(ShapeType.Filled);
			player1Timer.rect(0, (float)(Gdx.graphics.getHeight() * 3/16), (float)(Gdx.graphics.getWidth() * playerHandler.p1TimeHandler.timePassedPercent * 0.01), (float)(Gdx.graphics.getHeight()/32));
			player1Timer.setColor(Color.BLUE);		
			player1Timer.end();
			
			enemyTime.begin(ShapeType.Filled);
			enemyTime.rect(Gdx.graphics.getWidth(), (float)Gdx.graphics.getHeight()* 25/32, (float)(Gdx.graphics.getWidth() * -playerHandler.p2TimeHandler.timePassedPercent * 0.01f), (float)(Gdx.graphics.getHeight()/32));
			enemyTime.setColor(Color.RED);	
			enemyTime.end();
			*/
			
			
			
			
			
			//no longer needed
			/*  5s countdown timer
			sr2.begin(ShapeType.Filled);
			sr2.rect(10, Gdx.graphics.getHeight()-Gdx.graphics.getHeight()* 2/15, playerHandler.p1TimeHandler.timeLeftPercent * 2, Gdx.graphics.getHeight()/15);
			sr2.setColor(Color.GRAY);
			sr2.end();
			*/
			
			/*
			HPlines.begin(ShapeType.Filled);  //lines to show parts of the HP bars
			for (int i = 1; i < 11; i++){
				HPlines.rect(w * 1/10 * i ,h/2 - h/32,1, h/16 );
			}
			
			
			HPlines.rect(w * 16/playerHandler.player1.getMaxHP(), h/2,2, h/16 );
			HPlines.setColor(Color.BLACK);
			HPlines.end();
			*/
			
			
			//p1 HP border and meter
			
			player1HPBar.begin(ShapeType.Filled);
			player1HPBar.rect(0, h * 3/16, (w  * playerHandler.player1.getHPPercent() * 0.01f) , h/32 ); // move Y to H * 3/16 // old height: h/2 - h/16 //old starting point: (w -w/4) * (playerHandler.player1.getHPPercent() * 0.01f)
			player1HPBar.setColor(Color.valueOf("33CC00"));
			player1HPBar.end();
			
			p1HPBorder.begin(ShapeType.Line);
			p1HPBorder.rect(0, h * 3/16, w, h/32 );  
			p1HPBorder.setColor(Color.BLACK);//(Color.valueOf("33CC33"));
			p1HPBorder.end();
			
	
			//p2 HP border and meter		
			
			player2HP.begin(ShapeType.Filled);
			player2HP.rect(w, h * 25/32, (w  * -playerHandler.player2.getHPPercent() * 0.01f), h/32 ); // move to h * 25/32 // old height h/2 // old starting point: ((w - w/4) * -playerHandler.player2.getHPPercent() * 0.01f)
			player2HP.setColor(Color.valueOf("CC0033"));
			player2HP.end();	
			
			p2HPBorder.begin(ShapeType.Line);
			p2HPBorder.rect(0, h * 25/32, w, h/32);
			p2HPBorder.setColor(Color.BLACK);//(Color.RED);
			p2HPBorder.end();
			
			batch.end();
			
			
			
			batch2.begin();
			
			//draw the attack damage base value
			
			for (int i = 0; i < 6; i++){
				batch2.draw(p1DmgWords[i], (w/6 * i  ) + w/16, 0,w/16, w/16);
			}
			for (int i = 0; i < 6; i++){
				batch2.draw(p2DmgWords[i], (w/6 * i  ) + w/16, h - w/16,w/16, w/16);
			}
	
			

			
			
			
			/*
			//animate the player's boxers
			for (int i = 0; i < 5; i ++){
				batch2.draw(p1BoxerPics[i], (w/7 * i + 1 ) - p1BoxerPics[i].getRegionWidth() * 1/24, h * 1/5,w/12, w/12);
				batch2.draw(p2BoxerPics[i], (w/7 * i + 1 ) - p2BoxerPics[i].getRegionWidth() * 1/24, h * 4/5,w/12, w/12);
				
			}
			*/
			
			
			//draw the icons that show the effect of the player's attack (x1, heal, 2x dmg)
			/*
			for (int i = 0; i < 3; i++){
				batch2.draw(p1EffectIcons[i], (w/7 * i + 1 ) - p1EffectIcons[i].getRegionWidth() * 1/24, h/3,w/12, w/12);
			}
			*/
			
			
			//COME BACK TO THIS
			/*
			 * 
			
			//code for displaying the attack effectiveness icons
			
			//player 1(bottom)
			if (playerHandler.player2.getElementStatus() == "green"){
				for (int i = 0; i < 3; i++){
					
					for (int j = 0; j < 3; j++){
						int k = 0;
						if (i == 1){
							k = 3;
						}
						if (i == 2){
							k = 6;
						}					
						batch2.draw(p1EffectIcons[2 - j ],  (j + k) * w/6 - w * 3/32 , w * 7/32, w/16, w/16);	
					}				
				}
			}
			else if (playerHandler.player2.getElementStatus() == "red"){
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						int k = 0;
						if (i == 1){
							k = 3;
						}
						else if (i == 2){
							k = 6;
						}
						int l = k + j;				
					batch2.draw(p1EffectIcons[2 - j],  (l) * w/6 + w/16, w * 7/32, w/16, w/16);
					}				
				}
			}
			else if (playerHandler.player2.getElementStatus() == "blue"){
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						int k = 0;
						if (i == 1){
							k = 3;
						}
						else if (i == 2){
							k = 6;
						}
						int l = k + j;				
					batch2.draw(p1EffectIcons[2 - j],  (l - 2) * w/6 + w/16, w * 7/32, w/16, w/16);
					}
					
				}
			}
	
			//placing effectiveness icons for player 2 (top)
			if (playerHandler.player1.getElementStatus() == "blue"){
				
				//int l = 3;
				for (int i = 0; i < 3; i++){
					for (int j  = 0; j < 3; j++){
						
						int k = 0;
						int  l;
						
						switch (i){
							case 0: k = -2;
								break;
							case 1: k = 1;
								break;
							case 2: k = 4;
								break;
						}					
				
						l = j + k;					
						batch2.draw(p2EffectIcons[j],  (l + 1) * w/6 + w/16, h - w * 9/32, w/16, w/16);					
					}
				}
			}
			
			if (playerHandler.player1.getElementStatus() == "green"){
						
				//int l = 3;
				for (int i = 0; i < 3; i++){
					for (int j  = 0; j < 3; j++){
						
						int k = 0;
						int  l;
						
						switch (i){
							case 0: k = -1;
								break;
							case 1: k = 2;
								break;
							case 2: k = 5;
								break;
						}					
						l = j + k;					
						batch2.draw(p2EffectIcons[j],  (l - 1) * w/6 + w/16, h - w * 9/32, w/16, w/16);					
					}
				}
			}
			
			if (playerHandler.player1.getElementStatus() == "red"){
				
				//int l = 3;
				for (int i = 0; i < 3; i++){
					for (int j  = 0; j < 3; j++){
						
						int k = 0;
						int  l;
						
						switch (i){
							case 0: k = 0;
								break;
							case 1: k = 3;
								break;
						}
						
						l = j + k;					
						batch2.draw(p2EffectIcons[ j],  (l ) * w/6 + w/16, h - w * 9/32, w/16, w/16);					
					}
				}
			}
			//end of attack effectiveness icons
			
			*/
			batch2.end();
			
			
			batch2.begin();
			
			
			//player character placement on screen
			
			p1AnimeClock.debug(gameState);  //for pause testing
			
			
			//normal character placement
		//p1AnimeClock.debug();  //for pause testing
		
		if (playerHandler.player1.getStatus() == "normal" && playerHandler.player1.getElementStatus() == "red"){
			if (p1AnimeClock.getTimePassed() < 3){
				batch2.draw(p1fireNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
			}
			else {
				p1AnimeClock.setFrozenMomentInTime();	
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		else if (playerHandler.player1.getStatus() == "normal" && playerHandler.player1.getElementStatus() == "blue"){
			if (p1AnimeClock.getTimePassed() < 3){
				batch2.draw(p1waterNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
			}
			else {
				p1AnimeClock.setFrozenMomentInTime();	
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}		

		else if (playerHandler.player1.getStatus() == "normal" && playerHandler.player1.getElementStatus() == "green"){
			if (p1AnimeClock.getTimePassed() < 3){
				batch2.draw(p1earthNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
			}
			else {
				p1AnimeClock.setFrozenMomentInTime();	
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		//normal character placement	
	
		else if (playerHandler.player1.getStatus() == "normal"){
			if (p1AnimeClock.getTimePassed() < 3){
				batch2.draw(p1NeutralNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
			}
			else {
				p1AnimeClock.setFrozenMomentInTime();	
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		
		
		
		
		p2AnimeClock.debug(gameState);  //for pause testing
		
		//p2AnimeClock.debug();  //for pause testing
		if (playerHandler.player2.getStatus() == "normal" && playerHandler.player2.getElementStatus() == "red"){
			if (p2AnimeClock.getTimePassed() < 3){
				batch2.draw(p2fireNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/8, w/8, w/8);
			}
			else {
				p2AnimeClock.setFrozenMomentInTime();	//if the clock goes past 3 in the above if statement, make the current time the new starting point ( I think)
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		
		//p2AnimeClock.debug();  //for pause testing
		else if (playerHandler.player2.getStatus() == "normal" && playerHandler.player2.getElementStatus() == "blue"){
			if (p2AnimeClock.getTimePassed() < 3){
				batch2.draw(p2waterNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/8, w/8, w/8);
			}
			else {
				p2AnimeClock.setFrozenMomentInTime();	//if the clock goes past 3 in the above if statement, make the current time the new starting point ( I think)
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		
		
		//p2AnimeClock.debug();  //for pause testing
		else if (playerHandler.player2.getStatus() == "normal" && playerHandler.player2.getElementStatus() == "green"){
			if (p2AnimeClock.getTimePassed() < 3){
				batch2.draw(p2earthNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/8, w/8, w/8);
			}
			else {
				p2AnimeClock.setFrozenMomentInTime();	//if the clock goes past 3 in the above if statement, make the current time the new starting point ( I think)
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		
		else if (playerHandler.player2.getStatus() == "normal"){
			if (p2AnimeClock.getTimePassed() < 3){
				batch2.draw(p2NeutralNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/8, w/8, w/8);
			}
			else {
				p2AnimeClock.setFrozenMomentInTime();	//if the clock goes past 3 in the above if statement, make the current time the new starting point ( I think)
				//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
			}
		}
		
		
			
			
			
			
			
			
			/////////////////////////////////////////////////////////////attacking
			//character attack placement
			if (playerHandler.player1.getStatus() == "attacking"){
				if (p1AnimeClock.getTimePassed() < 3){
			
			
					if (playerHandler.player1.getElementStatus() == "red"){
						if (playerHandler.player1.getStatus() == "attacking"){
							if (p1y < h * 7/16){
								batch2.draw(p1fireAttack.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);
								p1y += p1AttackMS;
							}
							else{
								playerHandler.player1.setStatus("normal");
								resetP1y();
							}
						}					
					}
					else if (playerHandler.player1.getElementStatus() == "blue"){
						if (playerHandler.player1.getStatus() == "attacking"){
							if (p1y < h * 7/16){
							batch2.draw(p1waterAttack.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);
							p1y += p1AttackMS;
							}
							else{
								playerHandler.player1.setStatus("normal");
								resetP1y();
							}
						}	
					}
					else if (playerHandler.player1.getElementStatus() == "green"){
						if (playerHandler.player1.getStatus() == "attacking"){
							batch2.draw(p1earthAttack.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
							if(p1y < h * 7/16 ){
							
							batch2.draw(p1earthLeaves.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y + w/8, w/8, w/8);
							p1y += p1AttackMS;
							}
							else{
								playerHandler.player1.setStatus("normal");
								resetP1y();
							}

							
						}	
					}
				}
				else{
					p1AnimeClock.setFrozenMomentInTime();
				}  // end of time reset
			} // end of player1 attacking


			if (playerHandler.player2.getStatus() == "attacking"){
				if (p2AnimeClock.getTimePassed() < 3){
				
					if (playerHandler.player2.getElementStatus() == "red"){
						if (playerHandler.player2.getStatus() == "attacking"){
							if (p2y > h* 1/2){
							batch2.draw(p2fireAttack.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);  //h * 5/8 is normal  h * 9/16 is p2 attack height
							p2y -= p2AttackMS;}
							else{						
								playerHandler.player2.setStatus("normal");
								resetP2y();
							}
							//playerHandler.player2.setStatus("normal");
						}
					}
					else if (playerHandler.player2.getElementStatus() == "blue"){
						if (playerHandler.player2.getStatus() == "attacking"){
							if (p2y > h * 1/2){
							batch2.draw(p2waterAttack.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);
							p2y -= p2AttackMS;}
							else{						
								playerHandler.player2.setStatus("normal");
								resetP2y();
							}
							//playerHandler.player2.setStatus("normal");
						}
					}
					else if (playerHandler.player2.getElementStatus() == "green"){
						if (playerHandler.player2.getStatus() == "attacking"){
							batch2.draw(p2earthAttack.getKeyFrame(3), w/2 - w/16, h * 5/8, w/8, w/8);
							if (p2y > h* 1/2){
								batch2.draw(p2earthLeaves.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y - w/8, w/8, w/8);
								p2y -= p2AttackMS;
							}
								//playerHandler.player2.setStatus("normal");
							else{
								playerHandler.player2.setStatus("normal");
								resetP2y();
							}
						}						

					}
						
				} //end of timer constraints
				else{
					p2AnimeClock.setFrozenMomentInTime();
				}//timer reset
			}// end of player 2 attacking

			
			/////////////////////////////////////////////////////////taunt
			//taunt placement
			//p1 taunting p2 (should show on top side)
			if (playerHandler.player1.getStatus() == "taunting"){
				//p1TauntClock.timer(1);
				batch2.draw(p2Taunt[0], playerHandler.player2.tauntX - p2Taunt[0].getRegionWidth(), playerHandler.player2.p2TauntY, w/4, w/4);  //draw taunt on p2 side
				if (p1AnimeClock.getTimePassed() < 3){
					batch2.draw(p1NeutralNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8); //draw p1 doing regular motions
				}
				else {
					p1AnimeClock.setCurrentMomentInTime(p1AnimeClock.stateTime);	
					//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
				}
				/*
				if( p1TauntClock.getTimeLeft() == 0){
					playerHandler.player1.setStatus("normal");
				}
				*/
			}
	
			if (playerHandler.player2.getStatus() == "taunting"){
				batch2.draw(p1Taunt[0], playerHandler.player1.tauntX - p1Taunt[0].getRegionWidth(), playerHandler.player1.p1TauntY, w/4, w/4);
				
				if (p2AnimeClock.getTimePassed() < 3){
					batch2.draw(p2NeutralNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/8, w/8, w/8); 
				}
				else {
					p2AnimeClock.setCurrentMomentInTime(p2AnimeClock.stateTime);	
					//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
				}
			}
			
			////////////////////////////////////////////////////////taking damage
			

			
			
			if (playerHandler.player1.getStatus() == "damaged" && playerHandler.player1.getElementStatus() == "red"){
				//batch2.draw(p1Boxer.getKeyFrame(5), w/2 - w/16, h * 1/4, w/8, w/8);
				if ( p1y > h * 1/4){
					p1y -= p1DamagedMS;
					if (p1AnimeClock.getTimePassed() < 3){						
						batch2.draw(p1fireHit.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);  //p1 pushed back limit should be h * 4/16?
						
					}
					else {
						p1AnimeClock.setCurrentMomentInTime(p1AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player1.setStatus("normal");
					resetP1y();
				}
			}
			
			else if (playerHandler.player1.getStatus() == "damaged" && playerHandler.player1.getElementStatus() == "blue"){
				//batch2.draw(p1Boxer.getKeyFrame(5), w/2 - w/16, h * 1/4, w/8, w/8);
				if ( p1y > h * 1/4){
					p1y -= p1DamagedMS;
					if (p1AnimeClock.getTimePassed() < 3){						
						batch2.draw(p1waterHit.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);  //p1 pushed back limit should be h * 4/16?
						
					}
					else {
						p1AnimeClock.setCurrentMomentInTime(p1AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player1.setStatus("normal");
					resetP1y();
				}
			}
			
			else if (playerHandler.player1.getStatus() == "damaged" && playerHandler.player1.getElementStatus() == "green"){
				//batch2.draw(p1Boxer.getKeyFrame(5), w/2 - w/16, h * 1/4, w/8, w/8);
				if ( p1y > h * 1/4){
					p1y -= p1DamagedMS;
					if (p1AnimeClock.getTimePassed() < 3){						
						batch2.draw(p1earthHit.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);  //p1 pushed back limit should be h * 4/16?
						
					}
					else {
						p1AnimeClock.setCurrentMomentInTime(p1AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player1.setStatus("normal");
					resetP1y();
				}
			}			
			
			else if (playerHandler.player1.getStatus() == "damaged"){
				//batch2.draw(p1Boxer.getKeyFrame(5), w/2 - w/16, h * 1/4, w/8, w/8);
				
				if (p1y > h * 4/16){
					if (p1AnimeClock.getTimePassed() < 3){					
						batch2.draw(p1NeutralHit.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, p1y, w/8, w/8);  //p1 pushed back limit should be h * 5/16?
						p1y -= p1DamagedMS;
					}
					else {
						p1AnimeClock.setCurrentMomentInTime(p1AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player1.setStatus("normal");
					resetP1y();
				}
			}
			
			
			

			
			if (playerHandler.player2.getStatus() == "damaged" && playerHandler.player2.getElementStatus() == "red"){

				if (p2y < h * 6/8){
					
					if (p2AnimeClock.getTimePassed() < 3){
						batch2.draw(p2fireHit.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);  //p1 pushed back limit should be h * 5/8?
						p2y += p2DamagedMS;
					}
					else {						
						p2AnimeClock.setCurrentMomentInTime(p2AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player2.setStatus("normal");
					resetP2y();
				}
			}
			
			else if (playerHandler.player2.getStatus() == "damaged" && playerHandler.player2.getElementStatus() == "blue"){

				if (p2y < h * 6/8){
					
					if (p2AnimeClock.getTimePassed() < 3){
						batch2.draw(p2waterHit.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);  //p1 pushed back limit should be h * 5/8?
						p2y += p2DamagedMS;
					}
					else {						
						p2AnimeClock.setCurrentMomentInTime(p2AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player2.setStatus("normal");
					resetP2y();
				}
			}
			
			else if (playerHandler.player2.getStatus() == "damaged" && playerHandler.player2.getElementStatus() == "green"){

				if (p2y < h * 6/8){
					
					if (p2AnimeClock.getTimePassed() < 3){
						batch2.draw(p2earthHit.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);  //p1 pushed back limit should be h * 5/8?
						p2y += p2DamagedMS;
					}
					else {						
						p2AnimeClock.setCurrentMomentInTime(p2AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player2.setStatus("normal");
					resetP2y();
				}
			}
			
			else if (playerHandler.player2.getStatus() == "damaged"){

				if (p2y < h * 6/8){
					
					if (p2AnimeClock.getTimePassed() < 3){
						batch2.draw(p2NeutralHit.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, p2y, w/8, w/8);  //p1 pushed back limit should be h * 5/8?
						p2y += p2DamagedMS;
					}
					else {						
						p2AnimeClock.setCurrentMomentInTime(p2AnimeClock.stateTime);	
						//p1AnimeClock.setTimePassed(p1AnimeClock.momentInTime);
					}
				}
				else{
					playerHandler.player2.setStatus("normal");
					resetP2y();
				}
			}
			
			
			
			
			////////////////////////////////////////////////////////////healing
			if (playerHandler.player1.getStatus() == "healed"){
				if (p1AnimeClock.getTimePassed() < 2){
					batch2.draw(p1Hearts.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 5/16, w/8, w/8);
				}
				if (p1AnimeClock.getTimePassed() < 3){
					
					batch2.draw(p1NeutralNormal.getKeyFrame(p1AnimeClock.getTimePassed()), w/2 - w/16, h * 6/16, w/8, w/8);
	
				}
			}
			else{
				p1AnimeClock.setFrozenMomentInTime();
			}
			
			if (playerHandler.player2.getStatus() == "healed"){
				if (p2AnimeClock.getTimePassed() < 2){
					batch2.draw(p2Hearts.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 10/16, w/8, w/8);
				}
				if (p2AnimeClock.getTimePassed() < 3){
					
					batch2.draw(p2NeutralNormal.getKeyFrame(p2AnimeClock.getTimePassed()), w/2 - w/16, h * 9/16, w/8, w/8);
				}
			}
			else{
				p2AnimeClock.setFrozenMomentInTime();
			}
			

			
			
			/*
			for (int i = 7; i > 0; i--){
				batch2.draw(icons[i], icons[i].getRegionWidth() + ((i ) * Gdx.graphics.getWidth()/7),Gdx.graphics.getHeight() * 13/15, 2* Gdx.graphics.getWidth()/15, 2 * Gdx.graphics.getHeight()/15);			
			}		
			for (int i = 7; i > 4; i--){
				batch2.draw(icons[i], (i +1) * Gdx.graphics.getWidth()/7 - icons[i].getRegionWidth()/2, Gdx.graphics.getHeight() * 14/15, Gdx.graphics.getWidth()/15, Gdx.graphics.getHeight()/15);
			}
			*/
			batch2.end();
			
			
			//PAUSE BUTTON PLACEMENT
			/*
			pauseBatch.begin();		
			pauseBatch.draw(pauseButton, w - w/8, h/2 - w/16, w/8, w/8);
			if (gameState == "paused"){
				pauseBatch.draw(darkenedScreen, 0, 0, w, h);
			}
			pauseBatch.end();
			*/
			
			
	
			
			
			
			//using FONTS for implementing the TIMER NUMBERS
			//mainGameTimer.setFontScale(w/8,w/8);	
			/*
			mainGameTimer.rotate(180);
			mainGameTimer.setRotation(180);
			mainGameTimer.setText(Integer.toString((int)(100- stateTime)));
			mainGameTimer.setColor(Color.BLACK);
			mainGameTimer.setSize(w/8, w/8);
	
			timerStage.draw();
	
			timerStage.act();
			
			*/
			
			
			
			//Drawing Timer numbers 
			timerBatch.begin();
			
			//TENS
			if ((100 - mainGameTimeHandler.timePassed)/10 >= 9){			
				timerBatch.draw(timerNumbers[9], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 8){			
				timerBatch.draw(timerNumbers[8], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 7){			
				timerBatch.draw(timerNumbers[7], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 6){			
				timerBatch.draw(timerNumbers[6], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 5){			
				timerBatch.draw(timerNumbers[5], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 4){			
				timerBatch.draw(timerNumbers[4], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 3){			
				timerBatch.draw(timerNumbers[3], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 2){			
				timerBatch.draw(timerNumbers[2], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 1){			
				timerBatch.draw(timerNumbers[1], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - mainGameTimeHandler.timePassed)/10 > 0){			
				timerBatch.draw(timerNumbers[0], w/8, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			
	
			
			
			
			timerBatch.end();
			
			timerBatch.begin();
			//ONES
			
			if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 0 ){
				timerBatch.draw(timerNumbers[9], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 9 ){
				timerBatch.draw(timerNumbers[8], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 8 ){
				timerBatch.draw(timerNumbers[7], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 7 ){
				timerBatch.draw(timerNumbers[6], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 6 ){
				timerBatch.draw(timerNumbers[5], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 5 ){
				timerBatch.draw(timerNumbers[4], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 4 ){
				timerBatch.draw(timerNumbers[3], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 3 ){
				timerBatch.draw(timerNumbers[2], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 2 ){
				timerBatch.draw(timerNumbers[1], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			else if ((100 - (int)mainGameTimeHandler.timePassed)%10 == 1 ){
				timerBatch.draw(timerNumbers[0], 0, h/2 - w * 1/16, w * 1/8, w * 1/8);
			}
			
			timerBatch.end();
			
			
			
			
			
			//if (gameState == "over"){
				pauseBatch.begin();
				
				//pauseBatch.draw(allSlimes.getKeyFrame(mainGameTimeHandler.getTimePassed()), w/2, h/2, w/4, w/4);
				
				if (gameState == "over"){
				
					if (playerHandler.player1.getVictoryStatus() == "draw"){
						pauseBatch.draw(darkenedScreen, 0, 0, w, h);
						pauseBatch.draw(TRWinner[0], w/2 - (w * 3/8), (h * 1/4) - (w * 1/4),  w*3/4, w * 1/2);
						pauseBatch.draw(TRWinner[1], w/2  - ( w * 3/8), (h * 3/4) - (w * 1/4),  w*3/4, w * 1/2);
					}
					else if (playerHandler.player2.getVictoryStatus() == "winner"){
						pauseBatch.draw(darkenedScreen, 0, 0, w, h);
						pauseBatch.draw(TRWinner[1], w/2  - (w * 3/8), (h * 1/2) - (w * 1/4),  w*3/4, w * 1/2);
						//pauseBatch.draw(darkenedScreen);
						//winner is flipped for the top player
						
					}
					else if (playerHandler.player1.getVictoryStatus() == "winner"){
						pauseBatch.draw(darkenedScreen, 0, 0, w, h);
						pauseBatch.draw(TRWinner[0], w/2 - w * 3/8, (h * 1/2) - (w * 1/4),  w*3/4, w * 1/2);
					}
				}
					
					
					
				
	
				
				pauseBatch.end();
			//}			
		//}//end of if (gameState == "playing"
				
		
		

	}
	//end of render/update//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	void setP1CurrentFrame(int currentFrame){
		p1CurrentFrame = p1Boxer.getKeyFrame(currentFrame);
	}
	
	void setP2CurrentFrame(int currentFrame){
		p2CurrentFrame = p2Boxer.getKeyFrame(currentFrame);
	}
	
	TextureRegion getP1CurrentFrame(){
		return p1CurrentFrame;
	}
	
	TextureRegion getP2CurrentFrame(){
		return p2CurrentFrame;
	}
	
	/*
	hold on.  Gonna set Taunt location in the player class.
	void p1Taunt(Button p1Button, ){
		
	}
	*/

	
	void resetP1y(){
		p1y = h * 5/16;
	}
	
	void resetP2y(){
		p2y = h * 5/8;
	}
	
	/*
	int shake(float yPosition){
		yPosition += 2;
		yPosition -=4;
		yPosition += 2;
		//return
	}
	*/
	



}

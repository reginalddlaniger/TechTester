package com.me.techTester;

import com.badlogic.gdx.Game;

public class ScreenHandler {
	
	static OnePlayerPlayScreen onePlayerPlayScreen;
	static TwoPlayerPlayScreen twoPlayerPlayScreen;
	static MainMenu mainMenu;
	static PauseMenu pauseMenu;
	static EndMenu endMenu;
	
	public ScreenHandler(TechTester game){
		onePlayerPlayScreen = new OnePlayerPlayScreen(game);
		twoPlayerPlayScreen = new TwoPlayerPlayScreen(game);
		mainMenu = new MainMenu(game);
		pauseMenu = new PauseMenu(game);

	}

}

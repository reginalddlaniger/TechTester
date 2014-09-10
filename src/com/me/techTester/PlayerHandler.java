package com.me.techTester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class PlayerHandler {
	
	TimeHandler p1TimeHandler, p2TimeHandler, foeTimeHandler;
	Player player1, player2; 
	Foe foe;
	String gameMode;  //gameMode can be "onePlayer" or "twoPlayer" and is determined by the onePlayerPlayScreen or the TwoPlayerPlayScreen
	
	
	
	public PlayerHandler(float stateTime, String gameMode){
		
		this.gameMode = gameMode;
		
		player1 = new Player();		
		player1.setName("player1");
		player2 = new Player();
		player2.setName("player2");
		
		
		if (this.gameMode == "twoPlayer"){
			
			foe = new Foe();
			foe.setLifeStatus("dead");
			foe.setAttackReady(false);
			foe.setTimeToAttack(false);
		}
		
		if (this.gameMode == "onePlayer"){
			foe = new Foe();
			foe.setLifeStatus("alive");
			player2.setName("foe");
			//foe.setName("foe");
			
			//foe.setName("foe");
		}

		
		
		p1TimeHandler = new TimeHandler(stateTime);
		p2TimeHandler = new TimeHandler(stateTime);  //player 2 and foe will both use a handful of p2 variables
		p1TimeHandler.setName("p1Clock");
		p2TimeHandler.setName("p2Clock");
		p1TimeHandler.setTimerDuration(5);
		p2TimeHandler.setTimerDuration(5);
		player1.setLifeStatus("alive");
		player2.setLifeStatus("alive");
		
		
		
	}
	
	public PlayerHandler(float stateTime, Foe foe){
		
	}
	
	public void update(String gameState, float stateTime, WorldInput wInput){
		
		
		
		if (player1.getHP() <= 0){
			player1.setLifeStatus("dead");
		}			

		if(player2.getHP() <= 0){
			player2.setLifeStatus("dead");
		}
		
		if (player2.getLifeStatus() == "dead"){
			foe.setLifeStatus("dead");
		}
		
		if (player1.getLifeStatus() == "dead" && player2.getLifeStatus() == "dead"){
			player1.setVictoryStatus("draw");
			player2.setVictoryStatus("draw");
		}
		else if (player1.getLifeStatus() == "alive" && player2.getLifeStatus() == "dead"){
			player1.setVictoryStatus("winner");
			player2.setVictoryStatus("loser");
		}
		else if (player1.getLifeStatus() == "dead" && player2.getLifeStatus() == "alive"){
			player1.setVictoryStatus("loser");
			player2.setVictoryStatus("winner");
		}
		
		
		if (gameState == "playing"){
		
			p1TimeHandler.update(gameState, stateTime);
			p2TimeHandler.update(gameState, stateTime);		
			
			//System.out.println("gameMode= " + gameMode);
			if (gameMode == "twoPlayer"){
			
				if (player2.getLifeStatus() == "alive"  && player1.getLifeStatus() == "alive" && foe.getLifeStatus() == "dead"){
					//enemy touch input
				
				
					if (wInput.p2Button.isPressed() || Gdx.input.isKeyPressed(Keys.Z)){   		//if the touch is higher than the middle? then that means the enemy attacked
						 //p2Clock.setMomentInTime(p2Clock.getStateTime());  	//sets the starting point of the timer
						 //p2Clock.setTimerDuration(5);  						 	//sets the end point of the timer
						 //p2Clock.setTimePassed(0);
						 //sets the time that has passed to 0
						 
							//top doing damage to bottom
							//if (getClickPos().y > Gdx.graphics.getHeight()/2){
						switch(p2TimeHandler.getBarStatus()){
							case 0 : 
								player2.setStatus("taunting");
								//player2.setStatus("normal");
								p2TimeHandler.resetTimer();
								break;
							case 1: 
								player2.setElementStatus(p2TimeHandler.getBarStatus()); //turn red or blue or green
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(1);
								p2TimeHandler.resetTimer();
								break;
							case 2: 
								player2.setElementStatus(p2TimeHandler.getBarStatus());
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(2);
								p2TimeHandler.resetTimer();
								break;
							case 3: 
								player2.setElementStatus(p2TimeHandler.getBarStatus());
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(3);
								p2TimeHandler.resetTimer();
								break;
							case 4: 
								player2.setElementStatus(p2TimeHandler.getBarStatus());
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(4);
								p2TimeHandler.resetTimer();
								break;
							case 5: 
								player2.setElementStatus(p2TimeHandler.getBarStatus());
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(5);
								p2TimeHandler.resetTimer();
								break;
							case 6: 
								player2.setElementStatus(p2TimeHandler.getBarStatus());
								player2.setStatus("attacking");
								player2.attackTimer.setTimerDuration(1);
								player1.setStatus("damaged");
								player1.calculateDamage(6);
								p2TimeHandler.resetTimer();
								break;
							case 8:
								p2TimeHandler.resetTimer();
						}//end of switch ...player1 reactions						
			
					}//end of player2 input
			
				}//end of alive status checks 
				
			}//end of two player mode check
			
			
			if ( gameMode == "onePlayer"){
				
				
				//foe.update();
				foe.debug();
				
				if (foe.getLifeStatus() == "alive" && player1.getLifeStatus() == "alive"){
					
					
					if (foe.getAttackChoice() == "wait"){
						foe.update();
					}
					if (foe.getAttackChoice() == "miss"){//code to help skip the action content
						if (p2TimeHandler.getTimePassedPercent() < 99.5f){
							foe.update();
						}
						
					}
					else if (foe.getAttackChoice() == "hit" || foe.getAttackChoice() == "taunt"){
					
					
						if (foe.getAttackReady() == false){						
							foe.update();
							foe.setAttackReady(true);
						}
						
						p2TimeHandler.setBarStatus(foe.getAttackPoint());
						System.out.println(p2TimeHandler.getTimePassedPercent());
						if ((int)foe.getAttackPoint() == (int)p2TimeHandler.getTimePassedPercent()){
							foe.setTimeToAttack(true);
						}
						
						if (foe.getTimeToAttack() == true && foe.getAttackReady() == true){
							switch(p2TimeHandler.getBarStatus()){
								case 0 : 
									player2.setStatus("taunting");
									//player2.setStatus("normal");
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 1: 
									player2.setElementStatus(p2TimeHandler.getBarStatus()); //turn red or blue or green
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(1);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 2: 
									player2.setElementStatus(p2TimeHandler.getBarStatus());
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(2);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 3: 
									player2.setElementStatus(p2TimeHandler.getBarStatus());
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(3);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 4: 
									player2.setElementStatus(p2TimeHandler.getBarStatus());
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(4);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 5: 
									player2.setElementStatus(p2TimeHandler.getBarStatus());
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(5);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
								case 6: 
									player2.setElementStatus(p2TimeHandler.getBarStatus());
									player2.setStatus("attacking");
									player2.attackTimer.setTimerDuration(1);
									player1.setStatus("damaged");
									player1.calculateDamage(6);
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
									break;
									
								case 8:
									p2TimeHandler.resetTimer();
									foe.setAttackReady(false);
									foe.setTimeToAttack(false);
									foe.setAttackChoice("wait");
							}//end of switch					
						}//end of attack time check
					}//hit or taunt  check
				}//end of foe alive check
				
				
			} //end of one player mode check
			
			
			if (foe.getLifeStatus() == "alive" || player2.getLifeStatus() == "alive" && player1.getLifeStatus() == "alive" ){		
		
		//if (player1.getLifeStatus() == "alive"){
			//player1 touch input
				if (wInput.p1Button.isPressed()  || Gdx.input.isKeyPressed(Keys.M)){   		//if the touch is lower? than the middle? then that means the enemy attacked
					 //p1Clock.setMomentInTime(p2Clock.getStateTime());  	//sets the starting point of the timer
					 //p1Clock.setTimerDuration(5);  						 	//sets the end point of the timer
					 //p1Clock.setTimePassed(0);			 					//sets the time that has passed to 0
		
					 
						//bottom doing damage to top
						//if (getClickPos().y < Gdx.graphics.getHeight()/2){
					switch(p1TimeHandler.getBarStatus()){
						case 0 : 
							player1.setStatus("taunting");
							//player1.setStatus("normal");
							p1TimeHandler.resetTimer();
							break;
						case 1: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(1);	
							p1TimeHandler.resetTimer();
							break;
						case 2: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(2);
							p1TimeHandler.resetTimer();
							break;
						case 3: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(3);
							p1TimeHandler.resetTimer();
							break;
						case 4: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(4);
							p1TimeHandler.resetTimer();
							break;
						case 5: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(5);
							p1TimeHandler.resetTimer();
							break;
						case 6: 
							player1.setElementStatus(p1TimeHandler.getBarStatus());
							player1.setStatus("attacking");
							//player1.setStatus("normal");
							player2.setStatus("damaged");
							player2.calculateDamage(6);
							p1TimeHandler.resetTimer();
							break;
						case 8:
							p1TimeHandler.resetTimer();
					}//end of switch		
				}//end of player 1 input	
			} //end of if enemies are alive and player is alive?
		//}  //end of if players are alive
		
			if (p1TimeHandler.getBarStatus() == 8){
				p1TimeHandler.resetTimer();
			}
			if (p2TimeHandler.getBarStatus() == 8){
				p2TimeHandler.resetTimer();
			}
			
			
			
			player1.update(gameState);
			player2.update(gameState);
		
		}//end of if gameState == playing
		
		if (gameState == "over"){
			
		}
		
		if (gameState == "paused"){
			
		}
		
		if (gameState == "resuming"){
			
		}
		
	}//end of update method
	
	void setGameMode(String givenGameMode){
		gameMode = givenGameMode;
		
	}
	
	String getGameMode(){
		return gameMode;
	}
	
	

}

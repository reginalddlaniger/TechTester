package com.me.techTester;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;



public class Player {
	
	float HP, oldHP, newHP;
	float maxHP;
	float hpPercent;
	String name;
	String elementStatus;  //elementStatus can be "blue", "green", or "red".  
	String status;	//status can be "attackingW", "attackingF", attackingE", "normal", "taunting", healed, "damagedN", "damagedF", "damagedW", "damagedE".
	int  multiplier1, multiplier2;
	float multiplier, multiplier0;
	Vector2 tauntLoc;
	Random randomNumGen;
	float tauntX, p1TauntY, p2TauntY;
	TimeHandler attackTimer;
	String victoryStatus; //winner, loser, draw
	String lifeStatus;  // alive, or dead.


	public Player(){
		maxHP = 60;
		oldHP = maxHP;
		newHP = maxHP;
		HP = 60;
		multiplier = 1;
		multiplier0 = -1f;
		multiplier1 = 1;
		multiplier2 = 2;
		randomNumGen = new Random();
		tauntX = 0;
		setStatus("normal");
		attackTimer = new TimeHandler(TechTester.stateTime);
		attackTimer.setTimerDuration(0.75f);
		/*
		attackTimer  = new Clocker();
		attackTimer.setName("attackTimer");
		*/
		//setTimer();
	}
	
	void update(String gameState){
		
		//randomNumGen.setSeed(randomNumGen.nextInt(100)); //more randomerer  NOT
		tauntX = randomNumGen.nextInt((int)TechTester.w);
		p1TauntY = randomNumGen.nextInt((int)TechTester.h * 7/16) ; //on the bottom side
		p2TauntY = randomNumGen.nextInt((int)TechTester.h/2 - (int)TechTester.h/16) + TechTester.h/2; //on the top side
		
		attackTimer.update(gameState, TechTester.stateTime);
		attackTimer.setName("attackTimer");
		
		
		
		if (HP > maxHP){
			setHP(maxHP);
		}
		
		//takeDamage();	

		
		
		if (HP < 0){
			setHP(0);
		}
		
		if (getStatus() == "damaged" && oldHP > newHP){
			attackTimer.setTimePassed(0);
			HP--;
			oldHP = HP;
		}
		
		if (getStatus() == "healed"  && oldHP < newHP){
			HP++;
			oldHP = HP;
		}
		
		if (getStatus() == "taunting"){
			
		}
		/*
		if (getStatus() == "attacking" && attackTimer.getTimeLeft() == 0){
			setStatus("normal");
		}
		*/
		
		/*
		if (getStatus() != "attacking" && oldHP == newHP){
			
			setStatus("normal");
		}
		*/
		


		
		setHPPercent();
		
		debug();
	}
	
	
	
	

	
	public void calculateDamage(int damageToTake){
		/*
		switch (damageToTake){
		case 1:
		}
		*/
		
	/*
		if (status == "green"){
		HP -= damageToTake * multiplier1;
		}
		else if (status == "red"){
		HP -= damageToTake * multiplier1;
		}
		else if (status == "blue"){
		HP -= damageToTake * multiplier1;
		}*/
		oldHP = HP;
		setMultiplier(damageToTake);
		if (getMultiplier() < 0){
			setStatus("healed");
		}
		newHP = oldHP - (damageToTake * getMultiplier());
		if (newHP > maxHP){
			newHP = getMaxHP();
		}
		
		
		/*
		for (int i = 0; i <= oldHP - newHP; i++){
			HP--;
			setHPPercent();
		}
		*/
		
		System.out.println(getName() + "took " + damageToTake + " damage!");
		
	}
	
	public void loseHP(float playerHP){
		playerHP--;
	}

	
	float getHP(){
		return HP;
	}
	
	float getMaxHP(){
		return maxHP;
	}
	
	void setHP(float givenHP){
		HP = givenHP;
	}
	
	void setHPPercent(){
		hpPercent = (getHP()/getMaxHP() * 100);
	}
	
	float getHPPercent(){
		return hpPercent;
	}
	
	void setName(String newName){
		name = newName;
	}
	
	String getName(){
		return name;
	}
	
	void setElementStatus(int barStatus){
		if (barStatus == 1){
			elementStatus = "red";
		}
		if (barStatus == 2){
			elementStatus = "blue";
		}
		if (barStatus == 3){
			elementStatus = "green";
		}
		if (barStatus == 4){
			elementStatus = "red";
		}
		if (barStatus == 5){
			elementStatus = "blue";
		}
		if (barStatus == 6){
			elementStatus = "green";
		}
	}
	
	String getElementStatus(){
		return elementStatus;
	}
	/*
 		multiplier0 = -0.5f;
		multiplier1 = 1;
		multiplier2 = 2;
	*/
	
	void setStatus(String newStatus){
		status = newStatus;
	}
	
	String getStatus(){
		return status;
	}
	
	void setMultiplier(int damageToTake){
		if (damageToTake == 1){ //attack is red
			if (getElementStatus() == "blue"){
				multiplier = multiplier1;
			}
			else if (getElementStatus() == "red"){
				multiplier = multiplier0;
			}
			else if (getElementStatus() == "green"){
				multiplier = multiplier2;
			}
		}
		if (damageToTake == 2){ //attack is blue
			if (getElementStatus() == "red"){
				multiplier = multiplier2;
			}
			else if (getElementStatus() == "green"){
				multiplier = multiplier1;
			}
			else if (getElementStatus() == "blue"){
				multiplier = multiplier0;
			}
		}
		if (damageToTake == 3){	//attack is green
			if (getElementStatus() == "green"){
				multiplier = multiplier0;
			}
			else if (getElementStatus() == "blue"){
				multiplier = multiplier2;
			}		
			else if (getElementStatus() == "red"){
				multiplier = multiplier1;
			}
		}
		if (damageToTake == 4){ //attack is red
			if (getElementStatus() == "blue"){
				multiplier = multiplier1;
			}
			else if (getElementStatus() == "red"){
				multiplier = multiplier0;
			}
			else if (getElementStatus() == "green"){
				multiplier = multiplier2;
			}
		}
		if (damageToTake == 5){ //attack is blue
			if (getElementStatus() == "red"){
				multiplier = multiplier2;
			}
			else if (getElementStatus() == "green"){
				multiplier = multiplier1;
			}
			else if (getElementStatus() == "blue"){
				multiplier = multiplier0;
			}
		}
		if (damageToTake == 6){	//attack is green
			if (getElementStatus() == "green"){
				multiplier = multiplier0;
			}
			else if (getElementStatus() == "blue"){
				multiplier = multiplier2;
			}
			else if (getElementStatus() == "red"){
				multiplier = multiplier1;
			}
			
		}
	
	}
	
	float getMultiplier(){
		return multiplier;
	}
	
	void setP1TauntLoc(){
		tauntLoc = new Vector2(tauntX, p1TauntY);
	}
	
	void setP2TauntLoc(){
		tauntLoc = new Vector2(tauntX, p2TauntY);
	}
	
	Vector2 getP1TauntLoc(){
		return tauntLoc;
	}
	
	Vector2 getP2TauntLoc(){
		return tauntLoc;
	}
	
	//void setTimer(){
		//attackTimer.timer(1f);
	//}
	
	void debug(){

		System.out.println(getStatus());
		System.out.println("oldHP: "+ oldHP+" / " + "newHP: " + newHP);
		System.out.println(name + " HP is " + getHP() + "/" + getMaxHP());
		System.out.println((float)(getHP()/getMaxHP()));
		System.out.println("HP Percent is: " + getHPPercent());
	}
	
	void setVictoryStatus(String givenVictoryStatus){
		victoryStatus = givenVictoryStatus;
	}
	
	String getVictoryStatus(){
		return victoryStatus;
	}
	
	void setLifeStatus(String givenLifeStatus){
		lifeStatus = givenLifeStatus;
	}
	
	String getLifeStatus(){
		return lifeStatus;
	}
	

}

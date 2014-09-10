package com.me.techTester;

import java.util.Random;

public class Foe extends Player{
	
	Random generator;
	//float attackChoice;
	boolean attackChosen;
	
	boolean attackReady;					//means that all there's left to do is wait for time to attack
	boolean timeToAttack;					//means it's time to attack!
	
	Random rand;  									//random number generator
	Random seed;
	
	int attackOption;// = random (0-99)  		 //this determines if the enemy hits, misses, or taunts
	String attackChoice;							//this is the word hit//miss/taunt
	int attackArea; 								//this determines when the enemy attacks (where in the attack bar)


	
	int enemySelection;
	
	float attackPoint;							 // the enemy chooses when to attack

	int attackRange;		//each number in attack range represents a play style. 
	
	//String enemyName;
		
	/*0 = taunt or attack low
		1 = all low
		2 = all high
		3 = anywhere
		*/
	
	
	
	public Foe(){
		
		generator = new Random();
		//attackChoice = generator.nextDouble();
		enemySelection = generator.nextInt(4);
		HP = 60;
		
		switch (enemySelection){
			case 0:
				setName("Tot");
				break;
			case 1:
				setName("Shrimp"); //enemyName = "Shrimp";
				break;
			case 2: 
				setName("Heavy");// enemyName = "Heavy";
				break;
			case 3:
				setName("Vari"); //enemyName = "Vari";
				break;			
		}
		
		//attackChoice = "wait";
		setAttackReady(false);
		roll();
		
		
	}
	



	void update(){
		
		this.debug();
		int test = generator.nextInt(99);
		System.out.println(test);
		

		
		if (status == "alive" && getAttackReady() == false){ 		 
			//attackOption = (int)(100/7) +1;
			setAttackOption(55);
		}
		
		
		if (getName() == "Tot"){
			if (getAttackOption() > 0 && getAttackOption() <= 33){
				setAttackChoice("taunt");
			}
		
			if (getAttackOption() > 33 && getAttackOption() <= 66){
				setAttackChoice("miss");
				}
				
			if (getAttackOption() > 66 && getAttackOption() <= 99){
				setAttackChoice("hit");
			}
		}
		
		if (getName() == "Shrimp"){
			if (getAttackOption() > 0 && getAttackOption() <= 15){
				setAttackChoice("taunt");
			}
		
			if (getAttackOption() > 15 && getAttackOption() <= 30){
				setAttackChoice("miss");
				}
				
			if (getAttackOption() > 30 && getAttackOption() <= 99){
				setAttackChoice("hit");
			}
		}
		
		if (getName() == "Heavy"){
			if (getAttackOption() > 0 && getAttackOption() <= 3){
				setAttackChoice("taunt");
			}
		
			if (getAttackOption() > 3 && getAttackOption() <= 38){
				setAttackChoice("miss");
				}
				
			if (getAttackOption() > 38 && getAttackOption() <= 99){
				setAttackChoice("hit");
			}
		}
		
		
		if (getName() == "Vari"){
			if (getAttackOption() > 0 && getAttackOption() <= 9 ){
				setAttackChoice("taunt");
			}
		
			if (getAttackOption() > 9 && getAttackOption() <= 14){
				setAttackChoice("miss");
				}
				
			if (getAttackOption() > 14 && getAttackOption() <= 99){
				setAttackChoice("hit");
			}
		}
		
		if (getAttackChoice() == "taunt"){
			rollTaunt(); //This determines where in the taunt time frame will p2 taunt?
		}
		
		if (getAttackChoice() == "hit"){
			
			if (getName() == "Tot")
				rollHit(100/7, (100/7 * 2));
				
			else if (getName() == "Shrimp"){
				rollHit(100/7, (100/7 * 4) );
			}
			else if (getName() == "Heavy"){
				rollHit((100/7)* 4, 100);
			}
			else if (getName() == "Vari"){
				rollHit(100/7, 100);
			}
		}
		
		if (attackChoice == "miss"){
			//attackChoice = "wait";
			setAttackReady(false);
			setTimeToAttack(false);
		}
		
		/*
		if (player.barStatus == foe.attackPoint){
			setAttackReady(true);
			attackChoice = "wait";
			setAttackReady(false);
		}
		*/

	}


	void rollHit(float min, float max) {
		
		//min
		
		seed = new Random();
		rand = new Random(seed.nextInt((int)max));  // this is to help determine where 2p will aim on the former attack bar
		float tempInt = rand.nextInt((int)(max - min) + (int)min);
		//rand.next
		
		float tempFloat = rand.nextFloat();
		attackPoint = tempInt + tempFloat;
	
	}

	void rollTaunt() {
		
		seed = new Random();
		rand = new Random(seed.nextInt(100/7));  // this is to help determine where 2p will aim on the former attack bar
		int intBit = rand.nextInt(100/7);
		float floatBit = rand.nextFloat();
		attackPoint = intBit + floatBit;		
	
	}
	
	int roll(){
		Random newNum;
		newNum = new Random();
		int tempi;
		tempi = newNum.nextInt(100);
		return tempi;
	}

	void setAttackOption(int givenAttackOption){
		
		/*rand = new Random();
		System.out.println("rand =" + rand);
		*/
		this.attackOption = givenAttackOption;//rand.nextInt(99);//
	}

	int getAttackOption(){
		return attackOption;
	}
	
	void setAttackReady(boolean givenAttackStatus){
		attackReady = givenAttackStatus;
	}
	
	boolean getAttackReady(){
		return attackReady;
	}
	
	float getAttackPoint(){
		return attackPoint;
	}
	
	void setTimeToAttack(boolean givenBoolean){
		timeToAttack = givenBoolean;
	}
	
	boolean getTimeToAttack(){
		return timeToAttack;
	}
	
	void setAttackChoice(String givenAttackChoice){
		attackChoice = givenAttackChoice;
	}
	
	String getAttackChoice(){
		return attackChoice;
	}
	
	void debug(){
		System.out.println("Name is " + getName());
		System.out.println("Life status is " + getLifeStatus());
		System.out.println("Attack Option is: " + getAttackOption());
		System.out.println("AttackChoice is " + getAttackChoice());
		System.out.println("Attack Point is " + getAttackPoint());
		System.out.println("Attack Ready Status is" + getAttackReady());
		System.out.println("Time to Attack is " + getTimeToAttack());
	}

	

}

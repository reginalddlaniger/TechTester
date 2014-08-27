package com.me.techTester;

import java.util.Random;

public class Foe extends Player{
	
	Random generator;
	double attackChoice;
	
	
	
	public Foe(){
		
		generator = new Random(4);
		attackChoice = generator.nextDouble();
		
	}
	
	void update(){
		
		
		if (status == "alive"){
			
		}		
		
	}
	
	void setNewAttackChoice(){
		attackChoice = generator.nextDouble();
	}
	
	
	
	

}

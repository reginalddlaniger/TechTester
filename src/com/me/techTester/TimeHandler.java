package com.me.techTester;

import com.badlogic.gdx.Gdx;


public class TimeHandler {
	
	float timer1, timer2, timer3, timer4, timer5;
	float delay1, delay2, delay3, delay4;
	float stateTime;
	float timeLeft;
	float timerDuration; 
	float timePassed;
	float currentMomentInTime, frozenMomentInTime;
	float timePassedPercent;
	float timeLeftPercent;
	float startTime;
	float endTime;
	float timePauseCaptured;  //this value is the amount of time that has elapsed so far.  It will be added to a new start time upon resuming play
	boolean playerInput, enemyInput;
	int barStatus;
	String name;
	boolean pauseTimeStatus;  //pauseTime is a question.  true or false.  It's a status to be set.
	

	
	
	public TimeHandler(float mainGameClock){
		setStartTime();
		timer1 = 0;
		timer2 = 0;
		timer3 = 5;
		timer4 = 0;
		delay1 = 1;
		delay2 = 2;
		delay3 = 3;
		delay4 = 13;
		timeLeft = 0;
		timerDuration = 5;
		timer5 = 0;
		timePassed = 0;
		timePassedPercent = 0;
		timeLeftPercent = 100;
		setCurrentMomentInTime(mainGameClock);
		startTime = getStartTime();	
		
		barStatus = 0;
		pauseTimeStatus = false;
		
	}
	
	public void update(String mainGameState, float mainGameClock){
		
		//setStateTime();
		
		
		//timer1 = getStateTime() - delay1;
		
		//timer2 = getStateTime() - delay2;
		

		
		//setMomentInTime(getStateTime());
		
		//TIMER3 NEEDS TO COUNT DOWN FROM 5 (to 0) when the clock reaches 13 seconds
		//timer4 counts down from 5 at 13 s
		/*
		if(timer3 > 0f){
			if (getStateTime() >= 13f){
				timer3 -= (getStateTime() - 13f);
			}		
		}		
		
		if (getStateTime() >= 13  && timer4 <= 5f){
			timer4 += getStateTime() - delay4;
		}
		
		
		System.out.println("StateTime: " + stateTime);
		System.out.println("\n timer1: " + timer1);
		System.out.println("       timer2: " + timer2);
		System.out.println("              timer3: " + timer3);
		System.out.println("                     timer4: " + timer4);
		
		if (timer3 > 0){
			timer3 = 5;
		}
		if (timer4 < 5){
			timer4 = 0;
		}
		*/
		
		/*
		// timer restarting in relation to input
		barStatus = getBarStatus();

		if (getPlayerInput() == true && Gdx.input.getY() > Gdx.graphics.getHeight()/2){
		//if (getPlayerInput() == true){
			 setMomentInTime(getStateTime());
			 setTimerDuration(5);
			 
			 setTimePassed(0);
		}
		
		
		barStatus = getBarStatus();
		
		if (getPlayerInput() == true && Gdx.input.getY() < Gdx.graphics.getHeight()/2){
		//if (Gdx.input.isKeyPressed(Keys.SPACE)){
			 //setMomentInTime(getStateTime());
			 //setTimerDuration(5);
			 
			 //setTimePassed(0);
			 //timer(1);
			
		}
		*/
		

		
		//setTimePassed(0);
		
		//timer(99);
		if (mainGameState == "playing"){
			setStateTime(mainGameClock);
			endTime = getEndTime();
			setCurrentMomentInTime(getStateTime());
			setTimePassed();
			
			setTimePassedPercent();
			
			setTimeLeft();
			setTimeLeftPercent();
			setBarStatus();
		}
		else{
			
		}
		

		/*
		
		if time oges beyond the duration, the time should stop, right?
				
				
				for the players, if the time goes on the duration, the time can stop or go, it doesn't matter.  Theplayer's click needs to reset the clock though.
				
				the game's main clock needs to stop the players from playing
				*/
		
		
		debug(mainGameState);
		
	}
	
	//end of update method
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//time parameters - minimums maximums
	public void timer(float timeInSeconds){ //current
		setTimerDuration(timeInSeconds);
	}	//currently useless
	
	
	public void setStateTime(float mainGameClock){
		stateTime = mainGameClock;
	}
	
	public float getStateTime(){
		return stateTime;
	}	

	
	void setTimerDuration(float amountOfTime){
		timerDuration =  amountOfTime;
	}
	
	float getTimerDuration(){
		return timerDuration;
	}
		
	//end of time parameters
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//points in time	
	
	void setStartTime(){
		this.startTime = stateTime;
	}
	
	float getStartTime(){
		return this.startTime;
	}		
	
	void setEndTime(){
		endTime = getStartTime() + getTimerDuration();
	}
	
	float getEndTime(){
		return endTime;
	}	
	
	void setFrozenMomentInTime(){
		frozenMomentInTime = stateTime;
	}
	
	float getFrozenMomentInTime(){
		return frozenMomentInTime;
	}
	
	void setCurrentMomentInTime(float moment){ //moment should be the current delta time...why does this exist when there's get stateTime?  readability
		currentMomentInTime = moment;
	}
	
	float getCurrentMomentInTime(){
		return currentMomentInTime;
	}

	//end of moments in time
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	//time stats (seconds)	
	
	void setTimeLeft(){
		this.timeLeft = getEndTime() - getCurrentMomentInTime();
	}
	
	float getTimeLeft(){
		return timeLeft;
	}
	
	void setTimePassed(){
		timePassed = getCurrentMomentInTime() - getStartTime(); //difference is the amount of time that has passed
	}
	
	void setTimePassed(float givenAmountOfTimePassed){
		timePassed = givenAmountOfTimePassed;
	}
	
	float getTimePassed(){
		return timePassed;
	}
	
	//end of stats (seconds)
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//time stats (percentages)
	
	void setTimeLeftPercent(){
		timeLeftPercent = (getTimeLeft()/getTimerDuration() * 100);  //percentage of time left
	}
	
	float getTimeLeftPercent(){
		return timeLeftPercent;
	}	
	
	void setTimePassedPercent(){
		timePassedPercent = (getTimePassed() / getTimerDuration() * 100);
	}
	
	float getTimePassedPercent(){
		return timePassedPercent;
	}	
	
	//end of time stats ( percentages)
	
	
	
	void resetTimer(){
		setStartTime();
		setEndTime();
		setTimePassed(0);
		setTimeLeft();
		setTimePassedPercent();
		setTimeLeftPercent();
		
	}
	
	
	float getTimerHighVal(){  //this set the high end of the timer... unnecessarily...
		return timerDuration;
	}

	void timerPause(){ // this will capture how much time has passed
		timePauseCaptured = getTimePassed();

	}
	
	void timerResume(){//  this will give the timer a new start time(now) but it add the amount of time that has passed already.  This is mostly planned for the game timer.
		setStartTime();
		startTime += timePauseCaptured;
		//the duration is still the same;
		
	}
	
	void setPlayerInput(boolean keystroke){
		playerInput = keystroke;
	}
	
	boolean getPlayerInput(){
		return playerInput;
	}
	
	void setName(String newName){
		name = newName;
	}
	
	String getName(){
		return name;
	}
	
	
	int getBarStatus(){
		return barStatus;
	}
	
	
	void  setBarStatus(){
		if (getTimePassedPercent() > 0  && getTimePassedPercent() < 7){
			barStatus = 7;		
		}
		else if(getTimePassedPercent() > 7 && getTimePassedPercent() <= 100/7){
			barStatus = 0;
		}
		else if(getTimePassedPercent() > 100/7 && getTimePassedPercent() <= ((100/7) * 2)){
			barStatus =  1;
		}
		else if(getTimePassedPercent() > (100/7) * 2 && getTimePassedPercent() <= ((100/7) * 3)){
			barStatus = 2;
		}
		else if(getTimePassedPercent() > (100/7) * 3 && getTimePassedPercent() <= ((100/7) * 4)){
			barStatus = 3;
		}
		else if(getTimePassedPercent() > (100/7) * 4 && getTimePassedPercent() <= ((100/7) * 5)){
			barStatus = 4;
		}
		else if(getTimePassedPercent() > (100/7) * 5 && getTimePassedPercent() <= ((100/7) * 6)){
			barStatus = 5;
		}
		else if (getTimePassedPercent() > (100/7) * 6 && getTimePassedPercent() <= 100){
			barStatus = 6;
		}
		else if (getTimePassedPercent() > 100){
			barStatus = 8;
		}

	}
	

	
	void debug(String gamestate){
		
		System.out.println("                                             gameState: "+ gamestate);
		System.out.println("\n\n                                           startPoint: " + getStartTime());
		System.out.println("                                               endpoint :" + getEndTime())	;					
		

		System.out.println("                                            " + name);
		System.out.println("                                             Time Passed: " + getTimePassed());  //time passed is the deltaTime - the time the mouse was clicked
		System.out.println("                                             time left: " + getTimeLeft());  // Time left is how much time until the counter reaches 0
		System.out.println("                                             Time Passed %: " + timePassedPercent);
		System.out.println("                                             Time Left %: " + timeLeftPercent);
		
		
	}
	
	void setPauseTimeStatus(boolean trueOrFalse){
		pauseTimeStatus = trueOrFalse;
	}
	
	boolean getPauseTimeStatus(){
		return pauseTimeStatus;
	}
	

	


}

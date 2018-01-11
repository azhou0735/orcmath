package testClickerV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Task;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

public class Game extends Screen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4674434282829202704L;
	
	private TimerDisplay timerDisplay;
	private Score scoreDisplay;
	private Clicker clickerButton;
	
	private int gracePeriod = 3;
	private int clickPeriod = 5;
	private int score = 0;
	private boolean clicky = false;
	private boolean waity = false;
	
	public Game(int width, int height) {
		super(width, height);
	}

	public Game(int width, int height, ArrayList<Visible> initWithObjects) {
		super(width, height, initWithObjects);
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		timerDisplay = new TimerDisplay(275,275,100,50);
		scoreDisplay = new Score(275,375,100,50);
		viewObjects.add(timerDisplay);
		viewObjects.add(scoreDisplay);
		
		clickerButton = new Clicker(275,450,200,200,"Start Game",null,null);
		clickerButton.setString("Start Game");
		clickerButton.setAction(new Action() {
			
			@Override
			public void act() {
				if(!clicky && !waity) {
					clickerButton.setString("Wait");
					waity = true;
					Timer time;
					time = new Timer();
					time.scheduleAtFixedRate(new TimerTask() {
						
						public void run() {
							timerDisplay.setTime(gracePeriod);
							gracePeriod--;
							if(gracePeriod == 0) {
								time.cancel();
								clickerButton.setString("CLICK");
								clicky = true; waity = false;
								clickerButton.setAction(new Action() {
									
									@Override
									public void act() {
										score++;
										scoreDisplay.setScore(score);
									}
								});
							}
						}
					}, 1000, 1000);
				}
			}
		});
		if(clicky) {
			Timer time2;
			time2 = new Timer();
			time2.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					timerDisplay.setTime(clickPeriod);
					clickPeriod--;
					if(clickPeriod == 0) {
						time2.cancel();
						clickerButton.setString("Game Over");
						clicky = false; waity = false;
						clickerButton.setAction(new Action() {
							@Override
							public void act() {
								
							}
						});
					}
				}
			}, 1000, 1000);
		}
		viewObjects.add(clickerButton);
	}

}

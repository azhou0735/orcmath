package myTest;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MyScreen extends ClickableScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129263073522539381L;

	private Timer time;
	private int timeCount;
	
	private MyButton clicker;
	private MyLabel countdown;
	private MyLabel scoreboard;
	private int clickCount;
	
	public MyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		countdown = new MyLabel(250,100,100,100,"");
		scoreboard = new MyLabel(250,150,100,100,"Score: 0");
		clicker = new MyButton(250, 250, 100, 100, "Click to Start", new Action() {
			public void act() {
				time = new Timer();
				timeCount = 3;
				time.scheduleAtFixedRate(new TimerTask() {
					public void run() {
						countdown.setString("Ready in "+timeCount);
						clicker.setAction(null);
						if(timeCount == 0) {
							clicker.setString("CLICK");
							clicker.setAction(new Action() {
								public void act() {
									clickCount++;
									scoreboard.setString("Score: "+clickCount);
								}
							});
							time.cancel();
							time = new Timer();
							timeCount = 5;
							time.scheduleAtFixedRate(new TimerTask() {
								public void run() {
									countdown.setString("You have "+timeCount+"s left");
									if(timeCount == 0) {
										time.cancel();
										clicker.setAction(null);
									}
									timeCount--;
								}
							}, 0, 1000);
							
						}
							
							
							
						timeCount--;
					}
				}, 0, 1000);
				
			}
		});
		viewObjects.add(countdown);
		viewObjects.add(scoreboard);
		viewObjects.add(clicker);
	}



}

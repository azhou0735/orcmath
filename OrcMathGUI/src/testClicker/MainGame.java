package testClicker;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

public class MainGame extends Screen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4578931866448339489L;
	
	private Header a;
	private ClickyButton b;
	private ScoreKeep c;
	
	private int score;
	private boolean gameStart;
	private boolean acceptClicks;
	private int waityTime;
	private int clickyTime;
	
	public MainGame(int width, int height) {
		super(width, height);
		gameStart = false;
		acceptClicks = true;
		waityTime = 3;
		clickyTime = 5;
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		a = new Header(350,300,150,100);
		c = new ScoreKeep(350,100,600,200,"");
		viewObjects.add(a);
		viewObjects.add(c);
		/*b = new ClickyButton(100, 300, 50, 50, "Start Game", Color.BLUE, new Action() {
			public void act() {
				if(!gameStart && acceptClicks){
					gameStart = true;
					acceptClicks = false;
					b.setStatus(1);
					Thread timer = new Thread(new Runnable() {
						public void run() {
							for(int i = 3; i > 0; i--) {
								a.setCurrentTime(i);
								try {
									Thread.sleep(1000);
									break;
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					});
					acceptClicks = true;
					b.setStatus(2);
				}
			}
		});*/
		/*b = new ClickyButton(100, 300, 50, 50, "Start Game", Color.BLUE, new Action() {
			
			@Override
			public void act() {
				if(!gameStart && acceptClicks) {
					gameStart = true;
					acceptClicks = false;
					b.setStatus(1);
					Thread timer = new Thread(new Runnable() {
						public void run() {
							for(int i = 3; i > 0; i--) {
								a.setCurrentTime(i);
								try {
									Thread.sleep(1000);
									break;
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					});
					timer.run();
					acceptClicks = true;
					b.setStatus(2);
				}
				
				
				Thread timer2 = new Thread(new Runnable() {
					public void run() {
						for(int i = 5; i > 0; i--) {
							a.setCurrentTime(i);
							try {
								Thread.sleep(1000);
								break;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						b.setStatus(2);
						acceptClicks = false;
						gameStart = false;
					}
				});
				if(gameStart && acceptClicks) {
					score++;
					c.setScore(score);
					c.update();
				}
			}
		});*/
		/*Timer timer;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int tempTime = 3;
			@Override
			public void run() {
				a.setCurrentTime(tempTime--);
			}
		}, 50000, 1000);*/
		b = new ClickyButton(50,450,400,300, "", null, null);
		b.setStatus(0);
		Timer timer1;
		timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				b.setStatus(1);
				a.setCurrentTime(waityTime);
				if(waityTime <= -1) {
					b.setStatus(2);
					timer1.cancel();
					
					Timer timer;
					timer = new Timer();
				    timer.scheduleAtFixedRate(new TimerTask() {

				        public void run() {
				           a.setCurrentTime(clickyTime);
				           if(clickyTime <= 0) {
				        	   timer.cancel();
				        	   b.setStatus(3);
				        	   b.setAction( new Action() {
								
								@Override
								public void act() {
								}
								
				        	   });
				           }
				           clickyTime--;
				        }
				    }, 0, 1000);
				    
					b.setAction(new Action() {
						
						@Override
						public void act() {
						
							score++;
							c.setScore(score);
							
						}
						
					});
				}
			waityTime --;
			}
		}, 1000, 1000);
		
		viewObjects.add(b);
	}
	
	public void checkStatus() {
		if(gameStart && acceptClicks) {
			
		}else if(gameStart && !acceptClicks) {
		}
	}

}

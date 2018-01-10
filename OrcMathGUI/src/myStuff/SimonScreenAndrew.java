package myStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAndrew extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3873286427185069277L;
	
	private ProgressInterfaceAndrew progress;
	private ArrayList<MoveInterfaceAndrew> moves;
	private TextLabel label;
	private ButtonInterfaceAndrew[] buttons;
	
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	
	public SimonScreenAndrew(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		//
		Thread screen = new Thread(this);
		screen.start();
	}

	@Override
	public void run() {
		System.out.println("1");
		label.setText("");
		nextRound();

	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber ++;
		moves.add(randomMove());
		
		progress.setRound(roundNumber);
		progress.setSequenceSize(moves.size());
		
		changeText("Simon's turn");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	public void changeText(String a) {
		Thread displayLabel = new Thread(new Runnable() {
			public void run() {
				label.setText(a);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText("");
			}
		});
		displayLabel.run();
	}
	
	
	public void playSequence() {
		System.out.println("3");
		ButtonInterfaceAndrew b = null;
		for(MoveInterfaceAndrew a:moves) {
			if(b!=null) {
				b.dim();
				b = a.getButton();
				b.highlight();
				
				int sleepTime = (2000/roundNumber);
				Thread c = new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				});
				c.run();
				b.dim();
			}
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		System.out.println("2");
		buttons = new ButtonInterfaceAndrew[7];
		addButtons();
		for(ButtonInterfaceAndrew b: buttons){ 
		    viewObjects.add(b); 
		}
		
		label = new TextLabel(100,230,80,50,"Let's play Simon!");
		viewObjects.add(label);
		//add 2 moves to start
		

		progress = new ProgressAndrew(20, 20, 80, 50);
		
		lastSelectedButton = -1;
		moves = new ArrayList<MoveInterfaceAndrew>();
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		
		viewObjects.add(progress);
	}

	public MoveInterfaceAndrew randomMove() {
		int a = lastSelectedButton;
		while(a == lastSelectedButton) {
			a = (int)(Math.random()*buttons.length);
		}
		return getMove(a);
	}
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	public MoveInterfaceAndrew getMove(int bIndex) {
		return new MoveAndrew(buttons[bIndex]);
	}

	public void addButtons() {
		System.out.println("4");
		int numberOfButtons = 7;
		Color[] colors = new Color[numberOfButtons];
		colors[0] = new Color(0,0,205); colors[1] = new Color(0,205,0); colors[2] = new Color(205,0,0); colors[3] = new Color(205,205,0);
		colors[4] = new Color(0,205,205); colors[5] = new Color(205,0,205); colors[6] = new Color(100,100,100);
		
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceAndrew b = new ButtonAndrew(i*150+50, 400, 50, 50, null);
			//System.out.println(colors[i]);
			b.setColor(colors[i]);
			//center of circle is 200,200
			//b.setX(200 + setXAroundCircle(i, numberOfButtons, 50));
			//b.setY(200 + setYAroundCircle(i, numberOfButtons, 50));
			b.setX(i*50+50);
			b.setY(150);
			b.setAction(new Action() {
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread( new Runnable() {
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						
						if(b == moves.get(sequenceIndex).getButton()) {
							sequenceIndex ++;
						}else {
							progress.gameOver();
						}
						if(sequenceIndex == moves.size()) {
							Thread nextRound = new Thread(SimonScreenAndrew.this);
							nextRound.start();
							
						}
					}
				}
			});
			System.out.println("Button");
			buttons[i] = b;
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	public ButtonInterfaceAndrew getAButton() {
		return new ButtonAndrew(0, 0, 50, 50, null);
	}

	public static int setXAroundCircle(int i, int n, int radius) {
		return (int)(Math.cos(((Math.PI*2)/n)*i)*radius);
	}
	public static int setYAroundCircle(int i, int n, int radius) {
		return (int)(Math.sin(((Math.PI*2)/n)*i)*radius);
	}
}
//System.out.println("");
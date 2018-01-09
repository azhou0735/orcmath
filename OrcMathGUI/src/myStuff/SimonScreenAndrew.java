package myStuff;

import java.awt.Color;
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
		label.setText("");
		nextRound();

	}

	private void nextRound() {
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
			}
		}
		b.dim();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceAndrew b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceAndrew>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceAndrew randomMove() {
		int a = lastSelectedButton;
		while(a == lastSelectedButton) {
			a = (int)(Math.random()*buttons.length);
		}
		return getMove(a);
	}
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceAndrew getMove(int bIndex) {
		return new MoveAndrew(buttons[bIndex]);
	}

	private ProgressInterfaceAndrew getProgress() {
		// TODO Auto-generated method stub
		return new ProgressAndrew(200,200,400,400);
	}

	private void addButtons() {
		int numberOfButtons = 7;
		buttons = new ButtonInterfaceAndrew[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		colors[0] = Color.BLUE; colors[1] = Color.RED; colors[2] = Color.GREEN; colors[3] = Color.CYAN;
		colors[4] = Color.YELLOW; colors[5] = Color.ORANGE; colors[6] = Color.MAGENTA;
		
		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceAndrew b = getAButton();
			b.setColor(colors[i]);
			//center of circle is 200,200
			b.setX(200 + setXAroundCircle(i, numberOfButtons, 50));
			b.setY(200 + setYAroundCircle(i, numberOfButtons, 50));
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
			buttons[i] = b;
		}
	}
	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	private ButtonInterfaceAndrew getAButton() {
		
		return new SunnyButton(0, 0, 50, 50, "",  null);
	}

	public static int setXAroundCircle(int i, int n, int radius) {
		return (int)(Math.cos(((Math.PI*2)/n)*i)*radius);
	}
	public static int setYAroundCircle(int i, int n, int radius) {
		return (int)(Math.sin(((Math.PI*2)/n)*i)*radius);
	}
}

package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenAndrew extends ClickableScreen implements Runnable {

	private ProgressInterfaceAndrew progress;
	private ArrayList<MoveInterfaceAndrew> movesMade;
	private TextLabel currentRound;
	private ButtonInterfaceAndrew[] buttons;
	
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	
	public SimonScreenAndrew(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceAndrew b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		currentRound = new TextLabel(130,230,300,40,"Let's play Simon!");
		movesMade = new ArrayList<MoveInterfaceAndrew>();
		//add 2 moves to start
		lastSelectedButton = -1;
		movesMade.add(randomMove());
		movesMade.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(currentRound);
	}

	private MoveInterfaceAndrew randomMove() {
		int a = lastSelectedButton;
		while(a == lastSelectedButton) {
			a = (int)(Math.random()*buttons.length);
		}
		return getMove(a);
	}

	private MoveInterfaceAndrew getMove(int bIndex) {
		return null;
	}

	private ProgressInterfaceAndrew getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 7;
		buttons = new ButtonInterfaceAndrew[numberOfButtons];
		Color[] color = new Color[numberOfButtons];
		Color[0] = ; Color[1] = ; Color[2] = ; Color[3] = ;
		Color[4] = ; Color[5] = ; Color[6] = ;
	}

}

package myStuff;

public class MoveAndrew implements MoveInterfaceAndrew {

	ButtonInterfaceAndrew b;
	
	public MoveAndrew(ButtonInterfaceAndrew buttons) {
		// TODO Auto-generated constructor stub
		this.b = buttons;
	}

	@Override
	public ButtonInterfaceAndrew getButton() {
		// TODO Auto-generated method stub
		return b;
	}

}

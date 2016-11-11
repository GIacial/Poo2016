package Item;

public class Item_Cat extends Furniture {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8316267118312352205L;

	public Item_Cat() {
		super("chat");
	}

	@Override
	public void description() {
		System.out.println("Un chat classique rien de plus");
	}

}

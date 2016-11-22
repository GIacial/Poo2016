package Item;

/**
 * Glove Item
 */
public abstract class Glove extends Equipment {

	private static final long serialVersionUID = 2408583540157623374L;

	
	
	
	
	public Glove(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}
	
	@Override
	public String getTypeName() {
		return "Glove";
	}
}

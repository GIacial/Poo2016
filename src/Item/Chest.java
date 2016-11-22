package Item;

/**
 * Chest Item
 */
public abstract class Chest extends Equipment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2228333889075861051L;

	public Chest(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getTypeName() {
		return "Chest";
	}
}

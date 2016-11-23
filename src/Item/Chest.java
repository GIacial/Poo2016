package Item;

/**
 * Chest Item
 */
public abstract class Chest extends Equipment {
	
	private static final long serialVersionUID = 2228333889075861051L;

	
	
	
	/**
	 * un constructeur de Chest
	 * @param name Le nom du plastron
	 * @param defB la defense donné par le plastron
	 * @param atkB l'attaque donné par le plastron
	 * @param healB la vie donné par le plastron
	 */
	public Chest(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}
	
	@Override
	public String getTypeName() {
		return "Chest";
	}
}

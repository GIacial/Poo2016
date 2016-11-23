package Item;

/**
 * Glove Item
 */
public abstract class Glove extends Equipment {

	private static final long serialVersionUID = 2408583540157623374L;

	
	
	
	/**
	 * Un constructeur de Glove
	 * @param name Le nom des Gants
	 * @param defB La defense donné par les gants
	 * @param atkB L'attaque donné par les gants
	 * @param healB La vie donné par les gants
	 */
	public Glove(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}
	
	@Override
	public String getTypeName() {
		return "Glove";
	}
}

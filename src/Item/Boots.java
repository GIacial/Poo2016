package Item;

/**
 * Boots Item
 */
public abstract class Boots extends Equipment {

	private static final long serialVersionUID = 5029743424495014594L;

	
	
	/**
	 * Un constructeur de Boots
	 * @param name Le nom des bottes
	 * @param defB la defense donné par les bottes
	 * @param atkB l'attaque donné par les bottes
	 * @param healB la vie donné par les bottes
	 */
	public Boots(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}

	@Override
	public String getTypeName() {
		return "Boots";
	}
	
	
}

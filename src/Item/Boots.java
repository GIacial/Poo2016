package Item;

/**
 * Boots Item
 */
public abstract class Boots extends Equipement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5029743424495014594L;

	public Boots(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeName() {
		return "Boots";
	}
	
	
}

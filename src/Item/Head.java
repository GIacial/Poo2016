package Item;

/**
 * Header Item
 */
public abstract class Head extends Equipment {

	private static final long serialVersionUID = -6934007849328860492L;
	public static final String TypeName = "head";

	
	
	
	/**
	 * Un constructeur de Head
	 * @param name Le nom du casque
	 * @param defB La defense donn� par le casque
	 * @param atkB L'attaque donn� par le casque
	 * @param healB La vie donn� par le casque
	 */
	public Head(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}
	
	@Override
	public String getTypeName() {
		return Head.TypeName;
	}
}

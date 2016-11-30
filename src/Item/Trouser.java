package Item;

/**
 * Trouser Item
 */
public abstract class Trouser extends Equipment {

	private static final long serialVersionUID = -8431178796822971257L;
	public static final String TypeName = "trouser";

	
	
	
	/**
	 * Un constructeur de Trouser
	 * @param name le nom du pantalon
	 * @param defB
	 * @param atkB
	 * @param healB
	 */
	public Trouser(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
	}
	
	@Override
	public String getTypeName() {
		return Trouser.TypeName;
	}
}

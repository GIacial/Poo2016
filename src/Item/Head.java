package Item;

/**
 * Header Item
 */
public abstract class Head extends Equipment {

	private static final long serialVersionUID = -6934007849328860492L;

	public Head(String name, int defB, int atkB, int healB) {
		super(name, defB, atkB, healB);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getTypeName() {
		return "Head";
	}
}

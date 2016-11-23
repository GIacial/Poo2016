package npc;

/**
 * Un Npc qui ne peut pas prendre de dégats
 *
 */
public abstract class ImmortalNPC extends Npc {


	private static final long serialVersionUID = 6332162407642388476L;
	

	/**
	 * Un constructeur de la clase
	 * @param name Le nom du npc
	 * @param maxHeal La vie du npc
	 * @param attack L'attaque du npc
	 * @param defense la defense du npc
	 */
	public ImmortalNPC(String name, int maxHeal, int attack, int defense) {
		super(name, maxHeal, attack, defense);
	}

	@Override
	public void takeDmg(int Dmg) {
		System.out.println(this.getName() + " est immortel");
	}

}

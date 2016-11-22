package npc;


public abstract class ImmortalNPC extends Npc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332162407642388476L;
	

	public ImmortalNPC(String name, int maxHeal, int attack, int defense) {
		super(name, maxHeal, attack, defense);
	}

	@Override
	public void takeDmg(int Dmg) {
		System.out.println(this.getName() + " est immortel");
	}

}

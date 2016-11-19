package Game;

import interfacePackage.HaveDescription;

public enum Command implements HaveDescription{
	go,help,look,take,quit,use,attack,discard,analyse,equip,unequip;

	@Override
	public void description() {
		switch(this){
		case go:System.out.println("[Help]: go exit");
				System.out.println("[Help]: Permet d'essayer de franchir la sortie");
			break;
		case help:System.out.println("[Help]: help [command]");
				System.out.println("[Help]: Affiche de un texte d'aide");
			break;
		case look:System.out.println("[Help]: look [target]");
				  System.out.println("[Help]: permet de regarder quelquechose");
			break;
		case take:System.out.println("[Help]: take target");
				  System.out.println("[Help]: permet de rammaser quelquechose");
			break;
		case quit:System.out.println("[Help]: quit");
				  System.out.println("[Help]: permet de quitter le jeu");
			break;
		case use:System.out.println("[Help]: use object [target]");
				 System.out.println("[Help]: utilise un objet");
			break;
		case attack:System.out.println("[Help]: attack entity");
					System.out.println("[Help]: attaque la cible");
			break;
		case discard:System.out.println("[Help]: discard object");
					System.out.println("[Help]: permet de jeter un object ");
			break;
		case analyse:System.out.println("[Help]: analyse entity ");
					 System.out.println("[Help]: permet d'afficher l'etat de l'entité");
			break;
		case equip:System.out.println("[Help]: equip equipement");
				   System.out.println("[Help]: equipe l'equipement");
			break;
		case unequip:System.out.println("[Help]: unequip zoneEquipement");
					 System.out.println("[Help]: desequipe l'equipement");
			break;
			default:System.err.println("[Help]:Command non trouvé ");
				break;
		}
		
	}
	
	public static void description(String command){
		// [Prof]:String moche
		try{
			Command c=Command.valueOf(command);
			c.description();
		}
		catch(Exception e){
			System.out.println(command+" n'est pas une commande");
		}
	}
}

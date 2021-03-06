package Game;

import interfacePackage.HaveDescription;

public enum Command implements HaveDescription{
	
	go,help,look,take,quit,use,attack,discard,analyse,equip,unequip,speak,last;

	

	@Override
	public void description() {
		switch(this){
		case go : 	System.out.println("[Help]: go exit");
					System.out.println("[Help]: Permet d'essayer de franchir la sortie");
			break;
		case help : System.out.println("[Help]: help [command]");
					System.out.println("[Help]: affichage d'un texte d'aide");
			break;
		case look : System.out.println("[Help]: look [target]");
				  	System.out.println("[Help]: permet de regarder quelquechose");
				  	System.out.println("[Help]: exit pour regarder toutes les sorties");
					System.out.println("[Help]: object pour tous les item");
					System.out.println("[Help]: entity pour tous ce qui est en vie");
					System.out.println("[Help]: me pour voir votre description");
					System.out.println("[Help]: equipement pour voir les equipements dans votre inventaire");
					System.out.println("[Help]: set pour les equipements equip�s");
					System.out.println("[Help]: inventory pour votre inventaire");
			break;
		case take : System.out.println("[Help]: take target");
				  	System.out.println("[Help]: permet de ramasser quelquechose");
			break;
		case quit : System.out.println("[Help]: quit");
				  	System.out.println("[Help]: permet de quitter le jeu");
			break;
		case use : 	System.out.println("[Help]: use object [target]");
				 	System.out.println("[Help]: utilise un objet");
				 	System.out.println("[Help]: me pour vous cibler vous m�me");
			break;
		case attack : 	System.out.println("[Help]: attack entity");
						System.out.println("[Help]: attaque la cible");
			break;
		case discard : 	System.out.println("[Help]: discard object");
						System.out.println("[Help]: permet de jeter un object ");
			break;
		case analyse : 	System.out.println("[Help]: analyse target ");
					 	System.out.println("[Help]: permet d'afficher les statistiques de la cible");
					 	System.out.println("[Help]: me permet de voir vos statistiques");
			break;
		case equip : 	System.out.println("[Help]: equip equipement");
				   		System.out.println("[Help]: equipe l'equipement");
			break;
		case unequip : 	System.out.println("[Help]: unequip zoneEquipement");
					 	System.out.println("[Help]: desequipe l'equipement");
					 	System.out.println("[Help]: les zones sont Weapon Trouser Glove Boots Chest Head");
			break;
		case speak : 	System.out.println("[Help]: speak target");
		 			 	System.out.println("[Help]: parle au NPC");
		 	break;
		case last : 	System.out.println("[Help]: last");
		 				System.out.println("[Help]: Execute la derniere commande correctement saisit");
		 	break;
		default : 	System.err.println("[Help]:Commande non trouv�e ");
			break;
		}
		
	}
	
}

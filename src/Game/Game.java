package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Item.Equipment;
import exception.GameException_GameOver;
import exit.*;
import interfacePackage.Recoverable;
import monster.*;
import npc.*;
import place.*;

/**
 * The Class Game.
 */
public class Game implements Serializable{

	private static final long serialVersionUID = -8950895708116794889L;
	private Hero 			hero;
	private List<Place> 	map;
	private Place 			currentPlace;
	
	/**
	 * Creation du jeu.
	 */
	public Game() {
		this.hero = new Hero("Hero");
		this.map  = new ArrayList<Place>();
		
		//creation map
		this.creationMap();
		
		//texte de bienvenue
		System.out.println("Bip...Bip...");
		System.out.println("[Les Tortues] Vite va au nord de la ville tuer un Alien avant qu'il ne fasse plus de victime");
	}
	
	/**
	 * Permet de créer la map
	 */
	private void creationMap(){
		//les lieux
			//ville
		this.currentPlace = new DeadEnd_Street();//0
		this.map.add(this.currentPlace);
		
		for(int i=1 ; i<=3 ; i++){
			this.map.add(new Street("La rue se poursuit aprés le virage"));
		}
		
		for(int i=4 ; i<=5 ; i++){
			this.map.add(new DeadEnd_Street());
		}
		
		this.map.add(new CrossRoad_Street());
		
		for(int i=7 ; i<=12 ; i++ ){
			this.map.add(new Street("La rue continue plus loin"));
		}
		
		for(int i=13 ; i<= 21 ; i++){
			this.map.add(new DeadEnd_Sewer());
		}
		
		for(int i=22 ; i<= 28 ; i++){
			this.map.add(new CrossRoad_Sewer());
		}
		
		for (int i= 29 ; i <= 38 ; i++){
			this.map.add(new Sewer("L'égout continue plus loin"));
		}
		
		for(int i= 39 ; i<=41 ; i++){
			this.map.add(new Sewer("L'égout continue aprés le virage"));
		}
		
		this.map.add(new FinalBossRoom());
		this.map.add(new CatWorld());
		this.map.add(new Sewer_Cell());
		
		//creation des sortie
			//ville
		this.map.get(0).setLink("Haut", new ClassicExit(this.map.get(1)));
		this.map.get(1).setLink("Bas", new ClassicExit(this.map.get(0)));
		this.map.get(1).setLink("Droite", new ClassicExit(this.map.get(7)));
		this.map.get(7).setLink("Gauche", new ClassicExit(this.map.get(1)));
		this.map.get(7).setLink("Droite", new ClassicExit(this.map.get(6)));
		this.map.get(6).setLink("Gauche", new ClassicExit(this.map.get(7)));
		this.map.get(6).setLink("Haut", new ClassicExit(this.map.get(8)));
		this.map.get(6).setLink("Bas", new ClassicExit(this.map.get(2)));
		this.map.get(8).setLink("Bas", new ClassicExit(this.map.get(6)));
		this.map.get(8).setLink("Haut", new ClassicExit(this.map.get(9)));
		this.map.get(9).setLink("Haut", new ClassicExit(this.map.get(3)));
		this.map.get(9).setLink("Bas", new ClassicExit(this.map.get(8)));
		this.map.get(3).setLink("Gauche", new ClassicExit(this.map.get(4)));
		this.map.get(3).setLink("Bas", new ClassicExit(this.map.get(9)));
		this.map.get(4).setLink("Droite", new ClassicExit(this.map.get(3)));
		this.map.get(2).setLink("Haut", new ClassicExit(this.map.get(6)));
		this.map.get(2).setLink("Droite", new ClassicExit(this.map.get(10)));
		this.map.get(10).setLink("Droite", new ClassicExit(this.map.get(11)));
		this.map.get(10).setLink("Gauche", new ClassicExit(this.map.get(2)));
		this.map.get(11).setLink("Gauche", new ClassicExit(this.map.get(10)));
		this.map.get(11).setLink("Droite", new ClassicExit(this.map.get(12)));
		this.map.get(12).setLink("Gauche", new ClassicExit(this.map.get(11)));
		this.map.get(12).setLink("Droite", new ClassicExit(this.map.get(5)));
		this.map.get(5).setLink("Gauche", new ClassicExit(this.map.get(12)));
		
		this.map.get(5).setLink("Egouts", new LockedExit(this.map.get(13)));
		this.map.get(13).setLink("Rue", new ClassicExit(this.map.get(5)));
		
		this.map.get(13).setLink("Haut", new ClassicExit(this.map.get(22)));
		this.map.get(22).setLink("Bas", new ClassicExit(this.map.get(13)));
		this.map.get(22).setLink("Droite", new ClassicExit(this.map.get(32)));
		this.map.get(22).setLink("Gauche", new ClassicExit(this.map.get(31)));
		this.map.get(22).setLink("Haut", new ClassicExit(this.map.get(38)));
		this.map.get(31).setLink("Gauche", new ClassicExit(this.map.get(23)));
		this.map.get(31).setLink("Droite", new ClassicExit(this.map.get(22)));
		this.map.get(23).setLink("Gauche", new ClassicExit(this.map.get(29)));
		this.map.get(23).setLink("Droite", new ClassicExit(this.map.get(31)));
		this.map.get(23).setLink("Haut", new ClassicExit(this.map.get(30)));
		this.map.get(29).setLink("Gauche", new ClassicExit(this.map.get(14)));
		this.map.get(29).setLink("Droite", new ClassicExit(this.map.get(23)));
		this.map.get(14).setLink("Droite", new ClassicExit(this.map.get(29)));
		this.map.get(30).setLink("Bas", new ClassicExit(this.map.get(23)));
		this.map.get(30).setLink("Haut", new ClassicExit(this.map.get(24)));
		this.map.get(24).setLink("Bas", new ClassicExit(this.map.get(30)));
		this.map.get(24).setLink("Droite", new ClassicExit(this.map.get(15)));
		this.map.get(24).setLink("Haut", new ClassicExit(this.map.get(16)));
		this.map.get(16).setLink("Bas", new ClassicExit(this.map.get(24)));
		this.map.get(15).setLink("Gauche", new ClassicExit(this.map.get(24)));
		this.map.get(38).setLink("Bas", new ClassicExit(this.map.get(22)));
		this.map.get(38).setLink("Haut", new ClassicExit(this.map.get(25)));
		this.map.get(25).setLink("Bas", new ClassicExit(this.map.get(38)));
		this.map.get(25).setLink("Gauche", new ClassicExit(this.map.get(39)));
		this.map.get(25).setLink("Droite", new ClassicExit(this.map.get(18)));
		this.map.get(18).setLink("Gauche", new ClassicExit(this.map.get(25)));
		this.map.get(39).setLink("Droite", new ClassicExit(this.map.get(25)));
		this.map.get(39).setLink("Haut", new ClassicExit(this.map.get(19)));
		this.map.get(19).setLink("Bas", new ClassicExit(this.map.get(39)));
		
		this.map.get(19).setLink("Porte", new CatExit(this.map.get(43)));
		this.map.get(43).setLink("Porte", new ClassicExit(this.map.get(19)));
		
		this.map.get(32).setLink("Gauche", new ClassicExit(this.map.get(22)));
		this.map.get(32).setLink("Droite", new ClassicExit(this.map.get(26)));
		this.map.get(26).setLink("Gauche", new ClassicExit(this.map.get(32)));
		this.map.get(26).setLink("Droite", new ClassicExit(this.map.get(27)));
		this.map.get(26).setLink("Bas", new ClassicExit(this.map.get(37)));
		this.map.get(37).setLink("Haut", new ClassicExit(this.map.get(26)));
		this.map.get(37).setLink("Bas", new ClassicExit(this.map.get(41)));
		this.map.get(41).setLink("Haut", new ClassicExit(this.map.get(37)));
		this.map.get(41).setLink("Droite", new ClassicExit(this.map.get(17)));
		this.map.get(17).setLink("Gauche", new ClassicExit(this.map.get(41)));
		this.map.get(27).setLink("Gauche", new ClassicExit(this.map.get(26)));
		this.map.get(27).setLink("Droite", new ClassicExit(this.map.get(20)));
		this.map.get(27).setLink("Haut", new ClassicExit(this.map.get(33)));
		this.map.get(20).setLink("Gauche", new ClassicExit(this.map.get(27)));
		this.map.get(33).setLink("Bas", new ClassicExit(this.map.get(27)));
		this.map.get(33).setLink("Haut", new ClassicExit(this.map.get(40)));
		this.map.get(40).setLink("Bas", new ClassicExit(this.map.get(33)));
		this.map.get(40).setLink("Droite", new ClassicExit(this.map.get(34)));
		this.map.get(34).setLink("Gauche", new ClassicExit(this.map.get(40)));
		this.map.get(34).setLink("Droite", new ClassicExit(this.map.get(28)));
		this.map.get(28).setLink("Gauche", new ClassicExit(this.map.get(34)));
		this.map.get(28).setLink("Haut", new ClassicExit(this.map.get(36)));
		this.map.get(28).setLink("Bas", new ClassicExit(this.map.get(35)));
		this.map.get(35).setLink("Haut", new ClassicExit(this.map.get(28)));
		this.map.get(35).setLink("Bas", new ClassicExit(this.map.get(21)));
		this.map.get(21).setLink("Haut", new ClassicExit(this.map.get(35)));
		this.map.get(36).setLink("Bas", new ClassicExit(this.map.get(28)));
		
		this.map.get(36).setLink("Porte", new FinalDoor(this.map.get(42)));
		this.map.get(42).setLink("Porte", new ClassicExit(this.map.get(36)));
		this.map.get(42).setLink("Prison", new ClassicExit(this.map.get(44)));
		
		
		//les object des salle spéciale
		this.map.get(4).addEntity(new QMonster_Alien());
		this.map.get((int)(Math.random()*41)).addEntity(new QEntity_Cat());	//on place le chat dans les 40 premiere salle
		this.map.get(18).addEntity(new Npc_Donatello());
		this.map.get(16).addEntity(new Npc_Leonardo());
		this.map.get(17).addEntity(new Npc_Michelangelo());
		this.map.get(21).addEntity(new Npc_Raphael());
		this.map.get(44).addEntity(new Npc_Spliffer());
		
		
	}
	
	/**
	 * Permet d'essayer de franchir une Exit et donc de changer de Place.
	 * Change currentPlace si crossing renvoi une Place != null.
	 * On peut franchir une Exit que si la Place actuel ne contient plus de monstre.
	 *
	 * @param exitName Le nom de la sortie que l'on veut franchir
	 */
	public void go (String exitName){
		if(this.currentPlace.haveMonster()){
			System.out.println("Des monstres vous bloque le chemin");
		}
		else{
			Place nextPlace = this.currentPlace.getNextPlace(exitName);
			if(nextPlace != null){
				this.currentPlace = nextPlace;
				System.out.println("Vous franchissez " + exitName);
				System.out.println("Vous êtes maintenant dans " + this.currentPlace.getName());
			}
			else{
				System.out.println("Impossible de franchir " + exitName);
			}	
		}
		
	}
	
	/**
	 * Affiche la description de la Place actuelle
	 */
	public void look (){
		this.currentPlace.description();
	}
	
	/**
	 * Permet de regarder la cible
	 *
	 * @param target Le nom de ce qu'on veut regarder
	 */
	public void look(String target){
		switch(target.toLowerCase()){
		case "exit" : Set<String>exitName = this.currentPlace.getNameExit();
					if(exitName.isEmpty()){
						System.out.println("Il n'y a auncune sortie");
					}
					else{
						for(String name : exitName){
							System.out.println(name);
						}
					}	
			break;
		case "object" : this.currentPlace.listItem();
			break;
		case "entity" : List<String> entityName = this.currentPlace.getNameEntites();
						if(entityName.isEmpty()){
							System.out.println("La pièce semble plutôt calme");
						}
						else{
							for(String name : entityName){
								System.out.println(name);
							}
						}
						
			break;
		case "me" : this.hero.description();
			break;
		case "equipement" : this.hero.lookInventory("Equipement");;
		break;
		case "set" : this.hero.lookSet();
			break;
		case "inventory" : this.hero.lookInventory("Item");;
		break;
		default:
				if(!this.currentPlace.exitDescription(target)){
					if(!this.currentPlace.getDescriptionEntity(target, false)){
						if(!this.currentPlace.getDescriptionItem(target)){
							System.out.println("La cible n'a pas été trouvé");
						}
					}
				}
			break;
		}
		
		
	}
	
	/**
	 * Permet de recuperer un Recoverable dans le place actuelle
	 *
	 * @param target le nom de ce que l'on veut prendre
	 * @throws GameException_GameOver signale si le hero a subit une défaite
	 */
	public void take(String target) throws GameException_GameOver{
		Item i = this.currentPlace.removeItem(target);
		boolean taked = false;
		if(i != null){
			if(i instanceof Recoverable){
				this.hero.takeItem(((Recoverable) i).take());		//on prend
				taked = true;
			}
			else{
				this.currentPlace.addItem(i);						//on laisse
			}
		}
		else{
			Entity e = this.currentPlace.removeEntity(target);
			if(e != null){
				if(e instanceof Recoverable){
					this.hero.takeItem(((Recoverable) e).take());	//on prend
					taked = true;
				}
				else{
					this.currentPlace.addEntity(e);					//on laisse
				}
			}
						
			
		}
		if(taked){
			System.out.println("Vous avez ramassé " + target);
			this.currentPlace.fight(this.hero, null, false);  		//les monstres attaquent
		}
		else{
			System.out.println("Impossible de ramasser " + target);
		}
	}
	
	/**
	 * Permet d'utiliser un UseableItem sur quelquechose
	 *
	 * @param objectName Le nom de ce que l'on veut utiliser
	 * @param targetName Le nom de la cible
	 * @throws GameException_GameOver signale si le hero a subit une défaite
	 */
	public void use (String objectName, String targetName) throws GameException_GameOver{
		Object target = null;
		if(targetName.equalsIgnoreCase("me")){
			target = this.hero;
		}
		else{
			target = this.currentPlace.getExit(targetName);
			if(target == null){
				target = this.currentPlace.removeEntity(targetName);
				if(target == null){
					System.out.println(targetName + " n'a pas été trouvé");
				}
				else{
					this.currentPlace.addEntity((Entity)target);
				}
			}
		}
		
		if(target != null){
			this.hero.useItem(objectName, target);
			this.currentPlace.fight(this.hero, null, false);		//les monstres t'attaquent
		}
		
	}
	
	/**
	 * Permet d'utiliser un utilisable sur le hero
	 *
	 * @param objectName Le nom de l'utilisable
	 * @throws GameException_GameOver signale si le hero a subit une défaite
	 */
	public void use (String objectName) throws GameException_GameOver{
		this.use(objectName, "me");
	}
	
	/**
	 * Permet d'attaquer une Entity avec le hero
	 *
	 * @param target Le nom de l'entity prise pour cible
	 * @throws GameException_GameOver signale si le hero a subit une défaite
	 */
	public void attack (String target) throws GameException_GameOver{
		this.currentPlace.fight(this.hero, target, true);
	}
	
	/**
	 * Permet d'équiper l'équipement
	 *
	 * @param name le nom de l'équipement 
	 */
	public void equip(String name){
		this.hero.equip(name);
	}
	
	/**
	 * Permet de déséquiper la zone designé
	 *
	 * @param name Le nom de la zone d'équipement
	 */
	public void unequip(String name){
		this.hero.unequip(name);
	}
	
	/**
	 * Permet de jeter un Recoverable de l'inventaire du hero dans la place actuelle
	 *
	 * @param name le nom du Recoverable
	 */
	public void discard(String name){
		Recoverable r = this.hero.throwItem(name);
		if(r != null){
			if(r instanceof Item){
				this.currentPlace.addItem((Item)r);
				System.out.println("Vous posez " + name);
			}
			else{
				if(r instanceof Entity){
					this.currentPlace.addEntity((Entity)r);
					System.out.println(name + " reste là à vous regarder tristement");
				}
				else{
					System.err.println("Impossible de savoir le type de " + r);
				}
			}
		}
		else{
			System.out.println("Vous ne possedez pas " + name);
		}
	}
	
	/**
	 * Analyse les statistiques de la cible.
	 * La cible peut se trouver dans le lieu actuel ou sur le hero
	 *
	 * @param target le nom de la cible
	 */
	public void analyse(String target){
		switch(target.toLowerCase()){
			case "me" : this.hero.entityDescription();
				break;
			default : if(!this.currentPlace.getDescriptionEntity(target, true)){
						Item item = this.currentPlace.removeItem(target);
						if(item != null){
							if(item instanceof Equipment){
								((Equipment)item).EquipementDescription();
							}
							else{
								System.out.println(target + " n'est pas analysable");
							}
							this.currentPlace.addItem(item);
						}
						else{
							Recoverable r = this.hero.throwItem(target);
							if(r != null){
								if(r instanceof Equipment){
									((Equipment)r).EquipementDescription();
								}
								else{
									if(r instanceof Entity){
										((Entity)r).entityDescription();
									}
									else{
										System.out.println(target + " n'est pas analysable");
									}
									
								}
								this.hero.takeItem(r);
							}
							else{
								if(!this.hero.analyseSet(target)){
									System.out.println("Impossible de trouver la cible");
								}
							}
						}
					  }
				break;
		}
		
	}
	
	/**
	 * Permet d'écouter ce qu'un Npc veut dire
	 *
	 * @param target le nom du npc
	 */
	public void speak(String target){
		Entity e = this.currentPlace.removeEntity(target);
		if(e != null){
			if(e instanceof Npc){
				Item i = ((Npc)e).speak();
				if(i != null){
					this.currentPlace.addItem(i);
				}
			}
			else{
				System.out.println(target + " n'a pas l'air amicale");
			}
			this.currentPlace.addEntity(e);
		}
		else{
			System.out.println(target + " n'existe que dans votre tête");
		}
	}
	
	
}

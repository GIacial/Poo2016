package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Item.Equipment;
import boots.*;
import chest.*;
import exception.GameException_GameOver;
import exit.*;
import furniture.*;
import glove.*;
import head.*;
import interfacePackage.Recoverable;
import monster.*;
import npc.*;
import place.*;
import trouser.*;
import useableItem.*;
import weapon.*;

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
		this.currentPlace = new ClassicPlace("Début du test");//0
		this.map.add(this.currentPlace);
		
		this.map.add(new ClassicPlace("Salle 1"));//1
		this.currentPlace.setLink("Porte", new ClassicExit(this.map.get(1)));
		this.map.get(1).setLink("Porte", new ClassicExit(this.currentPlace));
		
		
		this.map.add(new ClassicPlace("Boss"));//2
		this.map.get(1).setLink("Sortie", new LockedExit(this.map.get(2)));
		
		this.map.add(new ClassicPlace("Salle 2"));//3
		this.map.get(1).setLink("Couloir", new ClassicExit(this.map.get(3)));
		this.map.get(3).setLink("Couloir", new ClassicExit(this.map.get(1)));
		
		//parti à enlever car sera fait dans les constructeur des lieux
		this.map.get(1).addEntity(new Monster_Kankrelat());
		this.map.get(1).addItem(new Trouser_LeatherTrouser());
		this.map.get(1).addItem(new Glove_LeatherGlove());
		this.map.get(1).addItem(new Head_LeatherHead());
		
		this.map.get(0).addEntity(new Entity_Cat());
		this.map.get(0).addItem(new Weapon_BasicSword());
		this.map.get(0).addItem(new Furniture_Fridge());
		this.map.get(0).addItem(new Boots_LeatherBoots());
		this.map.get(0).addItem(new Item_Potion());
		
		this.map.get(2).addEntity(new Entity_Cat());
		this.map.get(2).addEntity(new Monster_Krabe());
		this.map.get(2).addItem(new Item_Potion());
		

		this.map.get(3).addItem(new Weapon_IronSword());
		this.map.get(3).addItem(new Chest_LeatherChest());
		this.map.get(3).addItem(new Item_Key());
		this.map.get(3).addItem(new Item_Potion());
		this.map.get(3).addEntity(new Monster_Kankrelat());
		
		//texte de bienvenue
		System.out.println("[La Déesse] Bienvenue Aventurier dans le monde de test");
	}
	
	/**
	 * Permet d'essayer de franchir une Exit et donc de changer de Place
	 * Change currentPlace si crossing renvoi une Place != null
	 * On peut franchir une Exit que si la Place actuel ne contient plus de monstre
	 *
	 * @param Le nom de la sortie qu'on veut franchir
	 */
	public void go (String exitName){
		if(this.currentPlace.haveMonster()){
			System.out.println("Des monstres vous bloque le chemin");
		}
		else{
			Place nextPlace = this.currentPlace.getNextPlace(exitName);
			if(nextPlace != null){
				this.currentPlace=nextPlace;
				System.out.println("Vous franchissez "+exitName);
			}
			else{
				System.out.println("Impossible de franchir "+exitName);
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
	 * Permet de regarder un truc
	 *
	 * @param Le nom de ce qu'on veut regarder
	 */
	public void look(String target){
		switch(target.toLowerCase()){
		case "exit":Set<String>exitName = this.currentPlace.getNameExit();
					if(exitName.isEmpty()){
						System.out.println("Il n'y a auncune sortie");
					}
					else{
						for(String name : exitName){
							System.out.println(name);
						}
					}	
			break;
		case "object":this.currentPlace.listItem();
			break;
		case "entity":List<String> entityName = this.currentPlace.getNameEntites();
						if(entityName.isEmpty()){
							System.out.println("Il n'y a aucun signe de vie");
						}
						else{
							for(String name : entityName){
								System.out.println(name);
							}
						}
						
			break;
		case "me":this.hero.description();
			break;
		case "equipement":this.hero.lookInventory("Equipement");;
		break;
		case "set":this.hero.lookSet();
			break;
		case "inventory":this.hero.lookInventory("Item");;
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
	 * Take.
	 *
	 * @param target the target
	 * @throws GameException_GameOver the game exception game over
	 */
	public void take(String target) throws GameException_GameOver{
		Item i = this.currentPlace.removeItem(target);
		boolean taked = false;
		if(i!=null){
			if(i instanceof Recoverable){
				this.hero.takeItem(((Recoverable) i).take());//on prend
				taked=true;
			}
			else{
				this.currentPlace.addItem(i);//on laisee
			}
		}
		else{
			Entity e = this.currentPlace.removeEntity(target);
			if(e != null){
				if(e instanceof Recoverable){
					this.hero.takeItem(((Recoverable) e).take());//on prend
					taked = true;
				}
				else{
					this.currentPlace.addEntity(e);//on laisee
				}
			}
						
			
		}
		if(taked){
			System.out.println("Vous avez rammasé "+target);
			this.currentPlace.fight(this.hero, null, false);//les monstre attaque
		}
		else{
			System.out.println("Impossible de ramasser "+target);
		}
	}
	
	/**
	 * Use.
	 *
	 * @param objectName the object name
	 * @param targetName the target name
	 * @throws GameException_GameOver the game exception game over
	 */
	public void use (String objectName ,String targetName) throws GameException_GameOver{
		Object target = null;
		if(targetName.equals("me")){
			target = this.hero;
		}
		else{
			target = this.currentPlace.getExit(targetName);
			if(target == null){
				target = this.currentPlace.removeEntity(targetName);
				if(target == null){
					System.out.println(targetName+" n'a pas été trouvé");
				}
				else{
					this.currentPlace.addEntity((Entity)target);
				}
			}
		}
		
		if(target != null){
			this.hero.useItem(objectName, target);
			this.currentPlace.fight(this.hero, null, false);//les monstre t'attaque
		}
		
	}
	
	/**
	 * Use.
	 *
	 * @param objectName the object name
	 * @throws GameException_GameOver the game exception game over
	 */
	public void use (String objectName) throws GameException_GameOver{
		this.use(objectName,"me");
	}
	
	/**
	 * Attack.
	 *
	 * @param target the target
	 * @throws GameException_GameOver the game exception game over
	 */
	public void attack (String target) throws GameException_GameOver{
		this.currentPlace.fight(this.hero, target, true);
	}
	
	/**
	 * Equip.
	 *
	 * @param name the name
	 */
	public void equip(String name){
		this.hero.equip(name);
	}
	
	/**
	 * Unequip.
	 *
	 * @param name the name
	 */
	public void unequip(String name){
		this.hero.unequip(name);
	}
	
	/**
	 * Discard.
	 *
	 * @param name the name
	 */
	public void discard(String name){
		Recoverable r = this.hero.throwItem(name);
		if(r != null){
			if(r instanceof Item){
				this.currentPlace.addItem((Item)r);
				System.out.println("Vous posez "+name);
			}
			else{
				if(r instanceof Entity){
					this.currentPlace.addEntity((Entity)r);
					System.out.println(name+" reste là à vous regarder tristement");
				}
				else{
					System.err.println("Impossible de savoir le type de "+r);
				}
			}
		}
		else{
			System.out.println("Vous ne possedez pas "+name);
		}
	}
	
	/**
	 * Analyse.
	 *
	 * @param target the target
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
								System.out.println(target+" n'est pas analysable");
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
									System.out.println(target+" n'est pas analysable");
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
	 * Speak.
	 *
	 * @param target the target
	 */
	public void speak(String target){
		Entity e = this.currentPlace.removeEntity(target);
		if(e != null){
			if(e instanceof Npc){
				((Npc)e).speak();
			}
			else{
				System.out.println(target+" n'a pas l'air amicale");
			}
			this.currentPlace.addEntity(e);
		}
		else{
			System.out.println(target+" n'existe que dans votre tête");
		}
	}
	
	
}

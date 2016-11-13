package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Item.Item_Key;	//a enlever plus tard
import exit.*;
import interfacePackage.Recoverable;
import npc.*;
import place.*;

public class Game {

	private Hero hero;
	private List<Place> map;
	private Place currentPlace;
	
	public Game() {
		this.hero= new Hero("Hero");
		this.map = new ArrayList<Place>();
		
		//creation map
		this.currentPlace=new ClassicPlace("Début");
		this.map.add(this.currentPlace);
		
		this.map.add(new ClassicPlace("Salle 1"));
		this.currentPlace.setLink("Porte", new ClassicExit(this.map.get(1)));
		
		this.map.add(new ClassicPlace("fin"));
		this.map.get(1).setLink("Porte", new ClassicExit(this.currentPlace));
		this.map.get(1).setLink("Sortie", new LockedExit(this.map.get(2)));
		
		//parti à enlever
		this.map.get(1).addItem(new Item_Key());
		this.map.get(0).addEntity(new Entity_Cat());
		this.map.get(2).addEntity(new Entity_Cat());
	}
	
	public void go (String exitName){
		Place nextPlace= this.currentPlace.getNextPlace(exitName);
		if(nextPlace!=null){
			this.currentPlace=nextPlace;
			System.out.println("Vous franchissez "+exitName);
		}
		else{
			System.out.println("Impossible de franchir "+exitName);
		}
	}
	
	public void look (){
		this.currentPlace.description();
	}
	
	public void look(String target){
		switch(target.toLowerCase()){
		case "exit":Set<String>exitName=this.currentPlace.getNameExit();
					if(exitName.isEmpty()){
						System.out.println("Il y a auncune sortie");
					}
					else{
						for(String name : exitName){
							System.out.println(name);
						}
					}	
			break;
		case "object":this.currentPlace.listItem();
			break;
		case "entity":List<String> entityName=this.currentPlace.getNameEntites();
						if(entityName.isEmpty()){
							System.out.println("Il y a aucun signe de vie");
						}
						else{
							for(String name : entityName){
								System.out.println(name);
							}
						}
						
			break;
		case "me":this.hero.description();
			break;
		case "pocket":this.hero.lookInventory("Item");;
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
	
	public void take(String target){
		Item i=this.currentPlace.removeItem(target);
		boolean taked=false;
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
			Entity e= this.currentPlace.removeEntity(target);
			if(e!=null){
				if(e instanceof Recoverable){
					this.hero.takeItem(((Recoverable) e).take());//on prend
					taked=true;
				}
				else{
					this.currentPlace.addEntity(e);//on laisee
				}
			}
						
			
		}
		if(taked){
			System.out.println("Vous avez rammasé "+target);
		}
		else{
			System.out.println("Impossible de ramasser "+target);
		}
	}

}

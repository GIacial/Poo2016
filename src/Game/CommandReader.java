package Game;

import java.util.Scanner;


public class CommandReader {
	private Scanner s;
	private boolean actif;
	private Game game;

	public CommandReader(Game game) {
		this.s=new Scanner(System.in);
		this.actif=true;
		this.game=game;
	}
	
	public void interpretation(){
		Scanner sCommand= new Scanner(this.s.nextLine());//permet de savoir si il y a qqch apres
		if(sCommand.hasNext()){
			String command=sCommand.next();
			try{
				Command t=Command.valueOf(command.toLowerCase());//lower cas pour que Bonjour=bonjour
				
				switch(t){
					case look:this.look(sCommand);
						break;
						
					case quit:this.quit();
						break;
						
					case go:this.go(sCommand);
						break;
						
					case help:this.help(sCommand);
						break;
						
					case take:this.take(sCommand);
						break;
						
					default:System.err.println("Pas encore fait");
							break;
				}
			}
			catch(Exception e){
				if(!(e instanceof IllegalArgumentException)){
					System.err.println(e);
					throw e;
				}
				System.out.println(command + " n'est pas une commande");
			}
		}
		sCommand.close();
		
	}

	public boolean isActif() {
		return this.actif;
	}
	
	private void go(Scanner sCommand){
		if(sCommand.hasNext()){
			game.go(sCommand.next());
		}
		else{
			Command.go.description();
		}
	}
	
	private void look(Scanner sCommand){
		if(sCommand.hasNext()){
			this.game.look(sCommand.next());
		}
		else{
			this.game.look();
		}
	}
	
	private void help(Scanner sCommand){
		if(sCommand.hasNext()){
			Command.description(sCommand.next());
		}
		else{
			Command listCommand[]=Command.values();
			for(int i=0; i<listCommand.length;i++){
				System.out.println(listCommand[i]);
			}
		}
	}
	
	private void quit(){
		System.out.println("Au revoir");
		//insere sauvegarde ici
		this.actif=false;
		s.close();								//fin du scanner principal
	}
	
	private void take(Scanner sCommand){
		if(sCommand.hasNext()){
			this.game.take(sCommand.next());
		}
		else{
			Command.take.description();
		}
	}

}

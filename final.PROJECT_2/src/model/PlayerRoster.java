package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.GameController;

public class PlayerRoster {
	private Player[] listOfPlayers;
	private ArrayList<String> listOfPlNames;
	private int numOfPls;
	private int numOfPlsNames;
	private int i;
	
	@SuppressWarnings("unchecked")
	public PlayerRoster(){
		this.listOfPlayers = new Player[50];
		numOfPlsNames = numOfPls;

		this.addPls(new Player("Eleni",null));
		this.addPls(new Player("Hal",null));
		this.addPls(new Player("Mr.Bean",null));
		this.addPls(new Player("Roberto",null));
		this.addPls(new Player("andreas",null));
		this.addPls(new Player("marios",null));
		this.listOfPlNames = new ArrayList<String>();
        
		this.listOfPlNames.add(this.listOfPlayers[0].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[1].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[2].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[3].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[4].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[5].getPlName());
		
		//convertFromArrToStr(this.listOfPlNames);
		//fillPlNameList();
	
	}
	public void addPls(Player p) {
		listOfPlayers[numOfPls]=p;
		numOfPls++;
	}
	public String[] convertFromArrToStr(ArrayList<String> list) {
		String[] str = new String[list.size()];
		 
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
	}
	
	public void fillPlNameList() {
		for(i = 0; i<this.numOfPls; i++) {
			this.listOfPlNames.add(this.listOfPlayers[i].getPlName());
		}
		
	}
	
	public void addPlayerByName(String s) {	
			this.listOfPlayers[numOfPls] = new Player(s,null);			
			this.numOfPls++;	
	}
	
	public void addPlayerName(String s) {
	listOfPlNames.add(s);
	this.numOfPls++;
	}
	
	public void findPlayerNames(Player[] list){
			System.out.println("The players...:");
			for(int i=0;i<list.length;i++) {
				if(list[i]!=null) {
				System.out.println((i+1)+"."+list[i].getPlName());
				}
			}
		
	}

	
	public Player findPlayer(String name) {
		for(Player pl : this.listOfPlayers) {
			if((pl != null) && pl.getPlName().equals(name)) {
				return pl;
			}
		}
		//System.out.println("ERROR PLAYER NOT FOUND");
		return null;
	}
	
	public void findHallOfFame(int x) {
		//SORTING_THE_ARRAY
	        int n = listOfPlayers.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(listOfPlayers[j-1].getHistory().PlWins > listOfPlayers[j].getHistory().PlWins ){  
	                                 //swap elements  
	                                 temp = listOfPlayers[j-1].getHistory().PlWins;  
	                                 listOfPlayers[j-1] = listOfPlayers[j];  
	                                 listOfPlayers[j].getHistory().PlWins  = temp;  
	                         }  
	                          
	                 }  
	         }  	  
	         System.out.println("The best"+" "+x+" "+"players...:");
				for(int ia=0;ia<5;ia++) {
					if(listOfPlayers[ia]!=null) {
						System.out.print(listOfPlayers[ia]);
					}
				}
	}


	public int getNumOfPls() {
		return numOfPls;
	}


	public void setNumOfPls(int numOfPls) {
		this.numOfPls = numOfPls;
	}


	public Player[] getListOfPlayers() {
		return listOfPlayers;
	}

	/*public String[] getListOfPlNames() {
		
		return listOfPlNames;
	}


	public void setListOfPlNames(String[] listOfPlNames) {
		this.listOfPlNames = listOfPlNames;
	}*/


	public void setListOfPlayers(Player[] listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	public ArrayList getListOfPlNames() {
		return listOfPlNames;
	}
	public void setListOfPlNames(ArrayList listOfPlNames) {
		this.listOfPlNames = listOfPlNames;
	}
	public int getNumOfPlsNames() {
		return numOfPlsNames;
	}
	public void setNumOfPlsNames(int numOfPlsNames) {
		this.numOfPlsNames = numOfPlsNames;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	
	
}
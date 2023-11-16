package main;

import java.util.ArrayList;

import lib.Player;

public class PlayerApp {

	/**
	 * This will print out the players that have their surname in the gamertag
	 * as well as the number passed through the function
	 * if yes it will print the first name in all capitals and the surname in all lowercase
	 * @param participants, ArrayList of players to work through, of data type Player
	 * @param number, to check if gamerTag contains the value of the variable
	 * @return string, list of players in the required format
	 */
	public static String execute(ArrayList<Player> participants, int number) {
		
		String players = "";
		String num = Integer.toString(number);
		
		for (Player p : participants) {
			String gamerTag = p.getGamerTag().toLowerCase();
			String surName = p.getName().getFamilyName().toLowerCase();
			if (gamerTag.contains(surName)) {
				if (gamerTag.contains(num)) {
					String firstName = p.getName().getFirstName().toUpperCase();
					String lastName = p.getName().getFamilyName().toLowerCase() ;
					players += firstName + ", " + lastName + "\n";
				}
			}
		}
		
		return players;
	}
	
}

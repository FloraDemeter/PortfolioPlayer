package lib;

/**
 * A Player has a Name (class), Rollable (Rollable), gamertag (string).
 * This class is a combination of class Name and implements Rollable.
 * 
 * @author demeterflora
 */
public class Player implements Rollable, Comparable<Player> {	
	
	//Fields
	private Name name;
	private Rollable d;
	private String gamerTag;
	
	//Constructors
	/**
	 * Creates a new instance of a Player, using the default values.
	 * The default value for gamerTag is empty string
	 */
	
	public Player() {
		name = new Name();
		d = new PairOfDice();
		gamerTag = "";
	}
	
	/**
	 * Creates a new instance of a Player, using the default and given values.
	 * @param Name = the name of the player
	 * @param gamerTag = the gamertag of the player
	 */
	
	public Player(Name name, String gamerTag) {
		this.name = name;
		this.d = new PairOfDice();
		this.gamerTag = gamerTag;
	}
	
	/**
	 * Creates a new instance of a Player, using the given values.
	 * @param name = the name of the player
	 * @param d = Rollable Interface
	 * @param gamerTag = the gamertag of the player
	 */
	
	public Player(Name name, String gamerTag, Rollable d) {
		this.name = name;
		this.d = d;
		this.gamerTag = gamerTag;
	}
	
	//Methods as required by UML design
	/**
	 * sets the name as the parameter passed through
	 * @param name, of type Name will hold the value to be stored
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/**
	 * sets the gamerTag as the parameter passed through
	 * @param gamerTag, of type String will hold the value to be stored
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}
	
	/**
	 * sets the first and surname of the player as the parameter passed through
	 * Since its a string first name and surname needs to be separated
	 * which in this case would be done as
	 * firstname = first character till whitespace character
	 * surname = whitespace character +1 till last letter
	 * @param name, of type String will hold the value to be stored
	 */
	public void setFullPlayerName(String name) {
		char firstInitial = Character.toUpperCase(name.charAt(0));
		int spaceLocation = name.indexOf(" ");
		char secondInitial = Character.toUpperCase(name.charAt(spaceLocation+1));
		
		String firstName = firstInitial + name.toLowerCase().substring(1, spaceLocation);
		String lastName = secondInitial + name.toLowerCase().substring(spaceLocation+2);
		
		this.name.setFirstName(firstName);
		this.name.setFamilyName(lastName);
	}
	
	/**
	 * retrieves the rollable interface used
	 */
	public Rollable getRollable() {
		return d;
	}
	
	/**
	 * retrieves the name used
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * retrieves the gamerTag used
	 */
	public String getGamerTag() {
		return gamerTag;
	}
	
	/**
	 * retrieves the score from the rollable interface using the method from it
	 */
	public int getDiceScore() {
		return d.getScore();
	}
	
	/**
	 * rolls the dice using the method from the rollable interface
	 */
	public void rollDice() {
		d.roll();
	}
	
	/**
	 * Will generate gamerTag
	 * it will be the full name of the user reversed in lowercase
	 * appended with the number passed as parameter if it is under 100
	 * @param num, integer, to append the fullname with
	 */
	public void generateGamerTag(int num) {
		if (num >= 1 && num <= 100) {
			String tag = new StringBuilder(this.name.getFullName()).reverse().toString();
			tag = tag.toLowerCase();
			tag = tag.replace(" ", "");
			this.gamerTag = tag + num;
		}
	}
	
	/**
	 * Overwritten methods to match required format
	 * toString(), roll() and getScore() from the Rollable interface 
	 */
	
	@Override
	public String toString() {
		return "Player:[name= " + name + ", Rollable= " + d + ", gamerTag= " + gamerTag +"]";
	}
	
	/**
	 * Overwritten methods from Rollable interface to be better suited for current class
	 * uses the rollDice method from within this class
	 */
	@Override
	public void roll() {
		rollDice();
		
	}

	/**
	 * Overwritten methods from Rollable interface to be better suited for current class
	 * uses the getDiceScore method from within this class
	 * @return getDiceScore(), method that returns integer
	 */
	@Override
	public int getScore() {
		return getDiceScore();
	}

	/**
	 * Overwritten compareTo to match required formatting
	 * where first the name and then the gamerTag is compared
	 * @param n = name object to compare 
	 */
	@Override
	public int compareTo(Player other) {
		int result = this.name.compareTo(other.name);
		if ( result == 0 ) { 
			result = this.gamerTag.compareTo(other.gamerTag);
		}
		return result;
	}


}

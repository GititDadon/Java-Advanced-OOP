package privateutil;

import animals.Animal;
import mobility.Point;
import utilities.MessageUtility;


/**
* Describes Animals That Has Chewing Behavior.
* 
* @author Gitit Dadon:212280911, Michal Tenenboim:326945763, Campus-Ashdod
* @see Elephant,Giraffe,turtle
*
*/
public abstract class ChewAnimals extends Animal {
	
	/**
	 * Default Constructor
	 */
	public ChewAnimals() {
		
	}
	/**
	 * Parameterized Constructor
	 * @param name-animal's name
	 * @param location-animal's location
	 */
	public ChewAnimals(String name,Point location) {
		
		super(name,location);
	}
	
	/**
	 * Animal's Behavior
	 * @param behavior-String of Animal's Behavior
	 */
	public void chew(String behavior) {
		
		MessageUtility logSound=new MessageUtility();
		
		logSound.logSound(this.getName(),behavior);
	}
	
}

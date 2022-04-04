package animals;
import diet.Herbviore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import plants.Cabbage;
import privateutil.ChewAnimals;
import utilities.MessageUtility;

/**
 * Giraffe Class represents Giraffe Behavior.
 * 
 * @author Gitit Dadon-212280911, Michal Tenenboim-326045763 Ashdod Campus
 * @see ChewAnimals
 */
public class Giraffe extends ChewAnimals{
	/**
	 * 
	 */
	private double neckLength=1.5;
	/**
	 * 
	 */
	private double weight=450;
	/**
	 * 
	 */
	private Point location=new Point(50,0);
	/**
	 * 
	 */
	private Herbviore herb=new Herbviore();
	
	/**
	 *  a constructor which gets 1 parameter: name and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name the name of the giraffe
	 */
	public Giraffe(String name) {
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(weight);
		this.setLocation(location);
		this.setNeckLength(neckLength);
		this.setDiet(new Herbviore());
		
	}
	/**
	 * a constructor which gets 2 parameters: name and location and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
	 *
	 * @param name the name of the giraffe
	 * @param location the location of the giraffe
	 */
	public Giraffe(String name,Point location) {
		
		super(name,location);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(weight);
		this.setNeckLength(neckLength);
		this.setDiet(new Herbviore());
		
	}
	/**
	 * a constructor which gets 2 parameters: name and neck length and the other parameters that were not given will be initialized 
	 * after that a new object will be created from all the parameters.
	 *
	 * @param name the name of the giraffe
	 * @param neckLength the neck length of the giraffe
	 */
	public Giraffe(String name,double neckLength)
	{
		MessageUtility.logConstractor("Animal", name);
		this.setName(name);
		MessageUtility.logConstractor(this.getClass().getSimpleName(), name);
		this.setWeight(weight);
		this.setDiet(new Herbviore());
		this.setLocation(location);
		this.setNeckLength(neckLength);
		
	}
	/**
	 * prints how the giraffe makes sound when it chews.
	 */
	public void makeSound() {
		this.chew("Bleats and Stomps its legs, then chews");
		
	}
	
	/**
	 *  returns the weight of the of the giraffe object
	 * @return returns the weight of the of the giraffe object
	 */
	public double getWeight() {
		
		return this.weight;
	}
	/**
	 Updates Giraffe's Neck Length To The Given Parameter.
	 * @param neckLength -double , represents giraffe neck length.
	 * @return true if neck length is legal,else false. 
	 */
	public boolean setNeckLength(double neckLength)
	{
		if(neckLength>=1 && neckLength<=2.5)
		{
			this.neckLength=neckLength;
			MessageUtility.logSetter(this.getName(), "setNeckLength", neckLength, true);
			 return true;
		}
		MessageUtility.logSetter(this.getName(), "setNeckLength", neckLength, false);
		 return false;
	}

	
	
}

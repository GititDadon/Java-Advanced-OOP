package animals;
import diet.Carnivore;
import diet.IDiet;
import mobility.Point;
import plants.Cabbage;
import mobility.Mobile;
import food.EFoodType;
import food.IEdible;
import diet.IDiet;
import utilities.MessageUtility;
import privateutil.*;

/**
 * Describes The Behavior That All The Animals Have.
 * 
 * @author  Gitit Dadon-212280911, Michal Tenenboim-326045763 Ashdod Campus
 *
 */
public abstract class Animal extends Mobile implements IEdible {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private  double weight=0;
	
	/**
	 * 
	 */
	private IDiet diet = null;
	
	/**
	 *  a constructor which gets 2 parameters: name and location ,and the other parameters that were not given will be initialized 
	 * and a new object will be created from all the parameters.
	 * 
	 * @param name the name of the animal
	 * @param location the location of the animal
	 */
	public Animal(String name, Point location)
	{
		
		
		super(location);
	
		MessageUtility.logConstractor("Animal",name);
			
		this.setName(name);
		
		
	}
	
	
	/**
	 * a default constructor
	 */
	public Animal() 
	{
		
	}
	/**
	 *returns an object which implements the interface Idiet. 
	 * 
	 * @return returns an object which implements the interface Idiet. 
	 */
	public IDiet getDiet() {
		return diet;
	}
	
	/**
	 * abstract function describes the behavior of each animal.
	 */
	public abstract void makeSound();
	
	/**
	 *  returns animal's Food Type.
	 * @return animal's food type from EFoodtype .
	 */
    public EFoodType getFoodtype() {
		
		
		MessageUtility getter=new MessageUtility();
		
		
		getter.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);
		
		
		return EFoodType.MEAT;
	}
		 
	/**
	 
	 * @return the name of  animal.
	 */
	public String getName() {
		
		
		MessageUtility getter=new MessageUtility();
		
		
		getter.logGetter(this.name, "getName", this.name);
		
		
		return this.name;
	}
	
	/**
	    changes the object name with the given parameter. 
	 * @param name the name of the animal
	 * @return returns true if the object's name was changed to the given parameter else will return false.
	 */
	public boolean setName(String name) {
		
		
		this.name=name;
		
		
		MessageUtility setter=new MessageUtility();
		
		
		setter.logSetter(this.name, "setName", this.name, true);
		
		
		return true;
	}
	
	/**
	 
	 * @return returns the weight of the animal object we are working on.
	 */
	public double getWeight()
	{
		
		MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
		
		return this.weight;
	}
	
	/**
	 *  returns true if succeeded with changing the animal weight to the given parameter else returns false.
	 * @param weight the weight of the animal.
	 * @return returns true if the animal weight of the object was changed to the given parameter else returns false.
	 */
	public boolean setWeight(double weight) {
		
		if (weight>0)
		{
			this.weight=weight;
			
			
			MessageUtility setter=new MessageUtility();
			
			
			setter.logSetter(this.name, "setWeight", this.weight, true);
			
			
			return true;
		}
		MessageUtility.logSetter(this.name, "setWeight", weight, false);
		return false;
	}
	/**
	 * Returns a string that describes animal object
	 */
	public String toString(){
		
		
		return "["+this.getClass().getSimpleName()+"]"+this.getName();
	}
	
	
	/**
	 * function which returns the type of the animal object.
	 * 
	 * @return the type of the object we are working with.
	 */
	public Object getType() {
		
		return this.getClass();
	}
	
	/**
	 * moves the location of the object ,to a different location  
	 * and returns current calculation .
	 * @param point the point of the animal it's a new location 
	 * @return returns the calculation of the distance the object did this time, but not the total distance from all the times.
	 */
	public  double move(Point point)
	{ 
		Point p1=new Point(0,0);
		
		if(p1.checkBoundries(point))
		{
			this.addTotalDistance(this.calcDistance(point)); 
			
			point.setpoint(point);
			
		    this.setWeight(this.getWeight()-(this.calcDistance(point)*this.getWeight()*0.00025));
		   
		    MessageUtility.logBooleanFunction(this.getName(), "move", point, true);
		   
		    return this.calcDistance(point);
		}
		 MessageUtility.logBooleanFunction(this.getName(), "move", point, false);
			return 0;
		
	}
	/**
	 * receives a value from IEdible -a type of food if the object can eat it the function return true else 
	 * returns false.
	 * 
	 * @param var   an IEdible type object 
	 * @return returns true if the object can eat the food type else returns false.
	 * @see IEdible
	 */
	public boolean eat(IEdible var) {
		double weight=diet.eat(this, var);
		if( weight>0) 
		{
			
			this.setWeight(weight+this.getWeight());
			this.makeSound();
			MessageUtility.logBooleanFunction(this.getName(), "eat", var, true);
			return true;
			
		}
		MessageUtility.logBooleanFunction(this.getName(), "eat", var, false);
		return false;
	}
	/**
	 * 
	 * Updates Animal's Diet.
	 * @param diet -Object That Implement IDiet Interface
	 * @return true if succeeded changing the parameter diet of the object to the given parameter
	 * else false..
	 */
	public  boolean setDiet(IDiet diet) {
		this.diet=diet;
		MessageUtility.logSetter(this.getName(),"setDiet", diet.getClass().getSimpleName(), true);
		return true;
	}
		
	
	
	

}

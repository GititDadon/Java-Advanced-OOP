package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import diet.Carnivore;
import diet.Carnivore;
import diet.Herbviore;
import diet.Herbviore;
import diet.Omnivore;
import food.IEdible;
import mobility.Point;
import plants.Cabbage;
import utilities.MessageUtility;

import java.util.Random;






/**
 * Describes General  Actions On The Zoo Animals.
 * 
 * @author Gitit Dadon:212280911, Michal Tenenboim:326945763, Campus-Ashdod
 * @see Animal
 *
 */
public class ZooActions {    
	
	
	/**
	 * Default Constructor
	 */
	public ZooActions() {
		
	}
	
	
	/**
	 * Checks The Type Of The Given Object And Cast It Into Animal Type.
	 * @param animal-From type Object To Be Casted Into An Animal Type.
	 * @return DownCasted Animal Type.
	 */
	public static Animal getType(Object animal)
	{
		if(animal instanceof Lion) 
		{
				return (Lion)animal;
		}
		if(animal instanceof Bear)
		{
				return (Bear)animal;
		}
			
		if(animal instanceof Elephant) 
		{
				return (Elephant)animal;
		}
				
		if(animal instanceof Turtle) 
		{
				return (Turtle)animal;
		}
				
		if(animal instanceof Giraffe) 
		{
			return (Giraffe)animal;
		}
		
		return null;
		
	}
	
	
	/**
	 * Checks The Type Of The animal And Calls the matching animal's eat function.
	 * @param animal-of Type Object to be casted into an animal type object.
	 * @param food-of type IEdible ,checks if animal's can eat the given food
	 * @return the Weight Animal Gained Throughout Eating.
	 */
	public static boolean eat(Object animal, IEdible food)
	{
		Animal animals=getType(animal);
		if(getType(animal)!=null)
		{
			if(((Animal)animal).getDiet().canEat(food.getFoodtype()))
			{
				animals.getDiet().eat((Animal)animal, food);
				MessageUtility.logBooleanFunction(((Animal)animal).getName(), "eat", food, true);
				return true;
			}
			MessageUtility.logBooleanFunction(((Animal)animal).getName(), "eat", food, false);
			return false;
		}
		return false;
	}
	
	
	
	/**
	 * Reads Input From User And Calls The Appropriate Animal's Constructor.
	 * @return List Of Type Animal
	 * 
	 */
	public static List initAnimalsArray() {
		
		String size,x=null,y=null,name=null,furColor=null;
		int size1,x1,y1;
		Scanner sc=new Scanner(System.in);
		String animal;
		boolean valid=false,valid1=false,valid2=false;
		List<Animal> animals=new ArrayList();
		
		while(valid==false) {
			System.out.println("Please Enter Array Size , Array Size Must Be At Least 3:");
			size=sc.nextLine();
			try {
					size1=Integer.parseInt(size);
					if(size1>=3)
					{
						for(int i=0;i<size1;++i)
						{
							System.out.println("Please Select Animal Type:");
							animal=sc.nextLine();
							System.out.println("Please Enter Animal Name:");
							name=sc.nextLine();
							
							
							if(animal.equals("Bear"))
							{
								
								System.out.println("Please Enter Location , If Not Enter x=-1, y=-1:");
								x=sc.nextLine();
								y=sc.nextLine();
								if(checkInput(x,y))
								{
									Point point=new Point(Integer.parseInt(x),Integer.parseInt(y));
									if(point.checkBoundries(point)||(point.getX()==-1 && point.getY()==-1))
									{
									System.out.println("Please Enter Fur Color, If Not Enter 'No' ");
									furColor=sc.nextLine();
									if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1 && furColor.equals("No")==false) 
									{
										Bear bear=new Bear(name,new Point(Integer.parseInt(x),Integer.parseInt(y)),furColor);
										animals.add(bear);
									}
									else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1 && furColor.equals("No")==false)
									{
										Bear bear=new Bear(name,furColor);
										animals.add(bear);
										
										
									}
									else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1 && furColor.equals("No")==true) 
									{
										Bear bear=new Bear(name);
										animals.add(bear);
										
												
									}
									}
									
								
								}
							}
							
							else if(animal.equals("Lion")) 
							{
							System.out.println("Please Enter Location , If Not Enter x=-1 ,y=-1:");
							x=sc.nextLine();
							y=sc.nextLine();
							if(checkInput(x,y))
							{
								Point point=new Point(Integer.parseInt(x),Integer.parseInt(y));
								if(point.checkBoundries(point)||(point.getX()==-1 && point.getY()==-1))
								{
								if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1)
								{
									Lion lion=new Lion(name,new Point(Integer.parseInt(x),Integer.parseInt(y)));
									animals.add(lion);
								}
								else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))<-1)
								{
									System.out.println("Invalid Values!");
								}
								else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1)
								{
									Lion lion=new Lion(name);
									animals.add(lion);
									
								}
							}
							}	
							}
								else if(animal.equals("Elephant"))
								{
									System.out.println("Please Enter Location , If Not Enter x=-1 ,y=-1:");
									x=sc.nextLine();
									y=sc.nextLine();
									if(checkInput(x,y))
									{
										Point point=new Point(Integer.parseInt(x),Integer.parseInt(y));
										if(point.checkBoundries(point)||(point.getX()==-1 && point.getY()==-1))
										{
										if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1)
										{
											Elephant elephant=new Elephant(name,new Point(Integer.parseInt(x),Integer.parseInt(y)));
											animals.add(elephant);
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))<-1)
										{
											System.out.println("Invalid Values!");
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1)
										{
											Elephant elephant=new Elephant(name);
											animals.add(elephant);
											
										}
									}
									}
									
								}
								else if(animal.equals("Giraffe"))
								{
									System.out.println("Please Enter Location , If Not Enter x=-1 ,y=-1:");
									x=sc.nextLine();
									y=sc.nextLine();
									if(checkInput(x,y))
									{
										Point point=new Point(Integer.parseInt(x),Integer.parseInt(y));
										if(point.checkBoundries(point)||(point.getX()==-1 && point.getY()==-1))
										{
										if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1)
										{
											Giraffe giraffe=new Giraffe(name,new Point(Integer.parseInt(x),Integer.parseInt(y)));
											animals.add(giraffe);
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))<-1)
										{
											System.out.println("Invalid Values!");
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1)
										{
											Giraffe giraffe=new Giraffe(name);
											animals.add(giraffe);
										}
									}
									}
									
								}
								else if(animal.equals("Turtle"))
								{
									System.out.println("Please Enter Location , If Not Enter x=-1 ,y=-1:");
									x=sc.nextLine();
									y=sc.nextLine();
									if(checkInput(x,y))
									{
										
										Point point=new Point(Integer.parseInt(x),Integer.parseInt(y));
										if(point.checkBoundries(point)||(point.getX()==-1 && point.getY()==-1))
										{
										
										if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1)
										{
											Turtle turtle=new Turtle(name,new Point(Integer.parseInt(x),Integer.parseInt(y)));
											animals.add(turtle);
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))<-1)
										{
											System.out.println("Invalid Values!");
										}
										else if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))==-1)
										{
											Turtle turtle=new Turtle (name);
											animals.add(turtle);
										}
									}
										
									}
									
								}
							
						}
						
						valid=true;
					}
					
				}catch(NumberFormatException e) {
					System.out.println("Error-Please Enter A Valid Value!");
					
				}
		}
		return animals;
	}
	
	/**
	 * Moves The Given Animal According To the Point Object Given.
	 * @param animal-of type Object And Cast it To Animal Type.
	 * @param point-Of type Point ,Moves The Animal According To the Given Point Values.
	 * @return true if point value is legal and Object animal can be casted into animal, else false.
	 */
	public static boolean move(Object animal,Point point) {
		Point p1=new Point(0,0);
		if(p1.checkBoundries(point)) {
			if(getType(animal)!=null)
				((Animal) animal).move(point);
				MessageUtility.logBooleanFunction(((Animal)animal).getName(), "move", point, true);
				return true;
			}
		MessageUtility.logBooleanFunction(((Animal)animal).getName(), "move", point, false);
		return false;
		
	}
	
	/**
	 * Private Service Method tries To Convert string Values into An Integer Values.
	 * @param x-x coordinate 
	 * @param y-coordinate
	 * @return true if conversion succeeded, else false.
	 */
	private static boolean checkInput(String x,String y) 
	{
		boolean valid=false;
		int x1,y1;
		Scanner sc=new Scanner(System.in);
		while(valid==false)
		{
			try {
					x1=Integer.parseInt(x);
					y1=Integer.parseInt(y);
					valid=true;
					return true;
				}
			catch(NumberFormatException e)
			{
					System.out.println("Error-Please Enter A Valid Value!");
					return false;
			}
		
		}
		return false;
	}
	
	/**
	 * Private Service Method, Checks If Point Coordinate has Been Inserted Or Legal.
	 * @param x-x coordinate
	 * @param y-y coordinate
	 * @return -1 if no Point coordinates has been inserted, -2 if Illegal values has been inserted.
	 */
	private static int checkConstructor(int x,int y)
	{
		
			if(x==-1 && y==-1)
			{
				return -1;
		    }
			if(x<-1 || y<-1)
			{
				System.out.println("Point Values Out Of Borders");
				return -2;
			}
				
		return 0;
	}
	/**
	 * Simulating movements on Animals In The zoo.
	 * @param animals-List Of type Animal That contains User's Animal input.
	 */
	public static void moveSimulation(List<Animal> animals)
	{
		Scanner sc=new Scanner(System.in);
		String x,y;
		for(int i=0;i<animals.size();++i)
		{
			System.out.println("Please Enter Point:");
			x=sc.next();
			y=sc.next();
			if(checkInput(x,y))
			{
				if(checkConstructor(Integer.parseInt(x),Integer.parseInt(y))>-1) {
					Point p=new Point(Integer.parseInt(x),Integer.parseInt(y));
					move(animals.get(i),p);
				}
				else
					move(animals.get(i),animals.get(i).getLocation());
				
			}
		}
		
		
	}
	
	
	/**
	 * Lotters Two Animals Randomly each time And Calls eat Function.
	 *  @param animals-List Of type Animal That contains User's Animal input.
	 */
	public static void lottery(List<Animal> animals)
	{
		
		Random rand=new Random();
		for (int j=0;j<animals.size()/2;++j)
		{
			
			for(int i=0;i<2;++i)
			{
				int index=rand.nextInt(0,animals.size());
				eat(animals.get(index),animals.get(rand.nextInt(0,animals.size())));
				
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		List<Animal> animals=initAnimalsArray();
		moveSimulation(animals);
		lottery(animals);
		
		
			
	}
}

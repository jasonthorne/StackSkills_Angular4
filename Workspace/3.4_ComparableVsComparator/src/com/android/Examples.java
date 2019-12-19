package com.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class Examples {
	
	/*
	 * The comparable interface as one method 
	 * compareTo()
	 * Here we will be implementing the comparable interface 
	 * and overriding the compareTo() method. 
	 * comparable interface looks like: 
	 * interface Comparable<T>{
	 * 		int compareTo(T arg)
	 * }
	 * 
	 * Comparable is a functional interface, so we can create lambdas from this interface. 
	 * Comparator is a SEPERATE interface and has a COMPARE() METHOD
	 * 
	 * To explain how compareTo works, we will give the example of the String class. 
	 * String class implements the comparable interface.
	 * 
	 * Say we are calling the following:
	 * str1.compareTo(str2)
	 * 
	 * compareTo returns:
	 * + 0 if both are the same string. 
	 * eg: "apple".compareTo("apple");
	 * + a negative number if the string calling the method comes BEFORE the string senrt to the method. 
	 * eg: "apple".compareTo("berry");
	 * + a positive number if the string calling the method comes AFTER the string sent to the method. 
	 * eg: "berry".compareTo("apple");
	 * 
	 * Objects whose class implements Comparable can be used by ALL collection class and Maps to arrange the order of objects in any collection. 
	 * These objects are also the only objects that can be inserted into a TreeSet and the only objects that can be a key in a treeMap.
	 */
	
	static void ex1() {
		System.out.println("ex1:");
		
		//COMPARETO ++++++++++++++++++
		
		System.out.println("strings");
	
		System.out.println("adam".compareTo("betty")); //negative number (number returned is the difference between them)
		System.out.println("betty".compareTo("adam")); //positive number (number returned is the difference between them)
		System.out.println("betty".compareTo("betty")); // returns 0

		System.out.println("adam".compareTo("Zee")); //returns a positive number, as Capital Z comes before lower case a
		
		/*
		 * Can't use null with compateTo, as null has no value, and you cant compare nothing with something. 
		 * If you cant use null with compareTo, that means you cant add null to a TreeSet or as a key in a TreeMap. 
		 */
		Set<Integer>mySet=new TreeSet<>();
		
		//Integers NOT ints: 
		Integer one = 1;
		Integer two = 2;
		Integer twentyTwo = 22;
		Integer minusFive = -5;
		
		//Just gives a -1,0 or 1, NOT the amount of difference between them.
		System.out.println(one.compareTo(two)); // -1
		System.out.println(twentyTwo.compareTo(one)); //1
		System.out.println(twentyTwo.compareTo(minusFive)); //1
		System.out.println(one.compareTo(one)); //0
		
	}
	
	
	static void ex2() {
		System.out.println("ex2:");
		
		System.out.println("Rat class implements comparable");
		
		Rat rat = new Rat("rory", 3, 12.4); // - 4th in
		Rat rat2 = new Rat("rory", 3, 11.4); // - 3rd in
		Rat rat3 = new Rat("rory", 2, 12.4); //different age - 2nd in
		Rat rat4 = new Rat("angela", 3, 13.4); //different name - 1st in
		Rat rat5 = new Rat("angela", 3, 13.4); //different name //not put in as same as 1st
		
		Set<Rat>ratTree=new TreeSet<>();
		ratTree.addAll(Arrays.asList(rat,rat2,rat3,rat4,rat5));
		
		System.out.println(ratTree);
		
	}
	
	
	static void ex3() {
		System.out.println("ex3:");
		
		//COMPARATORS: +++++++++++++++++++++++++++++++++++
		
		/*
		 * comparators are used for organising list, sets & hashmaps.
		
		 * A Treeset is an ordered list that doesnt allow duplicates. 
		 * Its ordered by only allowing objects that implement the COMPARABLE interface 
		 * 
		 * TreeMap: the keys are an ordered list that doesnt allow duplicates. 
		 * The keys are ordered by only allowing objects that implement the comparable interface. 
		 */
		
		List<Integer>listNum=new ArrayList<>();
		listNum.addAll(Arrays.asList(23,23,23,4,1,67,3,3,1002,-56,0)); //unordered list
		
		Set<Integer>mySet = new TreeSet<>(); //treeset
		mySet.addAll(listNum); //add unordered list to treeSet to order them.
	
		System.out.println(mySet); //show ordered list
		
		/*
		 * As well as using the comparable interface, we could also use a seperate object of type Comparator to organise a list, set, map or queue
		 * NOT a treeSet or TreeMap. By using this a list of objects doesnt need to implement comparable interface. 
		 * 
		 * It looks like the following:
		 * 
		 * interface Comparator<T>{
		 * 		public compare(T t, T t2){
		 * 			
		 * 		}
		 * }
		 * 
		 * comparaABLE has a compareTO method. ComparaTOR has a COMPARE method. 
		 * 
		 * Classes usually do NOT implement Comparator
		 * 
		 * More often than not, you use this by creating an anonymous inner class for a lambda, 
		 * as this is a functional interface (only one abstract method)
		 */
		//-------------------------------------------------
		//ANONYMOUS CLASS IMPLEMENTATION OF COMPATATOR:
		
		/*
		 * This is going to be used to organise a list of names alphabetically (ignoring case)
		 */
		Comparator<String>byString= new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
			
		};
		
		System.out.println("List of strings");
		List<String>names=new ArrayList<>();
		names.addAll(Arrays.asList("bernie", "ann", "Ann", "adam", "Aidan", "bernie", "Ciara", "Siobhan", "mick", "shelly", "Laura", "COLM"));
				
		
		System.out.println(names);
		
		/*
		 * ONLY objects that implement Comparable can use the .sort method below. 
		 * String class does implement comparable and the compareTO method compares:
		 * symbols > numbers > uppercase > lowercase
		 */
		Collections.sort(names); 
		//names is now sorted according to the rules of the compareTo method of the String class.
		System.out.println(names); //THIS WILL ADD DUPLICATES +++++++++++++++++++++++++++++++++++++++++++++
		names.clear(); //reset names
		
		//adding original strings again
		names.addAll(Arrays.asList("bernie", "ann", "Ann", "adam", "Aidan", "bernie", "Ciara", "Siobhan", "mick", "shelly", "Laura", "COLM"));
		System.out.println(names);
		
		//OVERRIDEN COLLECTIONS.SORT METHOD - takes our comparator object made above.
		Collections.sort(names, byString);
		System.out.println(names);
		
		//==================================
		//SQUIRREL:
		
		Squirrel sammy=new Squirrel("sammy", 2, 3);
		Squirrel sharon=new Squirrel("sharon", 4, 2);
		Squirrel samantha=new Squirrel("samantha", 1, 5);
		Squirrel sean=new Squirrel("sean", 7, 1);
		//Squirrel sean2=new Squirrel("sean", 7, 1);
		
		//list of squirrels:
		List<Squirrel>squirrels =new ArrayList<>();
		squirrels.addAll(Arrays.asList(sammy, sharon, samantha, sean )); //sean2));
		System.out.println("squirrel list unordered: " + squirrels);
		//squirrels sorted by name uses the compareTo in the squirrel class/
		
		/*
		 * Collections.sort only takes a list of objects whose classes implement comparable
		 * Squirrel implements comparable and the compareTo organises squirrels in a list by names in alphabetical order. 
		 * SORTING DOES NOT REMOVE DUPLICATES +++
		 */
		Collections.sort(squirrels);
		
		
	}
	
	 
	static void ex4() {
		System.out.println("ex4:");
		
		//------------------
		
		/*
		 * We will have a list of ducks that we will sort by name
		 * then by weight
		 * then by height
		 * then by id
		 * Duck class will NOT implement Comparable
		 */
		
		Comparator<Duck>comparatorDuck=new Comparator<Duck>(){

			/*takes in 2 ducks, gets the weight of both of them 
			then use the compareTO method of the integer class
			*/
			@Override
			public int compare(Duck d1, Duck d2) {
				Integer duck1W = d1.getWeight();
				Integer duck2W = d2.getWeight();
				return duck1W.compareTo(duck2W);
			}	
		};
		
		//make ducks
		Duck duck1 = new Duck("daffy", 2, 10);
		Duck duck2 = new Duck("donald", 1, 11);
		Duck duck3 = new Duck("daisy", 345, 12);
		Duck duck4 = new Duck("andy", 7, 14);
		Duck duck5 = new Duck("donna", 4, 15);
		
		//make list of ducks:
		List<Duck>ducks = new ArrayList<>();
		ducks.addAll(Arrays.asList(duck1, duck2, duck3, duck4, duck5));
		
		System.out.println(ducks);
		
		
		//THis WONT COMPILE as duck doesnt implement comparable. ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//Collections.Sort method only works for objects thst implement comparable
		//Collections.sort(ducks); 
		
		//this will work though, as it takes our duck comparator made above:
		Collections.sort(ducks, comparatorDuck);
		System.out.println("ducks sorted by weight: " + ducks); //sorted ducks list. organised by weight as per the comparator. 
		
		//--------------
		
		//another comparator:
		//this comparator will compare by names of the duck in alphabetical order (including case)
		Comparator<Duck>byDuckName=new Comparator<Duck>() {

			@Override
			public int compare(Duck d1, Duck d2) {
				return d1.getName().compareTo(d2.getName());
			}
		};
		
		ducks.clear();
		ducks.addAll(Arrays.asList(duck1, duck2, duck3, duck4, duck5));
		
		Collections.sort(ducks, byDuckName);
		System.out.println("ducks sorted by name: " + ducks); //ducks sorted by name
		
		//--------------------
		
		//another comparator:
		//this comparator will compare by names of the duck in alphabetical order (including case)
		
		/*
		 * compares by: String name > int weight > int height > int id
		 */
		Comparator<Duck>comparatorDuck2=new Comparator<Duck>() {

			@Override
			public int compare(Duck d1, Duck d2) {
				Integer weight1 = d1.getWeight();
				Integer weight2 = d2.getWeight();
				
				Integer height1 = d1.getHeight();
				Integer height2 = d2.getHeight();
				
				Integer id1 = d1.getId();
				Integer id2 = d2.getId();
				
				if(d1.equals(d2)) //equals method has been overriden in the duck class
					return 0;
				
				if(!(d1.getName().equals(d2.getName()))) //if names arent the same
					return d1.getName().compareTo(d2.getName()); //use compare method to sort them out! 
				
				if(!(weight1.equals(weight2))) //if weights arent the same
					return weight1.compareTo(weight2); //use compare method to sort them out! 
				
				if(!(height1.equals(height2))) //if heights arent the same
					return height1.compareTo(height2); //use compare method to sort them out! 
				
				//above checks mean they have to not have the same ids!
				return id1.compareTo(id2);
			}
		};
				
		
	
	}
	
	
	
	
	
	
	
	
}

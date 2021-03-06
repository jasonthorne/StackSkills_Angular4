package com.android.generics;

import java.util.Arrays;
import java.util.List;

/*
T is a generic , so when we ceeate a crate, we can supply it with a type for t, if we dont then it will be of type object.
Crate<String>myCrate;
that means that type T becomes a String
A generic can ONLY be an OBJECT not a primitive. +++++++++++
T can be ANY object of ANY type.
*/

public class Crate<T> {
	
	private T contents;
	
	//default constructor:
	public Crate() {
		/*
		 * if you create a Crate object with this constructor, 
		 * and you attempt to call ANY method using the variable "contents" you will get a null pointer exception,
		 * because we have not set the value of T, so it will b given a default value of null. 
		 */
		//contents.getClass(); //this will cause the exception mentioned above.
	}
	
	public Crate(T contents){
		this.contents = contents;
		System.out.println("crate created with a " + contents.getClass().getSimpleName());
	}
	
	/*
	 * We cant do below, as T could be of ANY type of object, which may or may not have a constructor that takes no arguments. 
	 * We cant make any assumptions about this generic type.
	 */
	//private T contents = new T();
	

	/*
	 * You can use the generic type in methods and constructors.
	 *Below is going to return an elephant. - NO IT DOESNT. IGNORE THIS METHOD FOR NOW :P
	 */
	public void returnMe(T myT) {
		contents = myT;
		
		/*
		 * This calls the toString method of whatever class we have said our generic is
		 * IE we create Crate<Elephant>crateElephant
		 */
		//System.out.println(contents.getClass().getSimpleName());
		System.out.println(contents);
		
		/**
		 * IF your generic can be any object, 
		 * that means you can then only have access to methods that are common to ALL OBJECTS, 
		 * which are methods of the object class.
		 * So this type of generic:
		 * public class Crate<T>{}
		 * only has access to methods of the object class (TpoSTring, hashCode, equals etc)
		 */
		
		//myT.eat() //no access to this, as this is ONLY avaliable to Animals and their subclasses
		
	}

}





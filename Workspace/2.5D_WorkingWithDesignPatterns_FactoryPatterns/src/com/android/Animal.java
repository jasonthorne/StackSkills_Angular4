package com.android;

/*
 * This is going to be used when using the factory pattern with classes
 */

public abstract class Animal {

}

abstract class Carnivor extends Animal{
	
}

class Lion extends Animal{
	
}

abstract class Bear extends Carnivor{
	
}


class PolarBear extends Bear{
	
}


abstract class Herbivore extends Animal{
	
}


class Rabbit extends Herbivore{
	
}

class Zebra extends Herbivore{
	
}

class Goat extends Herbivore{
	
}
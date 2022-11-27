package com.example.demo;
/**
 * Class is used as a part of the implementation of the Observer pattern that is to be used to update classes when the Easter egg is activated.
 */
public abstract class Observer {
    /**
     * Method that is used in changing the state of the Easter egg activation in each of the respective classes that implement this method.
     * @param state The state of the Easter Egg activation based on the status in Main.
     */
    public abstract void update(boolean state);
}

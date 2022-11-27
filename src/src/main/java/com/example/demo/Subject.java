package com.example.demo;

import java.util.ArrayList;
import java.util.List;
/**
 * Class used in implementing the observer pattern. Main reason as to why the pattern was implemented in the first place
 * is so that classes may be notified of the activation of the Easter egg.
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    /**
     * Method that goes through the list of available observers at the time that it is called and activates their update method when an event occurs.
     * @param state <code>true</code> means that the Easter egg has been activated.
     *              <code>false</code> means that the Eater egg has not been activated.
     */
    public void notifyAllObservers(boolean state){
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
    /**
     * Method used in adding observers to the list of observers to be updated.
     * @param observer The class that is to be added to the list of observers. Note: class MUST inherit the "Observer" class.
     */
    public void attach(Observer observer){
        observers.add(observer);
    }
}

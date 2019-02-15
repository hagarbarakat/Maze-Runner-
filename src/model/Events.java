package model;

import java.util.ArrayList;
import java.util.List;


public class Events implements Subject {




    private List<Observer> observerList;

    public Events() {
        
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers(Type type) {
        for(Observer observer: observerList) {
            if(observer instanceof Health)
            {
                observer.update(type);
            }
            else if (observer instanceof Score)
            {
                observer.update(type);

            }
            else if (observer instanceof Bullet)
            {
                observer.update(type);

            }
        }
    }


    public void setUpdate(Type type) {
    	notifyAllObservers(type);
    }
}

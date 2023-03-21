package model;

import java.util.ArrayList;
import java.util.List;

public class MyArray implements Subject {
    private ICreateArray createArray;
    private int [][] myArray;
    private List<Observer> observers;
    
    
    public MyArray(ICreateArray createArray) {
        this.createArray = createArray;
        this.myArray = createArray.createArr();
        observers = new ArrayList<Observer>();
    }
    public void setCreateArray(ICreateArray createArray) {
        this.createArray = createArray;
    }

    public void add(int number) {
        notifyObservers();
    }

    public void remove(int index) {
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public int[][] getArray() {
        return myArray;
    }
}


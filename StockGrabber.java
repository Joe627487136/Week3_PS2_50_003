package Week3;

import java.util.ArrayList;

//Uses the Subject interface to update all Observers

public class StockGrabber implements iSubject {
	
	private ArrayList<Observer> observers;
	private double[] price;
	
	public StockGrabber(){
		
		// Creates an ArrayList to hold all observers
		
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer newObserver) {
		
		// Adds a new observer to the ArrayList
		
		observers.add(newObserver);
		
	}

	public void unregister(Observer deleteObserver) {
		
		// Get the index of the observer to delete
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		// Print out message (Have to increment index to match)
		
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		
		// Removes observer from the ArrayList
		
		observers.remove(observerIndex);
		
	}

	public void notifyObserver() {
		
		// Cycle through all observers and notifies them of
		// price changes
		for(Observer observer : observers){
			observer.update(getPrice(observer,price));
			
		}
	}
	private double[] getPrice (Observer observer, double[] price) {
		int[] interest = observer.getInterest();
		double[] newprice = new double[interest.length];

		for (int i = 0; i < interest.length; i++) {
			newprice[i] = price[interest[i]];
		}

		return newprice;
	}
	
	// Change prices for all stocks and notifies observers of changes

	public void setPrice(double p, int i){
		price[i] = p;
		notifyObserver();
	}
}

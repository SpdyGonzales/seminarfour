package se.kth.ict.nextgenpos.view;

import java.awt.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.controller.SpecificationUnknownException;


/**
 * A placeholder for the view.
 */
public class View implements Observer, Container{
	private Controller cont;
	ArrayList<String> listPrint = new ArrayList<String>();

	/**
	 * Creates a new <code>View</code>.
	 * 
	 * @param cont
	 *            The controller of the application.
	 */
	public View(Controller cont) {
		this.cont = cont;
	}

	/**
	 * Simulates a view. Makes some calls to the controller.
	 */
	public void test() {
		/**
		 * Adding view to list of observers in sale
		 */
		cont.makeNewSale();
		
		/**
		 * Sets observer passed to controller. Controller is passing it to sale.
		 * @param Observer in this case this as in the view
		 */
		cont.setObserver(this);
		enterItem(1);
		enterItem(2);
		enterItem(3);
		enterItem(10);
	}

	private void enterItem(int itemId) {
		try{
			int quantity = 1;
			System.out.println("");
			System.out.println("\nLatest Result for Entered Item " + itemId + ": " +	cont.enterItem(itemId, quantity));
			System.out.println("");
			
		}catch(SpecificationUnknownException nonExist){
			System.out.println(nonExist.getMessage());
		}
	}
	
	/**
	 * update gets the object from notifyObservers parameter and adds it to a list of strings
	 * String is then printed to the user. Object is casted as string
	 * @param observable is the class being observed and arg is the object being passed from notifyObservers in sale
	 */

	@Override
	public void update(Observable o, Object arg) {
		listPrint.add((String) arg);
		for(Iterator iter = getIterator(); iter.hasNext();){
			String name = (String) iter.next();
			System.out.println("Item: " + name);
		}
		}
		
	/**
	 * setting up iterator to print out the list in order. incrementing the list if it's not
	 * in the end of the array list.
	 */
	@Override
	public Iterator getIterator(){
		
		return new ViewIterator();
		
	}
	private class ViewIterator implements Iterator{
		int i;
		
		@Override
		public boolean hasNext(){
			if(i<listPrint.size()){
				return true;
			}
			return false;
		}
		
		@Override
		public Object next(){
			if(this.hasNext()){
				Object c = listPrint.get(i);
				i++;		
				return c;
			}
			return null;
		}
	}
		
}

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
public class View implements Observer{
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
			System.out.println("\nResult for item " + itemId + ": " +	cont.enterItem(itemId, quantity));
			System.out.println("");
			
		}catch(SpecificationUnknownException nonExist){
			System.out.println(nonExist.getMessage());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		listPrint.add((String) arg);
		for(String strings : listPrint){
			System.out.println(strings);
		}
		
	}
}

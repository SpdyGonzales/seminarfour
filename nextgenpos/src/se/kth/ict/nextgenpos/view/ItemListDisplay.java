package se.kth.ict.nextgenpos.view;

import java.util.List;

public class ItemListDisplay {
	private List<String> listPrint;
	
	ItemListDisplay(){
		
	}

	
	public void addItem(String item){
		listPrint.add(item);
		System.out.println(listPrint);
		
	}
}

package se.kth.ict.nextgenpos.model;

import java.util.Map;
import java.util.HashMap;

/**
 * This class is responsible for all access to the product database.
 */
public class ProductCatalog {
	private Map<Integer, ProductSpecification> products = new HashMap<Integer, ProductSpecification>();

	/**
	 * Fills the catalog with some dummy items.
	 */
	public ProductCatalog() {
		products.put(1, new ProductSpecification(1, "low fat milk",
				"a very long description, a very long description, a very long description", 10));
		products.put(2, new ProductSpecification(2, "butter",
				"a very long description, a very long description, a very long description", 10));
		products.put(3, new ProductSpecification(3, "bread",
				"a very long description, a very long description, a very long description", 10));
	}

	/**
	 * Search for an item in the product catalog.
	 *
	 * @param itemId
	 *            The item to look for
	 * @return The specification for the found item or null if no item was
	 *         found.
	 */

	public ProductSpecification findSpecification(int itemId) throws NonExistingItemException {
		if(products.get(itemId) == null){
			throw new NonExistingItemException("User input item: " + itemId + " did not exist");
		}
		return products.get(itemId);
	}
}

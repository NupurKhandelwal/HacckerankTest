package hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	private final HashMap<Furniture,Integer>furniture;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    	 furniture = new HashMap<Furniture,Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
      int count =0;
      if (furniture.containsKey(type))
      {
    	  count = furniture.get(type);
      }
      furniture.put(type,(count+furnitureCount));
    }
  

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture,Integer>(furniture);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	float sum=0.0f;
    	if (!furniture.isEmpty())
    	{
    		Set<Entry<Furniture, Integer>> es= furniture.entrySet();
    		Iterator<Entry<Furniture, Integer>> itr= es.iterator();
    		while(itr.hasNext()) {
    			Map.Entry<Furniture, Integer> me= (Map.Entry<Furniture,Integer>)itr.next();
    			
    			sum= sum+ (float)(me.getKey().cost()*me.getValue());
    			
    		}
    		return sum;
    		
    		
    		
    	}
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if (furniture.containsKey(type))
    	{
    		return furniture.get(type);
    	}
    	 return 0;
       
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	if (furniture.containsKey(type))
    	{
    		return (furniture.get(type)* type.cost());
    	}
    	
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    
    	if (!furniture.isEmpty())
    	{
    		 return furniture.values().stream().reduce(Integer::sum).get();
    		
    		}
    		
    	
        return 0;
    }
}
package shopping_cart;

import java.util.ArrayList;

/**
 * Created by Ben on 4/21/2017.
 */
public class DataController {

    ArrayList<String> groceryStore;


    DataController() {
        groceryStore = new ArrayList<>();
    }

    public boolean saveGroceryStore(String cart) {



        return true;
    }

    public boolean addCart(String cart) {
        try {
            groceryStore.add(cart);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String analyzeStore () {
        //Weka.createARFF(groceryStore);
        String results = Weka.getStatistics();
        return results;
    }

}

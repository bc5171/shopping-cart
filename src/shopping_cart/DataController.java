package shopping_cart;

import org.omg.CORBA.SystemException;

import java.util.ArrayList;

/**
 * Created by Ben on 4/21/2017.
 */
public class DataController {

    ArrayList<String> groceryStore;

    DataController() {
        groceryStore = new ArrayList<>();
    }

    public boolean saveGroceryStore() {



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

}

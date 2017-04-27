package shopping_cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;

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

    public String analyzeStoreStatistics () {
        //Weka.createARFF(groceryStore);
        String results = Weka.getStatistics();
        return results;
    }

    public ObservableList<String> getAssociationRules () {
        ObservableList<String> data = FXCollections.observableArrayList();

        AssociationRules ar = Weka.computeApriori();

        for (AssociationRule r : ar.getRules()) {
            String s = r.getPremise().toString();

            s = s.replaceAll("[ =]","");
            s = s.substring(1);
            s = s.substring(0,s.length()-1);
            String[] str = s.split(",");

            String temp = "When an item in the ";
            boolean firstTime = true;
            for (int x = 0; x < str.length; x++) {

                if (str[x].substring(str[x].length()-1).equals("f") && firstTime) {
                    temp = temp + str[x].substring(0,str[x].length()-1);
                    temp = temp + " category is purchased,";
                } else if (firstTime){
                    temp = temp + str[x].substring(0,str[x].length()-1);
                    temp = temp + " category is purchased,";
                } else if (!firstTime && str[x].substring(str[x].length()-1).equals("f")) {
                    temp = temp + " and an item in the " + str[x].substring(0,str[x].length()-1);
                    temp = temp + " category is not purchased,";
                } else {
                    temp = temp + " and an item in the " + str[x].substring(0,str[x].length()-1);
                    temp = temp + " category is purchased,";
                }

                firstTime = false;
            }

            s = r.getConsequence().toString();
            s = s.replaceAll("[ =]","");
            s = s.substring(1);
            s = s.substring(0,s.length()-1);
            temp = temp + " then an item in the " + s.substring(0,s.length()-1);

            if (s.substring(s.length()-1).equals("f")) {
                temp = temp + " category is most likely to not be purchased.";
            } else {
                temp = temp + " category is most likely to be purchased.";
            }
            data.add(temp);
        }


        return data;
    }

}

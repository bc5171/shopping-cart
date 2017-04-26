package shopping_cart;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import weka.associations.Apriori;
import weka.associations.AssociationRules;
import weka.core.Instances;

/**
 * Created by Ben on 4/20/2017.
 */
public class Weka {

    public static String getStatistics() {
        try {
            // Load the data
            BufferedReader reader = new BufferedReader(
                    new FileReader("grocery-store.arff")
            );
            Instances data = new Instances(reader);
            reader.close();
            data.setClassIndex(data.numAttributes() - 1);

            // Build associator
            Apriori apriori = new Apriori();
            apriori.setClassIndex(data.classIndex());
            try {
                apriori.buildAssociations(data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //System.out.println(apriori);
            return (apriori.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static boolean createARFF(ArrayList<String> groceryStore) {

        // Let's create an arraylist to store all of this crap in
        ArrayList<String> data = new ArrayList<String>();

        // First line is always the title of the arff file
        data.add("@relation grocery-store");
        //

        // Next few lines are where we list our attributes
        data.add("@attribute Beverage {t, f}");
        data.add("@attribute BreadBakery {t, f}");
        data.add("@attribute CannedJarredGoods {t, f}");
        data.add("@attribute Cleaners {t, f}");
        data.add("@attribute Dairy {t, f}");
        data.add("@attribute DryBakingGoods {t, f}");
        data.add("@attribute FrozenFoods {t, f}");
        data.add("@attribute Meat {t, f}");
        data.add("@attribute Other {t, f}");
        data.add("@attribute PaperGoods {t, f}");
        data.add("@attribute PersonalCare {t, f}");
        data.add("@attribute Produce {t, f}");

        data.add("@data");

        // Now let's build out our data
        for (String s : groceryStore) {
            data.add(s);
        }


        try {
            // Specify the file path here
            PrintWriter writer = new PrintWriter("grocery-store.arff", "UTF-8");

            for (String s : data) {
                writer.println(s);
            }

            writer.close();
            System.out.println("\nARFF FILE SUCCESSFULLY CREATED\n");

        }
        catch (IOException ex) {
            Alerts alert = new Alerts();
            System.out.println("arffAlertMessage");
            alert.arffAlertMessage();
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public static AssociationRules computeApriori() {

        try {
            // Load the data
            BufferedReader reader = new BufferedReader(
                    new FileReader("grocery-store.arff")
            );
            Instances data = new Instances(reader);
            reader.close();
            data.setClassIndex(data.numAttributes() - 1);

            // Build associator
            Apriori apriori = new Apriori();
            apriori.setClassIndex(data.classIndex());
            try {
                apriori.buildAssociations(data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //System.out.println(apriori);
            AssociationRules ar = apriori.getAssociationRules();
            return ar;

        } catch (IOException ex) {
            // TODO add alert later
            ex.printStackTrace();
        }

        return null;

    }

}

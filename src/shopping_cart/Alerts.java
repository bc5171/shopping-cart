package shopping_cart;

import javafx.scene.control.Alert;

/**
 * Created by Ben on 4/20/2017.
 */
public class Alerts {

    public void aboutAlertMessage () {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Us");
        alert.setHeaderText("Shopping Cart Application");
        alert.setContentText("This is the shopping cart application. The application" +
                " allows the user to create multiple \"shopping carts\" full of items" +
                ". Those items are then analyzed using the Apriori Algorithm from Weka." +
                " The association rules from this are then given back to the user.");
        alert.showAndWait();
    }

}

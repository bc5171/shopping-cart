package shopping_cart;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import shopping_cart.Alerts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;

/**
 * Created by Ben on 4/19/2017.
 */
public class Controller implements Initializable {

    @FXML CheckBox cbBeverage;
    @FXML CheckBox cbDairy;
    @FXML CheckBox cbBreadBakery;
    @FXML CheckBox cbProduce;
    @FXML CheckBox cbCannedJarredGoods;
    @FXML CheckBox cbPersonalCare;
    @FXML CheckBox cbCleaners;
    @FXML CheckBox cbDryBakingGoods;
    @FXML CheckBox cbMeat;
    @FXML CheckBox cbPaperGoods;
    @FXML CheckBox cbFrozenFoods;
    @FXML CheckBox cbOther;
    @FXML Label lblTotalCategories;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
        lblTotalCategories.setText("0");
    }

    @FXML
    public void handleExitAction(final ActionEvent event) {
        System.out.println("Exiting...");
        System.exit(0);
        Platform.exit();
    }

    @FXML
    public void handleCheckBox(final ActionEvent event) {
        int totalCategories = 0;
        if (cbBeverage.isSelected()) {
            totalCategories += 1;
        }
        if (cbBreadBakery.isSelected()){
            totalCategories += 1;
        }
        if (cbCannedJarredGoods.isSelected()){
            totalCategories += 1;
        }
        if (cbCleaners.isSelected()){
            totalCategories += 1;
        }
        if (cbDairy.isSelected()){
            totalCategories += 1;
        }
        if (cbDryBakingGoods.isSelected()){
            totalCategories += 1;
        }
        if (cbFrozenFoods.isSelected()){
            totalCategories += 1;
        }
        if (cbMeat.isSelected()){
            totalCategories += 1;
        }
        if (cbOther.isSelected()){
            totalCategories += 1;
        }
        if (cbPaperGoods.isSelected()){
            totalCategories += 1;
        }
        if (cbPersonalCare.isSelected()){
            totalCategories += 1;
        }
        if (cbProduce.isSelected()){
            totalCategories += 1;
        }
        lblTotalCategories.setText(Integer.toString(totalCategories));
    }

    @FXML
    public void handleAboutAction(final ActionEvent event) {
        provideAboutFunctionality();
    }

    @FXML
    private void handleKeyInput(final InputEvent event)
    {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
            {
                provideAboutFunctionality();
            }
        }
    }

    private void provideAboutFunctionality() {
        Alerts alert = new Alerts();
        System.out.println("handleAboutAction");
        alert.aboutAlertMessage();
    }
}

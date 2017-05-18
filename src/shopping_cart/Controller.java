package shopping_cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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

import javax.swing.*;

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
    @FXML Label lblTotalShoppingCarts;
    @FXML ListView<String> listViewAssociationRules;
    @FXML TextArea analysisTextArea;

    DataController dc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("\nLOADING USER DATA\n");
        dc = new DataController();
        lblTotalCategories.setText("0");
        lblTotalShoppingCarts.setText("0");
    }

    @FXML
    public void handleExitAction(final ActionEvent event) {
        System.out.println("EXITING...");
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
    public void handleAddCartBtn(final ActionEvent event) {
        char[] cart = new char[23];

        for(int x = 1; x < cart.length; x += 2) {
            cart[x] = ',';
        }

        for (int x = 0; x < cart.length; x += 2) {
            cart[x] = 'f';
        }

        if (cbBeverage.isSelected()) {
            cart[0] = 't';
        }
        if (cbBreadBakery.isSelected()){
            cart[2] = 't';
        }
        if (cbCannedJarredGoods.isSelected()){
            cart[4] = 't';
        }
        if (cbCleaners.isSelected()){
            cart[6] = 't';
        }
        if (cbDairy.isSelected()){
            cart[8] = 't';
        }
        if (cbDryBakingGoods.isSelected()){
            cart[10] = 't';
        }
        if (cbFrozenFoods.isSelected()){
            cart[12] = 't';
        }
        if (cbMeat.isSelected()){
            cart[14] = 't';
        }
        if (cbOther.isSelected()){
            cart[16] = 't';
        }
        if (cbPaperGoods.isSelected()){
            cart[18] = 't';
        }
        if (cbPersonalCare.isSelected()){
            cart[20] = 't';
        }
        if (cbProduce.isSelected()){
            cart[22] = 't';
        }

        String cartString = new String(cart);
        System.out.println(cartString);

        if (!dc.addCart(cartString)) {
            System.out.println("\nERROR!");
        }

        lblTotalShoppingCarts.setText(Integer.toString(dc.returnTotalCarts()));
    }

    @FXML
    public void handleWekaAnalysis(final ActionEvent event) {
        analysisTextArea.setText(dc.analyzeStoreStatistics());
        ObservableList<String> data = dc.getAssociationRules();
        listViewAssociationRules.setItems(data);
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

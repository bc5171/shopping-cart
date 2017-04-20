package shopping_cart;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading user data...");
    }

    @FXML
    public void handleExitAction(final ActionEvent event) {
        System.out.println("exiting");
        System.exit(0);
        Platform.exit();
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
        System.out.println("You clicked on About!");
    }

}

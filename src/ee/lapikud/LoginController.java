package ee.lapikud;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginController {

    @FXML public TextField server;
    @FXML public TextField username;
    private Main main;

    public void doConnect() throws IOException, URISyntaxException {
        System.out.println("Connect! "+ server.getText() + " " + username.getText());
        this.main.showChat();
        this.main.connect(new URI(server.getText()), username.getText());
    }


    public void setMain(Main main) {
        this.main = main;
    }

}

package ee.lapikud;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Chat {
    private Main main;

    @FXML private TextArea chatTextArea;
    @FXML private TextField input;

    @FXML private void onSend() {
        this.main.client.send(this.main.username + ": " + input.getText());
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void showMessage(String s) {
        chatTextArea.appendText(s+"\n");
    }
}

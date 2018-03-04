package ee.lapikud;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;

public class Main extends Application{

    @FXML private TextField server;
    @FXML private TextField username;
    @FXML public TextArea chatLog;
    private ChatClient chatClient;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        showLogin();
        stage.setTitle("Chat");
        stage.show();
    }

    public void showLogin() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
    }

    public void showChat() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
        chatClient.connect();
    }

    public void onConnect() throws Exception {
        System.out.println("Connect" + server.getText() + username.getText());
        chatClient = new ChatClient(new URI(server.getText()), this);
        this.showChat();
    }
}

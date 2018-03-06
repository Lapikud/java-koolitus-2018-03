package ee.lapikud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;

public class Main extends Application {

    private Stage primaryStage;
    public ChatController chatController;
    public Client client;
    public String username;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        loader.<LoginController>getController().setMain(this);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    public void showChat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
        Parent root = loader.load();
        this.chatController = loader.<ChatController>getController();
        this.chatController.setMain(this);
        primaryStage.setScene(new Scene(root));
    }

    public void connect(URI server, String username) {
        this.username = username;
        this.client = new Client(server, this);
        this.client.connect();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

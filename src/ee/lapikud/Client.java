package ee.lapikud;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Client extends WebSocketClient {
    private Main main;

    public Client(URI serverUri, Main main) {
        super(serverUri);
        this.main = main;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected!");
        this.main.chat.showMessage("Connected!");
    }

    @Override
    public void onMessage(String s) {
        this.main.chat.showMessage(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }
}

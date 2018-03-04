package ee.lapikud;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class ChatClient extends WebSocketClient {

    private Main main;

    public ChatClient(URI serverUri, Main main) {
        super(serverUri);
        this.main = main;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        this.main.chatLog.appendText("Connected\n");
    }

    @Override
    public void onMessage(String s) {
        this.main.chatLog.appendText(s+'\n');
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }
}

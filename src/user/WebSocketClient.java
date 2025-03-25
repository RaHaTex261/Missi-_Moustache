package user;

import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class WebSocketClient {

    private Session session;

    public WebSocketClient(String serverURI) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(this, new URI(serverURI));
    }

    // Lorsque le client est connecté au serveur
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connecté au serveur WebSocket : " + session.getId());
        this.session = session;
    }

    // Lorsque le client reçoit un message
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Message reçu : " + message);
    }

    // Lorsque le client se déconnecte
    @OnClose
    public void onClose(Session session) {
        System.out.println("Déconnecté du serveur WebSocket");
    }

    // Lorsque le client rencontre une erreur
    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // Crée les clients WebSocket dans des threads séparés
        Thread client1Thread = new Thread(() -> {
            try {
                WebSocketClient client1 = new WebSocketClient("ws://localhost:8080/chat");
                // Attend que la connexion soit établie avant d'envoyer un message
                Thread.sleep(1000); 
                client1.sendMessage("Bonjour, je suis l'utilisateur 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread client2Thread = new Thread(() -> {
            try {
                WebSocketClient client2 = new WebSocketClient("ws://localhost:8080/chat");
                // Attend que la connexion soit établie avant d'envoyer un message
                Thread.sleep(1000); 
                client2.sendMessage("Bonjour, je suis l'utilisateur 2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Démarre les threads des clients
        client1Thread.start();
        client2Thread.start();

        // Attend que les deux threads se terminent avant de quitter
        client1Thread.join();
        client2Thread.join();
    }
}

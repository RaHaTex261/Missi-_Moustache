package user;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/chat")
public class WebSocketServer {

    private static final CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();

    // Lorsqu'un utilisateur se connecte
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("Nouveau client connecté : " + session.getId());
    }

    // Lorsqu'un message est reçu d'un utilisateur
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message reçu : " + message);
        // Envoie le message à tous les autres clients connectés
        for (Session s : sessions) {
            if (!s.equals(session)) {  // Ne pas renvoyer le message à l'émetteur
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    System.err.println("Erreur lors de l'envoi du message à la session " + s.getId());
                    e.printStackTrace();
                }
            }
        }
    }

    // Lorsqu'un utilisateur se déconnecte
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Client déconnecté : " + session.getId());
    }

    // Lors d'une erreur survenue pendant la communication
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Erreur survenue avec la session " + session.getId());
        throwable.printStackTrace();
    }
}

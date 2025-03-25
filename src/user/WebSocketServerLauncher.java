package user;

//import org.glassfish.tyrus.server.Server;
//import javax.websocket.server.ServerEndpoint;

public class WebSocketServerLauncher {

    public static void main(String[] args) {
        // Créez le serveur WebSocket avec l'URI et l'endpoint
        //Server server = new Server("localhost", 8080, "/chat", WebSocketServer.class);

        try {
            // Démarre le serveur
         //   server.start();
            System.out.println("Serveur WebSocket démarré sur ws://localhost:8080/chat");

            // Attendre indéfiniment pour maintenir le serveur en fonctionnement
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Arrêter le serveur à la fin
         //   server.stop();
        }
    }
}

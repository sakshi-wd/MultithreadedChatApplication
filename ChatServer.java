import java.io.*;
import java.net.*;
import java.util.*;

/**
 * A multithreaded chat server that allows multiple clients to connect
 * and exchange messages in real-time.
 */
public class ChatServer {
    // Server will listen on this port
    private static final int PORT = 12346;

    // Thread-safe set of all client output streams for broadcasting messages
    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Chat Server starting on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Continuously accept new client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Start a new thread to handle this client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }

    /**
     * Handles communication with a single client.
     */
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Setup input and output streams for the client
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Add the output stream to the global set
                clientWriters.add(out);

                String message;

                // Listen for messages from the client
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Broadcast the message to all connected clients
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + socket);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {}
                clientWriters.remove(out);
            }
        }
    }
}

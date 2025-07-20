import java.io.*;
import java.net.*;

/**
 * A simple chat client that connects to the server and allows
 * the user to send and receive messages in real-time.
 */
public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1"; // localhost
    private static final int PORT = 12346;

    public static void main(String[] args) {
        try (
            // Establish socket connection with the server
            Socket socket = new Socket(SERVER_IP, PORT);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // For user input
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Server input
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true) // Output to server
        ) {
            System.out.println("Connected to chat server");

            // Thread to receive messages from server
            new Thread(() -> {
                String msgFromServer;
                try {
                    while ((msgFromServer = in.readLine()) != null) {
                        System.out.println(msgFromServer); // Print incoming messages
                    }
                } catch (IOException e) {
                    System.out.println("Server connection lost.");
                }
            }).start();

            // Main thread reads from user and sends to server
            String input;
            while ((input = userInput.readLine()) != null) {
                out.println(input);
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

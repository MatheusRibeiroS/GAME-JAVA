package Server;
import java.io.*;
import java.net.*;
public class Server {

  final static int port = 8080;
  Socket client;

  public static void main(String[] args) {
    ServerSocket server = null;

    try {
      server = new ServerSocket(port);
    } catch (IOException e) {
      System.out.println("Could not listen to port: " + port + ".\n" + e);
      System.exit(1);
    }
    System.out.println("Server is running....");
    System.out.println("Listening on port: " + port);

    for (int i = 0; i < 3; i++) {
      Socket client = null;

      try {
        System.out.println("Waiting connection with player...");
        client = server.accept();
      } catch (IOException e) {
        System.out.println("Failed to connect to server: " + port);
        System.out.println("Error: " + e);
        System.exit(1);
      }

      System.out.println("Player " + (i + 1) + " just entered the game.");
    }
    try {
      server.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

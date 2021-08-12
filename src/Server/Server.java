
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = null;
    int port = 12345;

    try {
      serverSocket = new ServerSocket(port);
    } catch (IOException e) {
      System.out.println("Could not listen port: " + port + ".\n" + e);
      System.exit(1);
    }
    while (true) {
      IJogo jogo = new Jogo(2);
      int numMaximoJogadores = jogo.numMaximoJogadores();
      for (int i = 0; i < numMaximoJogadores; i++) {
        Socket clientSocket = null;
        try {
          System.out.println("Esperando conexao de um jogador.");
          clientSocket = serverSocket.accept();
        } catch (IOException e) {
          System.out.println("Accept falhou: " + port + ".\n" + e);
          System.exit(1);
        }
        System.out.println("Accept Funcionou!");
        jogo.adicionaJogador(clientSocket);
      }
      jogo.iniciaLogica(new Logic(jogo));
      jogo.inicia();
      System.out.println("O jogo foi iniciado");
    }
  }
}
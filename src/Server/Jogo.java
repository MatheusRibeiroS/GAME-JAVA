//  Gustavo Amaral Duarte Rego  RA: 201025817
// Matheus dos Santos Ribeiro Silva RA: 201026406

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Jogo extends Thread implements IJogo {

  Socket clientSocket;
  DataInputStream[] is = new DataInputStream[2];
  DataOutputStream[] os = new DataOutputStream[2];
  boolean continua = true;
  Logic logica;
  int MaximoJogadores, jogadoresAtuais = 0;
  int key, keyEnemy;
  public static int life;
  public static int enemyLife;

  public static int[] posP1 = { 200, 200, 27, 38 };
  public static int[] posP2 = { 250, 250, 27, 38 };

  public static boolean isLeftP1 = false;
  public static boolean isLeftP2 = true;

  Jogo(int numMaximoJogadores) {
    MaximoJogadores = numMaximoJogadores;
    is = new DataInputStream[MaximoJogadores];
    os = new DataOutputStream[MaximoJogadores];
  }

  public int numMaximoJogadores() {
    return 2;
  }

  void iniciaThreadDoCliente(Socket clientSocket, int numDoJogador) {
    int numJogador = numDoJogador;
    int numAdversario = 1 - numDoJogador;
    new Thread() {
      // vai existir uma thread para cada cliente
      @Override
      public void run() {
        try {
          do {
            if (numDoJogador == 0) {
              key = is[0].readInt();
              posP1[0] = is[0].read();
              posP1[1] = is[0].read();
              posP1[2] = is[0].read();
              posP1[3] = is[0].read();
              life = is[0].readInt();
              Logic.estadoP1 = is[0].readInt();
              logica.moveP1(key);
              Logic.collide();
            } else {
              keyEnemy = is[1].readInt();
              posP2[0] = is[1].read();
              posP2[1] = is[1].read();
              posP2[2] = is[1].read();
              posP2[3] = is[1].read();
              enemyLife = is[1].readInt();
              Logic.estadoP2 = is[1].readInt();
              logica.moveP2(keyEnemy);
              Logic.collide();
            }

          } while (clienteVivo[numJogador] && clienteVivo[numAdversario]);

          os[numJogador].close();
          is[numJogador].close();
          clientSocket.close();
        } catch (IOException e) {
          try {
            clientSocket.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }
    }.start();
  }

  public void adicionaJogador(Socket clientSocket) {
    try {
      is[jogadoresAtuais] = new DataInputStream(clientSocket.getInputStream());
      os[jogadoresAtuais] = new DataOutputStream(clientSocket.getOutputStream());
    } catch (IOException erro) {
      System.out.println("Nao foi possivel conectar com o jogador " + jogadoresAtuais + 1);
      System.exit(1);
    }
    iniciaThreadDoCliente(clientSocket, jogadoresAtuais);
    jogadoresAtuais++;
  }

  public void iniciaLogica(ILogica logica) {
    this.logica = (Logic) logica;
  }

  public void run() {
    logica.executa();
  }

  public void inicia() {
    start();
  }

  boolean clienteVivo[] = { true, true };

  void forcaEnvio() {
    try {
      os[0].flush();
      os[1].flush();
    } catch (IOException e) {
    }
  }
}

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PVPGame extends JFrame {

  Socket socket = null;
  DataInputStream is = null;
  DataOutputStream os = null;
  boolean jogoFuncionando = true;
  int key = 0;
  int keyEnemy = 0;
  Thread t;
  Paint paint;
  public int life = 20;
  public int enemyLife = 20;
  public int[] posP1 = { 200, 200, 27, 38 };
  public int[] posP2 = { 250, 250, 27, 38 };
  int dirAdversario = -1;
  int numPlayer;
  int spriteP1 = 0;
  int spriteP2 = 0;
  Player p1 = new Player();
  Player p2 = new Player();

  PVPGame() {
    super("PVP GAME");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    paint = new Paint();

    conectaAoServidor();

    add(paint);
    pack();
    setResizable(false);
    setVisible(true);

    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          key = keyEnemy = KeyEvent.VK_RIGHT;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          key = keyEnemy = KeyEvent.VK_LEFT;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          key = keyEnemy = KeyEvent.VK_UP;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          key = keyEnemy = KeyEvent.VK_DOWN;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          key = keyEnemy = KeyEvent.VK_SPACE;
        }

        new Thread(new Runnable() {
          public void run() {
            try {
              // Thread.sleep(10);
              if (numPlayer == 0) {
                os.writeInt(key);

              } else {
                os.writeInt(key);

              }
              forcaEnvio();

            } catch (IOException error) {
              System.out.println("Erro: Client lost, erro: " + error);
              error.printStackTrace();
              System.exit(1);
            }
          }
        }).start();
      }
    });
  }

  void forcaEnvio() {
    try {
      os.flush();
    } catch (IOException e) {
    }
  }

  void erroFatalExcecao(String msg, Exception ex) {
    erroFatalExcecao(null, msg, ex);
  }

  void erroFatalExcecao(Exception ex) {
    erroFatalExcecao(null, null, ex);
  }

  void erroFatalExcecao(Component janela, String msg, Exception ex) {
    StringWriter str = new StringWriter();
    ex.printStackTrace(new PrintWriter(str));
    if (msg == null) {
      msg = str.toString();
    } else {
      msg += "\n" + str;
    }
    JOptionPane.showMessageDialog(janela, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    System.exit(10);
  }

  public class Paint extends JPanel {
    public Image background;

    public Paint() {

      try {
        background = ImageIO.read(new File("../../img/Background.JPG"));
        setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "A imagem não pôde ser carregada!\n" + e, "Error",
            JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }

    public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
      if (life > 0) {
        g.drawImage(p1.getSprite(), p1.x, p1.y, this);
        g.drawRect(posP1[0], posP1[1], posP1[2], posP1[3]);
      }
      if (enemyLife > 0) {
        g.drawImage(p2.getSprite(), p2.x, p2.y, this);
        g.drawRect(posP2[0], posP2[1], posP2[2], posP2[3]);
      }

      if (numPlayer == 0) {
        g.setColor(Color.BLACK);
        g.fillRect(48, 8, 8 * 20, 16);
        g.setColor(Color.RED);
        g.fillRect(48, 8, 8 * life, 16);
      } else if (numPlayer == 1) {
        g.setColor(Color.BLACK);
        g.fillRect(48, 8, 8 * 20, 16);
        g.setColor(Color.RED);
        g.fillRect(48, 8, 8 * enemyLife, 16);
      }

      Toolkit.getDefaultToolkit().sync();
      this.repaint();
    }
  }

  void conectaAoServidor() {
    new Thread(new Runnable() {
      public void run() {
        try {
          socket = new Socket("127.0.0.1", 12345);
          os = new DataOutputStream(socket.getOutputStream());
          is = new DataInputStream(socket.getInputStream());
          while (true) {
            numPlayer = is.readInt();
            posP1[0] = is.readInt();
            posP1[1] = is.readInt();
            posP1[2] = is.readInt();
            posP1[3] = is.readInt();
            life = is.readInt();
            spriteP1 = is.readInt();
            p1.x = posP1[0];
            p1.y = posP1[1];
            p1.setSprite(spriteP1);
            posP2[0] = is.readInt();
            posP2[1] = is.readInt();
            posP2[2] = is.readInt();
            posP2[3] = is.readInt();
            enemyLife = is.readInt();
            spriteP2 = is.readInt();
            p2.x = posP2[0];
            p2.y = posP2[1];
            p2.setSprite(spriteP2);
            if (life == 0 && numPlayer == 0) {
              JOptionPane.showMessageDialog(null, "Voce perdeu", "QUE PENA", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if (life == 0 && numPlayer == 1) {
              JOptionPane.showMessageDialog(null, "Voce ganhou", "PARABENS", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            }
            if (enemyLife == 0 && numPlayer == 1) {
              JOptionPane.showMessageDialog(null, "Voce perdeu", "QUE PENA", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if (enemyLife == 0 && numPlayer == 0) {
              JOptionPane.showMessageDialog(null, "Voce ganhou", "PARABENS", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            }
            repaint();
          }
        } catch (UnknownHostException e) {
          erroFatalExcecao("Servidor desconhecido!", e);
        } catch (IOException e) {
          erroFatalExcecao("A conexao com o servidor não pode ser criada!", e);
        }
      }
    }).start();
  }

  static public void main(String[] args) {
    PVPGame pvp = new PVPGame();
  }
}

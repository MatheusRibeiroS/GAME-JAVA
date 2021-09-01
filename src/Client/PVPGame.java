
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
  public int life = 10;
  public int enemyLife = 10;
  public int[] posP1 = { 350, 200, 54, 76 };
  public int[] posP2 = { 500, 200, 54, 76 };
  int dirAdversario = -1;
  int numPlayer;
  int spriteP1 = 0;
  int spriteP2 = 0;
  int time;
  Player p1 = new Player();
  Player p2 = new Player();
  public String p1Name = "P1";
  public String p2Name = "P2";

  public class CustomDialog extends JDialog {
    private JPanel myPanel = null;
    private JButton button = null;

    public CustomDialog(JFrame frame, boolean modal, String myMessage) {
    super(frame, modal);
    myPanel = new JPanel();
    getContentPane().add(myPanel);
    myPanel.add(new JLabel(myMessage));
    button = new JButton("'Beleza!");
    pack();
    //setLocationRelativeTo(frame);
    setLocation(200, 200); // <--
    setVisible(true);
    }
  }

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
      g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

      g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
      if (life > 0) {
        g.setColor(Color.BLACK);
        g.fillRect(48, 8, 8 * 10, 16);
        g.setColor(Color.RED);
        g.fillRect(48, 8, 8 * life, 16);
        g.setColor(Color.GREEN);
        g.drawString(p1Name, posP1[0] + 10, posP1[1] - 10);
        g.setColor(Color.RED);
        g.drawString("" + life, 138, 23);
        g.drawImage(p1.getSprite(), posP1[0], posP1[1], this);
      }
      if (enemyLife > 0) {
        g.setColor(Color.BLACK);
        g.fillRect(700, 8, 8 * 10, 16);
        g.setColor(Color.RED);
        g.fillRect(700, 8, 8 * enemyLife, 16);
        g.setColor(Color.GREEN);
        g.drawString(p2Name, posP2[0] + 10, posP2[1] - 10);
        g.setColor(Color.RED);
        g.drawString("" + enemyLife, 665, 23);
        g.drawImage(p2.getSprite(), posP2[0], posP2[1], this);
      }
      g.setFont(new Font("ArialBlack", Font.CENTER_BASELINE, 30));
      g.setColor(new Color(255, 115, 0));
      g.drawString("TIME = " + time, 400, background.getHeight(null));

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
            time = is.readInt();
            p2.x = posP2[0];
            p2.y = posP2[1];
            p2.setSprite(spriteP2);
            if (life == 0 && numPlayer == 0 || (time == 0 && life < enemyLife && numPlayer == 0)) {
              JOptionPane.showMessageDialog(null, "Voce perdeu!", "QUE PENA", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if ((life == 0 && numPlayer == 1) || (time == 0  && life < enemyLife && numPlayer == 1)) {
              JOptionPane.showMessageDialog(null, "Voce ganhou!", "PARABENS", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if ((enemyLife == 0 && numPlayer == 1) || (time  == 0 && enemyLife < life && numPlayer == 1)) {
              JOptionPane.showMessageDialog(null, "Voce perdeu!", "QUE PENA", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if ((enemyLife == 0 && numPlayer == 0) || (time == 0 && enemyLife < life && numPlayer == 0)) {
              JOptionPane.showMessageDialog(null, "Voce ganhou!", "PARABENS", JOptionPane.INFORMATION_MESSAGE);
              System.exit(1);
            } else if(time == 0) {
              JOptionPane.showMessageDialog(null, "Empatou!", "UAU", JOptionPane.INFORMATION_MESSAGE);
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

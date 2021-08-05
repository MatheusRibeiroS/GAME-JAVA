//  Gustavo Amaral Duarte Rego  RA: 201025817
//  Matheus Dos Santos Ribeiro Silva  RA: 201026406   [july/2021]

import java.awt.event.*;
import javax.swing.*;
import characters.*;

class PVPGame extends JFrame {
  // public String globMove = "<3";

  String character = "Skeleton";

  // Declares a new Instance of movement to Access Inner Classes
  Movement m = new Movement();
  Collision collision = new Collision();
  Paint p = new Paint();

  PVPGame() {

    super("PVP GAME");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(p);
    pack();
    setResizable(false);
    setVisible(true);

    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_1) {
          character = "Skeleton";
        } else if (c == KeyEvent.VK_2) {
          character = "Unicorn";
        } else if (c == KeyEvent.VK_3) {
          character = "SwordKnight";
        } /*
           * else if(c == KeyEvent.VK_4) { character = "TridentKnight"; }
           */
        new Thread(new Runnable() {
          public void run() {
            m.moveP1(c, character);
          }
        }).start();
      }
    });
  }

  static public void main(String[] args) {
    PVPGame pvp = new PVPGame();
  }
}

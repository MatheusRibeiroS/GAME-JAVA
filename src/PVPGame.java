import java.awt.event.*;
import javax.swing.*;

class pvpGame extends JFrame {

  String character = "Skeleton";

    //Declares a new Instance of movement to Access Inner Classes
    movement m = new movement();
    

  pvpGame() {
    super("PVP GAME");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(m.draw);
    pack();
    setVisible(true);
    
    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_1) {
          character = "Skeleton";
        } else if(c == KeyEvent.VK_2) {
          character = "Unicorn";
        } else if(c == KeyEvent.VK_3) {
          character = "SwordKnight";
        }
        m.moveP1(c, character);
        while(m.Colision.colisionP1()) {
          switch (c) {
            case KeyEvent.VK_UP:
              m.moveP1(KeyEvent.VK_DOWN, character);
              break;
            case KeyEvent.VK_DOWN:
              m.moveP1(KeyEvent.VK_UP, character);
              break;
            case KeyEvent.VK_LEFT:
              m.moveP1(KeyEvent.VK_RIGHT, character);
              break;
            case KeyEvent.VK_RIGHT:
              m.moveP1(KeyEvent.VK_LEFT, character);
              break;
            default:
              break;
          }
          m.createColision();
        }
      }
    });
  }

  static public void main(String[] args) {
    pvpGame pvp = new pvpGame();
  }
}

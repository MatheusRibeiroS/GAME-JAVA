import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
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
        }
        m.moveP1(c, character);
        
      }
    });
  }

  static public void main(String[] args) {
    pvpGame pvp = new pvpGame();
  }
}

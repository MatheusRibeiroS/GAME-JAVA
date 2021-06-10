import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

class pvpGame extends JFrame {

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
        m.skelMov(c);
      }
    });
  }

  static public void main(String[] args) {
    pvpGame pvp = new pvpGame();
  }
}

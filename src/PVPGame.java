import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

class PVPGame extends JFrame {
  Image img;
  Drawning drawning = new Drawning();

  class Drawning extends JPanel {

    Drawning() {
      try {
        setPreferredSize(new Dimension(1000, 600));
        img = ImageIO.read(new File("background.jpeg"));
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "The image cannot be loaded!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  PVPGame() {
    super("Trabalho");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(drawning);
    pack();
    setVisible(true);
  }

  static public void main(String[] args) {
    PVPGame PVP = new PVPGame();
  }
}

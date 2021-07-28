import java.awt.*;
import java.io.*;
import javax.swing.*;
import characters.*;
import javax.imageio.*;

public class Paint extends JPanel {
  public static Image background;

  public Paint() {

    try {
      background = ImageIO.read(new File("../img/Background.JPG"));
      setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
    g.drawImage(Skeleton.skl.getSkeleton(), Skeleton.skl.x, Skeleton.skl.y, this);
    g.drawImage(UnicornKnight.unicorn.getUnicorn(), UnicornKnight.unicorn.x, UnicornKnight.unicorn.y,
      this);
    g.drawImage(SwordKnight.sword.getSwordKnight(), SwordKnight.sword.x, SwordKnight.sword.y, this);
    Toolkit.getDefaultToolkit().sync();
    this.repaint();
  }
}
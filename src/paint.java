import java.awt.*;
import java.io.*;
import javax.swing.*;
import characters.*;
import javax.imageio.*;

public class Paint extends JPanel {
  public static Image background;

  // Create Instances of the characters

  Skeleton Skl = new Skeleton();
  UnicornKnight Uni = new UnicornKnight();
  SwordKnight Sword = new SwordKnight();
  // tridentKnight tKnight = new tridentKnight();

  public Paint() {

    try {
      setPreferredSize(new Dimension(1000, 600));
      background = ImageIO.read(new File("../img/Background.JPG"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void paintComponent(Graphics g) {
    boolean validation = true;
    int posXSkl = 350;
    int posYSkl = 0;

    if (validation) {
      posYSkl = (getSize().height / 2) - Skeleton.skeleton.getSkeleton().getHeight(this);
      validation = false;
      posYSkl = (getSize().height / 2) - Skeleton.skeleton.getSkeleton().getHeight(this);
    }

    super.paintComponent(g);
    g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
    g.drawImage(Skeleton.skeleton.getSkeleton(), Skeleton.skeleton.x, Skeleton.skeleton.y, this);
    g.drawImage(UnicornKnight.unicornKnight.getUnicorn(), UnicornKnight.unicornKnight.x, UnicornKnight.unicornKnight.y,
        this);
    g.drawImage(SwordKnight.swordKnight.getSwordKnight(), SwordKnight.swordKnight.x, SwordKnight.swordKnight.y, this);
    Toolkit.getDefaultToolkit().sync();
    this.repaint();
  }
}

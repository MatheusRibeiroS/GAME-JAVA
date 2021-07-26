package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class UnicornKnight {
  public int life = 10;
  public int x, y;
  public int sprite = 0;
  private Rectangle rect;

  public static UnicornKnight unicornKnight;
  // Static Initializer Block
  static {
    unicornKnight = new UnicornKnight();
  }

  public static final int WALKUNI1 = 0;
  public static final int WALKUNI2 = 1;
  public static final int WALKUNI3 = 2;
  public static final int WALKUNI4 = 3;
  public static final int DEADUNI = 4;
  public static final int ATTKUNI = 5;

  public Image Unicorn[] = new Image[6];

  public UnicornKnight() {
    try {
      // Unicorn Sprites Imported
      Unicorn[WALKUNI1] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn.png"));
      Unicorn[WALKUNI2] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn.png"));
      Unicorn[WALKUNI3] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn.png"));
      Unicorn[WALKUNI4] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn.png"));
      Unicorn[DEADUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn.png"));
      Unicorn[ATTKUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn.png"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public Image getUnicorn() {
    return Unicorn[sprite];
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }
}

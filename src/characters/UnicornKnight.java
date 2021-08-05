package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class UnicornKnight {
  public int life = 10;
  public int x = 252, y = 150;
  public int sprite = 0;
  public boolean isLeft = false;

  public static UnicornKnight unicorn;
  // Static Initializer Block
  static {
    unicorn = new UnicornKnight();
  }

  public static final int WALKUNI1 = 0;
  public static final int WALKUNI2 = 1;
  public static final int WALKUNI3 = 2;
  public static final int WALKUNI4 = 3;
  public static final int DEADUNI = 4;
  public static final int ATTKUNI = 5;
  public static final int WALKUNI1_L = 6;
  public static final int WALKUNI2_L = 7;
  public static final int WALKUNI3_L = 8;
  public static final int WALKUNI4_L = 9;
  public static final int DEADUNI_L = 10;
  public static final int ATTKUNI_L = 11;

  public Image Unicorn[] = new Image[13];

  public UnicornKnight() {
    try {
      // UnicornKnight Sprites Imported
      Unicorn[WALKUNI1] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn.png"));
      Unicorn[WALKUNI2] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn.png"));
      Unicorn[WALKUNI3] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn.png"));
      Unicorn[WALKUNI4] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn.png"));
      Unicorn[DEADUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn.png"));
      Unicorn[ATTKUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn.png"));
      Unicorn[WALKUNI1_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn-left.png"));
      Unicorn[WALKUNI2_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn-left.png"));
      Unicorn[WALKUNI3_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn-left.png"));
      Unicorn[WALKUNI4_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn-left.png"));
      Unicorn[DEADUNI_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn-left.png"));
      Unicorn[ATTKUNI_L] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn-left.png"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void damage() {
    if(life > 0) {
      life --;
      System.out.println("A vida do Unicornio eh: " + life);
    }
  }

  public Image getUnicorn() {
    return Unicorn[sprite];
  }

  public Rectangle getRect() {
    if (sprite == ATTKUNI || sprite == ATTKUNI_L) {
      return new Rectangle(x, y, getUnicorn().getWidth(null), getUnicorn().getHeight(null));
    }
    if(isLeft) {
      return new Rectangle(x+25, y, getUnicorn().getWidth(null) - 30 , getUnicorn().getHeight(null));
    } else {
      return new Rectangle(x, y, getUnicorn().getWidth(null) - 30, getUnicorn().getHeight(null));
    }
  }

  public int getSprite() {
    return this.sprite;
  }

  public void setSprite(int sprite) {
    this.sprite = sprite;
  }

}

package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class SwordKnight {
  public int life = 10;
  public int x = 200, y = 200;
  private int sprite = 0;
  public static SwordKnight sword;
  static {
    sword = new SwordKnight();
  }

  public static final int RELAX1SWORDK = 0;
  public static final int RELAX2SWORDK = 1;
  public static final int ATTK1SWORDK = 2;
  public static final int ATTK2SWORDK = 3;
  public static final int ATTK3SWORDK = 4;
  public static final int ATTK4SWORDK = 5;
  public static final int ATTK5SWORDK = 6;
  public static final int ATTK6SWORDK = 7;
  public static final int ATTK7SWORDK = 8;
  public static final int WALK1SWORDK = 9;
  public static final int WALK2SWORDK = 10;

  public Image SwordKnight[] = new Image[12];

  public SwordKnight() {
    try {
      // Sword Knight Sprites
      SwordKnight[RELAX1SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight.png"));
      SwordKnight[RELAX2SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight.png"));
      SwordKnight[ATTK1SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking1-Sword-Knight.png"));
      SwordKnight[ATTK2SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking2-Sword-Knight.png"));
      SwordKnight[ATTK3SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking3-Sword-Knight.png"));
      SwordKnight[ATTK4SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking4-Sword-Knight.png"));
      SwordKnight[ATTK5SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking5-Sword-Knight.png"));
      SwordKnight[ATTK6SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking6-Sword-Knight.png"));
      SwordKnight[ATTK7SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking7-Sword-Knight.png"));
      SwordKnight[WALK1SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Walking1-Sword-Knight.png"));
      SwordKnight[WALK2SWORDK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Walking2-Sword-Knight.png"));

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void damage() {
    life --;
    System.out.println("A vida do Cavaleiro eh: " + life);
  }

  public Image getSwordKnight() {
    return SwordKnight[sprite];
  }

  public Rectangle getRect() {
    return new Rectangle(x, y, getSwordKnight().getWidth(null), getSwordKnight().getHeight(null));
  }

  public int getSprite() {
    return this.sprite;
  }
  public void setSprite(int sprite) {
    this.sprite = sprite;
  }
}


import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class P1 {
  public static int life = 10;
  public static int x = 200;
  public static int y = 200;
  private static int sprite = 0;
  public boolean isLeft = false;

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
  public static final int RELAX1SWORDK_L = 11;
  public static final int RELAX2SWORDK_L = 12;
  public static final int ATTK1SWORDK_L = 13;
  public static final int ATTK2SWORDK_L = 14;
  public static final int ATTK3SWORDK_L = 15;
  public static final int ATTK4SWORDK_L = 16;
  public static final int ATTK5SWORDK_L = 17;
  public static final int ATTK6SWORDK_L = 18;
  public static final int ATTK7SWORDK_L = 19;
  public static final int WALK1SWORDK_L = 20;
  public static final int WALK2SWORDK_L = 21;

  public static Image SwordKnight[] = new Image[25];

  static {
    try {
      // Sword Knight Sprites
      SwordKnight[RELAX1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight.png"));
      SwordKnight[RELAX2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight.png"));
      SwordKnight[ATTK1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking1-Sword-Knight.png"));
      SwordKnight[ATTK2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking2-Sword-Knight.png"));
      SwordKnight[ATTK3SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking3-Sword-Knight.png"));
      SwordKnight[ATTK4SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking4-Sword-Knight.png"));
      SwordKnight[ATTK5SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking5-Sword-Knight.png"));
      SwordKnight[ATTK6SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking6-Sword-Knight.png"));
      SwordKnight[ATTK7SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking7-Sword-Knight.png"));
      SwordKnight[WALK1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking1-Sword-Knight.png"));
      SwordKnight[WALK2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking2-Sword-Knight.png"));
      SwordKnight[RELAX1SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight-left.png"));
      SwordKnight[RELAX2SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight-left.png"));
      SwordKnight[ATTK1SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking1-Sword-Knight-left.png"));
      SwordKnight[ATTK2SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking2-Sword-Knight-left.png"));
      SwordKnight[ATTK3SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking3-Sword-Knight-left.png"));
      SwordKnight[ATTK4SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking4-Sword-Knight-left.png"));
      SwordKnight[ATTK5SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking5-Sword-Knight-left.png"));
      SwordKnight[ATTK6SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking6-Sword-Knight-left.png"));
      SwordKnight[ATTK7SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking7-Sword-Knight-left.png"));
      SwordKnight[WALK1SWORDK_L] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking1-Sword-Knight-left.png"));
      SwordKnight[WALK2SWORDK_L] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking2-Sword-Knight-left.png"));

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void damage() {
    if (life > 0) {
      life--;
      System.out.println("A vida do Cavaleiro eh: " + life);
    }
  }

  public static Image getSprite() {
    return SwordKnight[sprite];
  }

  public static int[] getRect() {
    return new int[] {x, y, getSprite().getWidth(null), getSprite().getHeight(null)};
  }

  public static void setSprite(int sprite) {
    P1.sprite = sprite;
  }
}
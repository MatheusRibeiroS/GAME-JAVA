import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class Player {
  public int life = 10;
  public int x = 350;
  public int y = 200;
  private int sprite = 0;
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
      SwordKnight[RELAX1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight.png")).getScaledInstance(54, 76, Image.SCALE_AREA_AVERAGING);
      SwordKnight[RELAX2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight.png")).getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking1-Sword-Knight.png")).getScaledInstance(58, 86, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking2-Sword-Knight.png")).getScaledInstance(52, 96, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK3SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking3-Sword-Knight.png")).getScaledInstance(50, 96, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK4SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking4-Sword-Knight.png")).getScaledInstance(72, 90, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK5SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking5-Sword-Knight.png")).getScaledInstance(70, 88, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK6SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking6-Sword-Knight.png")).getScaledInstance(70, 116, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK7SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Attacking7-Sword-Knight.png")).getScaledInstance(50, 106, Image.SCALE_AREA_AVERAGING);
      SwordKnight[WALK1SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking1-Sword-Knight.png")).getScaledInstance(60, 76, Image.SCALE_AREA_AVERAGING);
      SwordKnight[WALK2SWORDK] = ImageIO.read(new File("../../img/Sword-Knight-Sprites/Walking2-Sword-Knight.png")).getScaledInstance(54, 76, Image.SCALE_AREA_AVERAGING);
      SwordKnight[RELAX1SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight-left.png")).getScaledInstance(54, 76, Image.SCALE_AREA_AVERAGING);
      SwordKnight[RELAX2SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight-left.png")).getScaledInstance(72, 72, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK1SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking1-Sword-Knight-left.png")).getScaledInstance(58, 86, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK2SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking2-Sword-Knight-left.png")).getScaledInstance(52, 96, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK3SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking3-Sword-Knight-left.png")).getScaledInstance(50, 96, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK4SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking4-Sword-Knight-left.png")).getScaledInstance(72, 90, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK5SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking5-Sword-Knight-left.png")).getScaledInstance(70, 88, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK6SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking6-Sword-Knight-left.png")).getScaledInstance(70, 116, Image.SCALE_AREA_AVERAGING);
      SwordKnight[ATTK7SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Attacking7-Sword-Knight-left.png")).getScaledInstance(50, 106, Image.SCALE_AREA_AVERAGING);
      SwordKnight[WALK1SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Walking1-Sword-Knight-left.png")).getScaledInstance(60, 76, Image.SCALE_AREA_AVERAGING);
      SwordKnight[WALK2SWORDK_L] = ImageIO
          .read(new File("../../img/Sword-Knight-Sprites/Walking2-Sword-Knight-left.png")).getScaledInstance(54, 76, Image.SCALE_AREA_AVERAGING);

    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void damage() {
    if (life > 0) {
      life--;
    }
  }

  public Image getSprite() {
    return SwordKnight[sprite];
  }

  public int[] getRect() {
    return new int[] { x, y, getSprite().getWidth(null), getSprite().getHeight(null) };
  }

  public void setSprite(int sprite) {
    this.sprite = sprite;
  }
}
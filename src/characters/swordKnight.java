package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class swordKnight {
  private int life = 10;
  private Image Sprite;
  private int x, y;
  private Rectangle rect;

  final int RELAX1SWORDK = 0;
  final int RELAX2SWORDK = 1;
  final int ATTK1SWORDK = 2;
  final int ATTK2SWORDK = 3;
  final int ATTK3SWORDK = 4;
  final int ATTK4SWORDK = 5;
  final int ATTK5SWORDK = 6;
  final int ATTK6SWORDK = 7;
  final int ATTK7SWORDK = 8;
  final int WALK1SWORDK = 9;
  final int WALK2SWORDK = 10;

  public swordKnight() {
    try {
      Image SwordKnight[] = new Image[12];
      // Sword Knight Imported
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

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public Image getSprite() {
    return Sprite;
  }

  public void setSprite(Image Sprite) {
    this.Sprite = Sprite;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }
  
}

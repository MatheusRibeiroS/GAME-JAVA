import java.awt.*;
import javax.swing.*;


public class colision {
  Rectangle rectSkl;
  Rectangle rectUni;
  
  colision(int x1, int y1, int x2, int y2, int moveStateSkl, int moveStateUni, Image Skeleton[], Image Unicorn[], Image SwordKnight[]) {
    rectSkl = new Rectangle(x1, y1, Skeleton[moveStateSkl].getWidth(null), Skeleton[moveStateSkl].getHeight(null));
    rectUni = new Rectangle(x2, y2, Unicorn[moveStateUni].getWidth(null)-27, Unicorn[moveStateUni].getHeight(null));
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
  }

  
  
  public boolean colisionP1() {

    if(rectSkl.intersects(rectUni)) {
      return true;
    }
    return false;
  }

public Rectangle getRectSkl() {
    return rectSkl;
}

public Rectangle getRectUni() {
    return rectUni;
}

public void setRectSkl(Rectangle rectSkl) {
    this.rectSkl = rectSkl;
}

public void setRectUni(Rectangle rectUni) {
    this.rectUni = rectUni;
}

}

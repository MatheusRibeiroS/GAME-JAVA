import java.awt.*;

public class colision {
  Rectangle rectSkl;
  Rectangle rectUni;

  colision(int x1, int y1, int x2, int y2, Image Skeleton[], Image Unicorn[], Image SwordKnight[]) {
    rectSkl = new Rectangle(x1, y1, Skeleton[2].getWidth(null), Skeleton[1].getHeight(null));
    rectUni = new Rectangle(x2, y2, Unicorn[2].getWidth(null)-27, Unicorn[1].getHeight(null));
  }
  

  public void colisionP1() {
    if (rectSkl.intersects(rectUni)) {
      System.out.println("test");
    } else if(rectUni.intersects(rectSkl)) {
      System.out.println("test2");
    }
  }

}

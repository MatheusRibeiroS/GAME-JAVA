
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Logic implements ILogica, EventListener {

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

  public static final int p1 = 0;
  public static final int p2 = 1;
  public static int estadoP1 = RELAX1SWORDK;
  public static int estadoP2 = RELAX1SWORDK_L;
  public static boolean attk1 = false;
  public static boolean attk2 = false;
  Jogo jogo;

  /*
   * Logic(IJogo jogo) { this.jogo = (Jogo) jogo; }
   */

  Logic(IJogo jogo) {
    this.jogo = (Jogo) jogo;
  }

  public void executa() {
    new Thread(new Runnable() {
      public void run() {
        try {
          while (true) {
            Thread.sleep(10);
            jogo.os[0].writeInt(0);
            jogo.os[0].write(Jogo.posP1[0]);
            jogo.os[0].write(Jogo.posP1[1]);
            jogo.os[0].write(Jogo.posP1[2]);
            jogo.os[0].write(Jogo.posP1[3]);
            jogo.os[0].writeInt(Jogo.life);
            jogo.os[0].writeInt(estadoP1);
            jogo.os[0].write(Jogo.posP2[0]);
            jogo.os[0].write(Jogo.posP2[1]);
            jogo.os[0].write(Jogo.posP2[2]);
            jogo.os[0].write(Jogo.posP2[3]);
            jogo.os[0].writeInt(Jogo.enemyLife);
            jogo.os[0].writeInt(estadoP2);
            jogo.forcaEnvio();
            jogo.os[1].writeInt(1);
            jogo.os[1].write(Jogo.posP1[0]);
            jogo.os[1].write(Jogo.posP1[1]);
            jogo.os[1].write(Jogo.posP1[2]);
            jogo.os[1].write(Jogo.posP1[3]);
            jogo.os[1].writeInt(Jogo.life);
            jogo.os[1].writeInt(estadoP1);
            jogo.os[1].write(Jogo.posP2[0]);
            jogo.os[1].write(Jogo.posP2[1]);
            jogo.os[1].write(Jogo.posP2[2]);
            jogo.os[1].write(Jogo.posP2[3]);
            jogo.os[1].writeInt(Jogo.enemyLife);
            jogo.os[1].writeInt(estadoP2);

            jogo.forcaEnvio();
          }
        } catch (Exception error) {
          System.out.println("Erro: Exception(Server)");
          error.printStackTrace();
        }
      }
    }).start();
  }

  public static boolean collide() {
    Rectangle rectP1 = new Rectangle(Jogo.posP1[0], Jogo.posP1[1], Jogo.posP1[2], Jogo.posP1[3]);
    Rectangle rectP2 = new Rectangle(Jogo.posP2[0], Jogo.posP2[1], Jogo.posP2[2], Jogo.posP2[3]);
    return (rectP1.intersects(rectP2));
  }

  public void animateP1() {
    if (estadoP1 == RELAX1SWORDK || estadoP1 == RELAX1SWORDK_L || estadoP1 == WALK2SWORDK || estadoP1 == RELAX2SWORDK
        || estadoP1 == WALK2SWORDK_L || estadoP1 == RELAX2SWORDK_L) {
      if (Jogo.isLeftP1) {
        estadoP1 = WALK1SWORDK_L;
      } else {
        estadoP1 = WALK1SWORDK;
      }
    } else if (estadoP1 == WALK1SWORDK || estadoP1 == WALK1SWORDK_L) {
      if (Jogo.isLeftP1) {
        estadoP1 = WALK2SWORDK_L;
      } else {
        estadoP1 = WALK2SWORDK;
      }
    }
  }

  public void animateP2() {
    if (estadoP2 == RELAX1SWORDK || estadoP2 == RELAX1SWORDK_L || estadoP2 == WALK2SWORDK || estadoP2 == RELAX2SWORDK
        || estadoP2 == WALK2SWORDK_L || estadoP2 == RELAX2SWORDK_L) {
      if (Jogo.isLeftP2) {
        estadoP2 = WALK1SWORDK_L;
      } else {
        estadoP2 = WALK1SWORDK;
      }
    } else if (estadoP2 == WALK1SWORDK || estadoP2 == WALK1SWORDK_L) {
      if (Jogo.isLeftP2) {
        estadoP2 = WALK2SWORDK_L;
      } else {
        estadoP2 = WALK2SWORDK;
      }
    }
  }

  Timer t1 = new Timer(75, new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
      attk1 = true;
      if ((estadoP1 == WALK1SWORDK) || (estadoP1 == WALK2SWORDK) || (estadoP1 == RELAX1SWORDK)
          || (estadoP1 == WALK1SWORDK_L) || (estadoP1 == WALK2SWORDK_L) || (estadoP1 == RELAX1SWORDK_L)) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK1SWORDK_L;
        } else {
          estadoP1 = ATTK1SWORDK;
        }
      } else if (estadoP1 == ATTK1SWORDK || estadoP1 == ATTK1SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK2SWORDK_L;
        } else {
          estadoP1 = ATTK2SWORDK;
        }
      } else if (estadoP1 == ATTK2SWORDK || estadoP1 == ATTK2SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK3SWORDK_L;
        } else {
          estadoP1 = ATTK3SWORDK;
        }
      } else if (estadoP1 == ATTK3SWORDK || estadoP1 == ATTK3SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK4SWORDK_L;
        } else {
          estadoP1 = ATTK4SWORDK;
        }
      } else if (estadoP1 == ATTK4SWORDK || estadoP1 == ATTK4SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK5SWORDK_L;
        } else {
          estadoP1 = ATTK5SWORDK;
        }
      } else if (estadoP1 == ATTK5SWORDK || estadoP1 == ATTK5SWORDK_L) {
        if (Jogo.isLeftP1) {
          Jogo.posP1[0] -= 5;
          estadoP1 = ATTK6SWORDK_L;
          if (collide()) {
            Jogo.enemyLife--;
          }
        } else {
          estadoP1 = ATTK6SWORDK;
        }
      } else if (estadoP1 == ATTK6SWORDK || estadoP1 == ATTK6SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = ATTK7SWORDK_L;
        } else {
          Jogo.posP1[0] += 5;
          estadoP1 = ATTK7SWORDK;
        }
      } else if (estadoP1 == ATTK7SWORDK || estadoP1 == ATTK7SWORDK_L) {
        if (Jogo.isLeftP1) {
          estadoP1 = RELAX2SWORDK_L;
        } else {
          estadoP1 = RELAX2SWORDK;
        }
        attk1 = false;
        ((Timer) ae.getSource()).stop();
      }
    }
  });



  Timer t2 = new Timer(75, new ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent ae) {
      attk2 = true;
      if ((estadoP2 == WALK1SWORDK) || (estadoP2 == WALK2SWORDK) || (estadoP2 == RELAX1SWORDK)
          || (estadoP2 == WALK1SWORDK_L) || (estadoP2 == WALK2SWORDK_L) || (estadoP2 == RELAX1SWORDK_L)) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK1SWORDK_L;
        } else {
          estadoP2 = ATTK1SWORDK;
        }
      } else if (estadoP2 == ATTK1SWORDK || estadoP2 == ATTK1SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK2SWORDK_L;
        } else {
          estadoP2 = ATTK2SWORDK;
        }
      } else if (estadoP2 == ATTK2SWORDK || estadoP2 == ATTK2SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK3SWORDK_L;
        } else {
          estadoP2 = ATTK3SWORDK;
        }
      } else if (estadoP2 == ATTK3SWORDK || estadoP2 == ATTK3SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK4SWORDK_L;
        } else {
          estadoP2 = ATTK4SWORDK;
        }
      } else if (estadoP2 == ATTK4SWORDK || estadoP2 == ATTK4SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK5SWORDK_L;
        } else {
          estadoP2 = ATTK5SWORDK;
        }
      } else if (estadoP2 == ATTK5SWORDK || estadoP2 == ATTK5SWORDK_L) {
        if (Jogo.isLeftP2) {
          Jogo.posP1[0] -= 5;
          estadoP2 = ATTK6SWORDK_L;
          if (collide()) {
            Jogo.enemyLife--;
          }
        } else {
          estadoP2 = ATTK6SWORDK;
        }
      } else if (estadoP2 == ATTK6SWORDK || estadoP2 == ATTK6SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = ATTK7SWORDK_L;
        } else {
          Jogo.posP1[0] += 5;
          estadoP2 = ATTK7SWORDK;
        }
      } else if (estadoP2 == ATTK7SWORDK || estadoP2 == ATTK7SWORDK_L) {
        if (Jogo.isLeftP2) {
          estadoP2 = RELAX2SWORDK_L;
        } else {
          estadoP2 = RELAX2SWORDK;
        }
        attk2 = false;
        ((Timer) ae.getSource()).stop();
      }
    }
  });

  final int ADD = 7;

  public void moveP1(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      Jogo.isLeftP1 = false;
      animateP1();
      Jogo.posP1[0] += ADD;
      // border value = 30
      if (collide() || Jogo.posP1[0] > 897) {
        Jogo.posP1[0] -= ADD;
      }
    } else if (move == KeyEvent.VK_LEFT) {
      Jogo.isLeftP1 = true;
      animateP1();
      Jogo.posP1[0] -= ADD;
      if (collide() || Jogo.posP1[0] < 0) {
        Jogo.posP1[0] += ADD;
      }
    } else if (move == KeyEvent.VK_UP) {
      animateP1();
      Jogo.posP1[1] -= ADD;
      if (collide() || Jogo.posP1[1] < 110) {
        Jogo.posP1[1] += ADD;
      }
    } else if (move == KeyEvent.VK_DOWN) {
      animateP1();
      Jogo.posP1[1] += ADD;
      if (collide() || Jogo.posP1[1] > 330) {
        Jogo.posP1[1] -= ADD;
      }
    } else if (move == KeyEvent.VK_SPACE) {
      if (!attk1) {
        t1.start();
      }
    }
  }

  public void moveP2(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      Jogo.isLeftP2 = false;
      animateP2();
      Jogo.posP2[0] += ADD;
      // border value = 30
      if (collide() || Jogo.posP2[0] > 897) {
        Jogo.posP2[0] -= ADD;
      }
    } else if (move == KeyEvent.VK_LEFT) {
      Jogo.isLeftP2 = true;
      animateP2();
      Jogo.posP2[0] -= ADD;
      if (collide() || Jogo.posP2[0] < 0) {
        Jogo.posP2[0] += ADD;
      }
    } else if (move == KeyEvent.VK_UP) {
      animateP2();
      Jogo.posP2[1] -= ADD;
      if (collide() || Jogo.posP2[1] < 110) {
        Jogo.posP2[1] += ADD;
      }
    } else if (move == KeyEvent.VK_DOWN) {
      animateP2();
      Jogo.posP2[1] += ADD;
      if (collide() || Jogo.posP2[1] > 440) {
        Jogo.posP2[1] -= ADD;
      }
    } else if (move == KeyEvent.VK_SPACE) {
      if (!attk2) {
        t1.start();
      }
    }
  }
}
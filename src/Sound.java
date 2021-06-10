import java.io.*;
import java.net.*;
import java.util.*;
import sun.audio.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class sound {
    public static void main(String[] args) {

        try {
            while (true) {
                playSound("bad.wav");
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
        }
    }

    public static synchronized void playSound(final String file) {
        try {
            AudioInputStream ais = AudioSystem
                    .getAudioInputStream(new File(file));
            Clip c = AudioSystem.getClip(AudioSystem.getMixerInfo()[1]);
            c.open(ais);
            c.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

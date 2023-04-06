package powpaw.controller.impl;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;

public class MediaAudio {
    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                File file = new File(url);
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new FileInputStream("mainTitle.wav"));

                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println("MEDIA ERROR " + e.getMessage());
                }
            }
        }).start();
    }
}

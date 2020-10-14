package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GetAudio {
    /**
     * if there is no file word.mp3 in data, it load data form the Internet, else do nothing.
     */
    public GetAudio (String key) throws IOException {
        String path ="src/main/resources/org/example/data/" +  key + ".mp3";
        File file = new File(path);
        if (file.createNewFile()) {
            try {
                System.out.println("getting data from internet");
                String url = "https://ssl.gstatic.com/dictionary/static/sounds/20180430/"
                        + key.toLowerCase()
                        + "--_us_1.mp3";
                URLConnection conn = new URL(url).openConnection();
                InputStream is = conn.getInputStream();

                OutputStream outstream = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
            } catch (IOException e) {

                System.out.println("getting data from internet");
                String url = "https://ssl.gstatic.com/dictionary/static/sounds/20180430/"
                        + key.toLowerCase()
                        + "--_us_2.mp3";
                URLConnection conn = new URL(url).openConnection();
                InputStream is = conn.getInputStream();

                OutputStream outstream = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
            } catch (Exception e) {
                System.out.println("getting data from internet");
                String url = "https://ssl.gstatic.com/dictionary/static/sounds/20180430/"
                        + key.toLowerCase()
                        + "--_us_3.mp3";
                URLConnection conn = new URL(url).openConnection();
                InputStream is = conn.getInputStream();

                OutputStream outstream = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    outstream.write(buffer, 0, len);
                }
                outstream.close();
            }
        } else {
            System.out.println("local data");
        }
    }

    void playMedia(String key) {
//        String mp3 = "data/word.mp3";
//        URL resource = getClass().getResource(mp3);
//        System.out.println(resource.toString());
//        Media media = new Media(resource.toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
        String mp3 = "src/main/resources/org/example/data/word.mp3";
        Media hit = new Media(new File(mp3).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public static void main(String[] args) throws IOException {
        new GetAudio("abstract");
    }
}

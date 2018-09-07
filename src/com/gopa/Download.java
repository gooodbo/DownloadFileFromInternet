package com.gopa;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Download {

    private static boolean downloadMp3() {

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {

            URL connection = new URL("http://myflex.org/yf/podru/budam514.mp3");
            // URL connection = new URL("https://www.pornhub.com/view_video.php?viewkey=ph5b81399acad0d");
            URLConnection urlConnection = connection.openConnection();

            in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("Downloading...");
            out = new BufferedOutputStream(new FileOutputStream("song.mp3"));

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {

            try {

                assert in != null;
                in.close();

                assert out != null;
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
                return false;

            }
        }
        return true;
    }

    public boolean getDownload() {
        return downloadMp3();
    }
}


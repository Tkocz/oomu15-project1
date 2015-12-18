package grupp0.arena.client.view;

import grupp0.arena.Arena;
import grupp0.arena.base.model.GameInfo;
import javafx.application.Platform;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Darko on 10/12/15.
 */
public class ProgressWindow extends AppWindow {
    @FXML
    private Label messageLabel;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button okButton;

    private GameInfo gi;

    public ProgressWindow(GameInfo gi) {
        this.gi = gi;
        String text= new String("Download Progress");


        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/fxml/ProgressWindow.fxml"));

        fxml.setController(this);


        try {
            setScene(new Scene(fxml.load()));
            okButton.setOpacity(0);
            setResizable(false);
            setTitle("Installing Game");
            messageLabel.setText(text);
            okButton.setOnAction((e) -> close());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            installer();
            messageLabel.setText("Installation finished");
            progressBar.setOpacity(0);
            okButton.setOpacity(100);
        }

    }
    public static void show(GameInfo gi) {
        new ProgressWindow(gi).show();
    }

    private void installer(){
        try {
            String temp = "https://github.com/philiparvidsson/oomu15-project1/raw/master/resources/games/";
            temp = temp.concat(gi.getName());
            temp = temp.concat(".jar");

            String path = "./resources/games/";
            path = path.concat(gi.getName());
            path = path.concat(".jar");

            URL url = null;
            try {
                Arena.trace("HERE");
                url = new URL(temp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long fileSize = httpConnection.getContentLength();

            java.io.BufferedInputStream in = new java.io.BufferedInputStream(httpConnection.getInputStream());
            java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
            java.io.BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                final int currentProgress = (int) ((((double) downloadedFileSize) / ((double) fileSize)) * 100000d);

                // update progress bar
                progressBar.setProgress(currentProgress);

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

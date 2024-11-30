package hexlet.code.my_wave_app;

import hexlet.code.my_wave_app.model.AudioPlayer;
import javafx.animation.FillTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lombok.Setter;

@Setter
public class AudioPlayerUI {
    private AudioPlayer audioPlayer;


    @FXML
    private Button playButton;
    @FXML
    private Button favouritesButton;
    @FXML
    private Text trackText;
    @FXML
    private CubicCurve waveRectangle;

    private static FillTransition fillTransition;

    public void initialize() {
        fillTransition = new FillTransition(Duration.seconds(3), waveRectangle);
        fillTransition.setFromValue(Color.web("000000"));
        fillTransition.setToValue(Color.web("3e296a"));
        fillTransition.setCycleCount(FillTransition.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
    }

    public static void setGradientColors(Color[] colors) {
        if (fillTransition != null) {
            fillTransition.stop();
            fillTransition.setFromValue(colors[0]);
            fillTransition.setToValue(colors[1]);
            fillTransition.play();
        }
    }

    @FXML
    private void handleReturnClick() {
        audioPlayer.returnToWave();
    }

    @FXML
    private void handlePlayClick() {
        if (!audioPlayer.isPlaying()) {
            audioPlayer.playAll();
            playButton.getStyleClass().add("pressed");
            updateTrackTitle();
        }
    }

    @FXML
    private void handleNextClick() {
        if (audioPlayer.isPlaying()) {
            audioPlayer.playNextTrack();
            System.out.println(audioPlayer.getCurrentTrack().getCluster());
            System.out.println(audioPlayer.getCurrentTrack().getArtist());
            updateTrackTitle();

            if (!audioPlayer.getFavourites().contains(audioPlayer.getCurrentTrack())) {
                favouritesButton.getStyleClass().remove("pressed");
            }
            if (audioPlayer.getFavourites().contains(audioPlayer.getCurrentTrack())) {
                favouritesButton.getStyleClass().add("pressed");
            }
        }
    }

    @FXML
    private void handleFavouritesClick() {
        if (!audioPlayer.getFavourites().contains(audioPlayer.getCurrentTrack())) {
            audioPlayer.addToFavourites();
            favouritesButton.getStyleClass().add("pressed");
        }
        else  {
            audioPlayer.removeToFavourites();
            favouritesButton.getStyleClass().remove("pressed");
        }
    }

    private void updateTrackTitle() {
        trackText.setText(audioPlayer.getCurrentTrack().getArtist() + " - " + audioPlayer.getCurrentTrack().getTitle());
    }

}

package hexlet.code.my_wave_app;

import hexlet.code.my_wave_app.model.AudioPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Setter;

@Setter
public class AudioPlayerUI {
    private AudioPlayer audioPlayer;

    @FXML
    private Button playButton;

    @FXML
    private Button favouritesButton;

    @FXML
    private void handlePlayClick() {
        if (!audioPlayer.isPlaying()) {
            audioPlayer.playAll();
            playButton.getStyleClass().add("pressed");
        }
    }

    @FXML
    private void handleNextClick() {
        if (audioPlayer.isPlaying()) {
            audioPlayer.playNextTrack();
            System.out.println(audioPlayer.getCurrentTrack().getCluster());
            System.out.println(audioPlayer.getCurrentTrack().getArtist());

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

}

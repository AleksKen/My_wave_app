package hexlet.code.my_wave_app;

import hexlet.code.my_wave_app.model.AudioPlayer;
import javafx.fxml.FXML;
import lombok.Setter;

@Setter
public class AudioPlayerUI {
    private AudioPlayer audioPlayer;

    @FXML
    private void handlePlayClick() {
        if (!audioPlayer.isPlaying()) {
            audioPlayer.playAll();
        }
        else {
            audioPlayer.stop();
        }
    }

}

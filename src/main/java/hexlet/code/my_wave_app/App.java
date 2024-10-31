package hexlet.code.my_wave_app;

import hexlet.code.my_wave_app.database.LoadingFromDAO;
import hexlet.code.my_wave_app.model.AudioPlayer;
import hexlet.code.my_wave_app.model.Track;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {
    private static AudioPlayer audioPlayer;

    @Override
    public void start(Stage primaryStage) throws IOException {
        audioPlayer = AudioPlayer.getInstance(); // Получение единственного экземпляра
        List<Track> tracks = LoadingFromDAO.loadTracksFromDB();
        audioPlayer.loadTracks(tracks);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("page.fxml"));
        Parent root = loader.load();

        AudioPlayerUI controller = loader.getController();
        controller.setAudioPlayer(audioPlayer);

        primaryStage.setTitle("My Wave App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        audioPlayer = AudioPlayer.getInstance(); // Получение единственного экземпляра
        List<Track> tracks = LoadingFromDAO.loadTracksFromDB();
        audioPlayer.loadTracks(tracks);

        launch(args);
    }
}

package hexlet.code.my_wave_app;

import hexlet.code.my_wave_app.database.DataInitializer;
import hexlet.code.my_wave_app.model.AudioPlayer;
import hexlet.code.my_wave_app.model.Track;
import hexlet.code.my_wave_app.model.TrackDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;

public class App extends Application {
    private static AudioPlayer audioPlayer;

    @Override
    public void start(Stage primaryStage) throws IOException {
        audioPlayer = AudioPlayer.getInstance(); // Получение единственного экземпляра
        List<Track> tracks = loadTracksFromDB();
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
        List<Track> tracks = loadTracksFromDB();
        audioPlayer.loadTracks(tracks);

        launch(args);
    }

    private static List<Track> loadTracksFromDB() {
        try (var conn = DriverManager.getConnection("jdbc:h2:~/my_database")) {
            DataInitializer.init(conn);
            TrackDAO trackDAO = new TrackDAO(conn);
            return trackDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}

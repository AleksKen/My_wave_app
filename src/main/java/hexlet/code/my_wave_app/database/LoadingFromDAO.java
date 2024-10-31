package hexlet.code.my_wave_app.database;

import hexlet.code.my_wave_app.model.Track;

import java.sql.DriverManager;
import java.util.List;

public class LoadingFromDAO {

    public static List<Track> loadTracksFromDB() {
        try (var conn = DriverManager.getConnection("jdbc:h2:~/my_database")) {
            DataInitializer.init(conn);
            TrackDAO trackDAO = new TrackDAO(conn);
            return trackDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public static List<Track> loadTracksFavor(String cluster) {
        try (var conn = DriverManager.getConnection("jdbc:h2:~/my_database")) {
            DataInitializer.init(conn);
            TrackDAO trackDAO = new TrackDAO(conn);
            return trackDAO.find(cluster);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}

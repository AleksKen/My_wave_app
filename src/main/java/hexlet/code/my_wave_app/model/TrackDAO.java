package hexlet.code.my_wave_app.model;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackDAO {
    private final Connection connection;

    public TrackDAO(Connection conn) {
        connection = conn;
    }

    public Optional<Track> find(String title, String artist) throws SQLException {
        var sql = "SELECT file FROM tracks WHERE title = ? AND artist = ?;";
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, artist);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                File file = new File(resultSet.getString("file"));
                var track = new Track(title, artist, file);
                return Optional.of(track);
            }
            return Optional.empty();
        }
    }

    public List<Track> getAll() throws SQLException {
        var songs = new ArrayList<Track>();
        var sql = "SELECT * FROM tracks;";
        try (var stmt = connection.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var artist = resultSet.getString("artist");
                File file = new File(resultSet.getString("file"));
                var track = new Track(title, artist, file);
                songs.add(track);
            }
        }
        return songs;
    }
}



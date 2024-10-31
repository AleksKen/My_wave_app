package hexlet.code.my_wave_app.database;

import hexlet.code.my_wave_app.model.Track;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDAO {
    private final Connection connection;

    public TrackDAO(Connection conn) {
        connection = conn;
    }

    public List<Track> find(String cluster) throws SQLException {
        var songs = new ArrayList<Track>();
        var sql = "SELECT * FROM tracks WHERE cluster = ?;";
        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cluster);
            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var artist = resultSet.getString("artist");
                File file = new File(resultSet.getString("file"));
                var track = new Track(title, artist, file, cluster);
                songs.add(track);
            }
        }
        return songs;
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
                var cluster = resultSet.getString("cluster");
                var track = new Track(title, artist, file, cluster);
                songs.add(track);
            }
        }
        return songs;
    }
}



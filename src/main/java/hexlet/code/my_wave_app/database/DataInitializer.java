package hexlet.code.my_wave_app.database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

public class DataInitializer {
    public static void init(Connection connection) throws Exception {

        var path = Paths.get("/Users/mariakonasova/My_wave_app/init.sql");
        var sql = Files.readString(path);

        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            String csvFilePath = "/Users/mariakonasova/My_wave_app/src/main/resources/filtered_file.csv";
            //statement.execute("INSERT INTO tracks (title, artist, cluster) SELECT title, artist, cluster FROM CSVREAD('" + csvFilePath + "');");
        }
    }
}

package hexlet.code.my_wave_app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@EqualsAndHashCode
public class Track {
    private String title;
    private String artist;
    private File file;
    private String cluster;

    public Track(String title, String artist, File file, String cluster) {
        this.title = title;
        this.artist = artist;
        this.file = file;
        this.cluster = cluster;
    }

}

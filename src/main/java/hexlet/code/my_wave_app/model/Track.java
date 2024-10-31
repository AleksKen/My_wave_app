package hexlet.code.my_wave_app.model;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class Track {
    private String title;
    private String artist;
    private boolean isFavourite;
    private File file;

    public Track(String title, String artist, File file) {
        this.title = title;
        this.artist = artist;
        this.isFavourite = false;
        this.file = file;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

}

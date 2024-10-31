package hexlet.code.my_wave_app.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import lombok.Getter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AudioPlayer {
    private static AudioPlayer instance;
    private AdvancedPlayer player;
    private boolean isPlaying;
    private Thread playThread;
    private List<Track> tracks;
    private int currentTrackIndex;
    @Getter
    private Track currentTrack;
    private Favourites favourites;
    private static final Object playSignal = new Object();
    private boolean isPaused;


    private AudioPlayer() {
        this.isPlaying = false;
        this.tracks = new ArrayList<>();
        this.currentTrackIndex = -1;
        this.favourites = new Favourites();
    }



    public static synchronized AudioPlayer getInstance() {
        if (instance == null) {
            instance = new AudioPlayer();
        }
        return instance;
    }

    public void loadTracks(List<Track> tracks) {
        this.tracks = tracks;
        this.currentTrackIndex = 0;
    }

    public void playNextTrack() {
        if (isPlaying) {
            stopTrack();
        }
        isPlaying = true;
        Random random = new Random();
        currentTrackIndex = random.nextInt(tracks.size());
        currentTrack = tracks.get(currentTrackIndex);  // Установка текущего трека
        playTrack(currentTrack);
    }

    public void playAll() {
        if (!isPlaying) {
            playNextTrack();
        }
    }


    public void stopTrack() {
        if (player != null) {
            player.close();
            player = null;
            isPlaying = false;
        }
    }

    private void playTrack(Track track) {
        if (track == null) return;
        currentTrack = track;  // Установка текущего трека
        try {
            FileInputStream fileInputStream = new FileInputStream(track.getFile());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new AdvancedPlayer(bufferedInputStream);
            startMusicThread();
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
    }

    private void startMusicThread() {
        playThread = new Thread(() -> {
            try {
                if (isPaused) {
                    synchronized (playSignal) {
                        playSignal.wait();  // Ожидание возобновления
                    }
                    player.play(0, Integer.MAX_VALUE);
                } else {
                    player.play();
                }
            } catch (JavaLayerException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        playThread.start();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void addToFavourites() {
        if (currentTrack != null) {
            favourites.addOrRemTrack(currentTrack);
        }
    }
}

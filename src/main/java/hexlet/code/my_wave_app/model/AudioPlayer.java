package hexlet.code.my_wave_app.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AudioPlayer {
    private static AudioPlayer instance;
    private AdvancedPlayer player;
    private boolean isPlaying;
    private Thread playThread;
    private List<Track> tracks;
    int currentTrackIndex;
    Favourites favourites;

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
            stop();
        }
        isPlaying = true;
        Random random = new Random();
        currentTrackIndex = random.nextInt(tracks.size());
        Track currentTrack = tracks.get(currentTrackIndex);
        playTrack(currentTrack);
    }



    private void playTrack(Track track) {
        if (playThread != null && playThread.isAlive()) {
            stop();
        }
        playThread = new Thread(() -> {
            try (InputStream is = new FileInputStream(track.getFile())) {
                player = new AdvancedPlayer(is);
                player.play();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден: " + e.getMessage());
            } catch (JavaLayerException e) {
                System.out.println("Ошибка воспроизведения: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                isPlaying = false;
            }
        });
        playThread.start();
    }

    public void playAll() {
        if (!isPlaying) {
            playNextTrack();
        }
    }



    public void stop() {
        if (playThread != null && playThread.isAlive()) {
            isPlaying = false;
            playThread.interrupt();
            player.close();
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }


    public void addToFavourites() {
        favourites.addOrRemTrack(tracks.get(currentTrackIndex));
    }
}

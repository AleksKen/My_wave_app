package hexlet.code.my_wave_app.model;

import javafx.scene.paint.Color;

public class Utils {
    public static Color[] getColorsByCluster(Track track) {
        switch (track.getCluster()) {
            case "Кластер 2":
                return new Color[]{Color.web("#ffa3a3"), Color.web("#FF2C9B")}; // Нежный (розовый и малиновый)
            case "Кластер 1":
                return new Color[]{Color.web("#ff2929"), Color.web("#670000")}; // Секси (красный и черный)
            case "Кластер 3":
                return new Color[]{Color.web("#00e1ff"), Color.web("#ff57fc")}; // Веселый (голубой и розовый)
            case "Кластер 0":
                return new Color[]{Color.web("#ff2467"), Color.web("#ec8d0d")}; // Яркий (красный и оранжевый)
            case "Кластер 4":
                return new Color[]{Color.web("#4a4a4a"), Color.web("#d3d3d3")}; // Тоскливый (серый)
            default:
                return new Color[]{Color.web("#e4fbb6"), Color.web("#8dc819")}; // Спокойный (зеленый)
        }
    }

    public static String getNearCluster(String cluster) {
        return switch (cluster) {
            case "Кластер 0" -> "Кластер 2";
            case "Кластер 1" -> "Кластер 4";
            case "Кластер 2" -> "Кластер 0";
            case "Кластер 4" -> "Кластер 1";
            default -> null;
        };
    }
}


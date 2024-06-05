package interview.Honor;

import sun.java2d.pipe.SpanClipRenderer;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.Honor
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/05/16 20:23
 * @Version: 1.0
 */
public class Q3 {

    static class Song {
        String name;
        String style;
        int prefer;

        Song(String name, String style) {
            this.name = name;
            this.style = style;
            this.prefer = 0;
        }

    }

    private static void updatePrefer(Map<String, Song> songMap, Map<String, String> lastMap, Song currentSong, int d) {
        String style = currentSong.style;
        if (lastMap.containsKey(style)) {
            String lastName = lastMap.get(style);
            if (!lastName.equals(currentSong.name)) {
                for (Song song : songMap.values()) {
                    if (song.style.equals(style) && !song.name.equals(currentSong.name)) {
                        song.prefer += d;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> lastComp = new HashMap<>();
        Map<String, String> lastInter = new HashMap<>();
        Map<String, Song> songMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) break;

            String[] l = line.split(" ");
            String command = l[0];

            switch (command) {
                case "I":
                    String name = l[1];
                    String style = l[2];
                    songMap.put(name, new Song(name, style));
                    break;
                case "P":
                    name = l[1];
                    Song song = songMap.get(name);
                    song.prefer += 3;
                    updatePrefer(songMap, lastComp, song, 1);
                    lastComp.put(song.style, song.name);
                    break;
                case "B":
                    name = l[1];
                    song = songMap.get(name);
                    song.prefer -= 2;
                    updatePrefer(songMap, lastInter, song, -1);
                    lastInter.put(song.style, name);
                    break;
            }
        }

        List<Song> songList = new ArrayList<>(songMap.values());
        songList.sort((a, b) -> {
            if (b.prefer != a.prefer) {
                return b.prefer - a.prefer;
            }
            return a.name.compareTo(b.name);
        });

        for (Song song : songList) {
            System.out.println(song.name + " " + song.style);
        }

    }

}
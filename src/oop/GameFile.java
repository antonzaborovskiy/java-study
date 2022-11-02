package oop;

import oop.interfaces.GameFileInterface;
import oop.interfaces.ShortcutInterface;

public class GameFile extends File implements GameFileInterface {

    private String genre;

    public GameFile(int size, ShortcutInterface shortcut, String genre) {
        super(size, shortcut);
        this.genre = genre;
    }

    public String getGameName() {
        return this.getGameName();
    }

    public String getGenre() {
        return this.genre;
    }
}

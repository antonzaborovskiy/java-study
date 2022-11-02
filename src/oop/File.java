package oop;

import oop.interfaces.FileInterface;
import oop.interfaces.ShortcutInterface;

public class File implements FileInterface {

    private int size;
    private ShortcutInterface shortcut;

    public File(int size, ShortcutInterface shortcut) {
        this.size = size;
        this.shortcut = shortcut;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public ShortcutInterface getShortcut() {
        return this.shortcut;
    }

    protected String getName() {
        return this.getShortcut().getName();
    }
}

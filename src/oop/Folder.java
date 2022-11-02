package oop;

import oop.interfaces.FileInterface;
import oop.interfaces.FolderInterface;
import oop.interfaces.ShortcutInterface;

public class Folder implements FolderInterface {

    private int size;
    private FileInterface[] files;
    private ShortcutInterface shortcut;

    public Folder(int size, FileInterface[] files, ShortcutInterface shortcut) {
        this.size = size;
        this.files = files;
        this.shortcut = shortcut;
    }

    @Override
    public FileInterface[] getFiles() {
        return files;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public ShortcutInterface getShortcut() {
        return shortcut;
    }  
}

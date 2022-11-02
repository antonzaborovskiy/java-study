package oop;

import oop.interfaces.ShortcutInterface;

public class Shortcut implements ShortcutInterface {

    private int id;
    private String name;
    private String imageUrl;

    public Shortcut(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getImageUrl() {
        return this.imageUrl;
    }  
}

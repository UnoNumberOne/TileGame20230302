package gfx.assets;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class WorldTile {



    boolean isSolid;

    // on screen tile render size
    public static int defaultWorldTileWidth = 64, defaultWorldTileHeight = 64;

    protected BufferedImage texture;

    protected int id;

    public WorldTile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        isSolid = false;
    }

    protected void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, defaultWorldTileWidth, defaultWorldTileHeight, null);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public int getID() {
        return id;
    }

    public int getWorldTileWidth() {
        return defaultWorldTileWidth;
    }

    public int getWorldTileHeight() {
        return defaultWorldTileHeight;
    }


    public boolean isSolid()
    {
        return isSolid;
    }

    public void setSolid(boolean b)
    {
        isSolid = b;
    }
}















package gfx.utils;

import game.assets.World;
import gfx.assets.WorldTile;
import java.awt.image.BufferedImage;

public class ImageHandler {
    //singleton field
    //public static ImageHandler imageHandler = null;

    // actual pixel size of sprite on sheet
    private static final int SPRITE_TILE_WIDTH = 64, SPRITE_TILE_HEIGHT = 64;

    private WorldTile[] worldTileList;

    public ImageHandler() {
        worldTileList = new WorldTile[100];
        createWorldTiles();
    }

    /*
    // singleton constructor and getter
    private ImageHandler() {
        worldTileList = new WorldTile[1024];
        createWorldTiles();
    }

    public static ImageHandler getImageHandler() {
        if(imageHandler == null) {
            return new ImageHandler();
        }
        return imageHandler;
    }

     */
    private void createWorldTiles() {
        BufferedImage primaryColorSheet = ImageLoader.loadImage("/primary color spritesheet.png");

        BufferedImage white = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH,  0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile whiteTile = new WorldTile(white, 1);
        setWorldTile(whiteTile);

        BufferedImage clear = primaryColorSheet.getSubimage(0,  0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile clearTile = new WorldTile(clear, 0);
        setWorldTile(clearTile);

        BufferedImage black = primaryColorSheet.getSubimage(SPRITE_TILE_WIDTH*2,  0, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blackTile = new WorldTile(black, 2);
        setWorldTile(blackTile);

        BufferedImage red = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*2, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile redTile = new WorldTile(red, 3);
        setWorldTile(redTile);

        BufferedImage orange = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*3, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile orangeTile = new WorldTile(orange, 4);
        setWorldTile(orangeTile);

        BufferedImage yellow = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*4, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile yellowTile = new WorldTile(yellow, 5);
        setWorldTile(yellowTile);

        BufferedImage green = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*5, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile greenTile = new WorldTile(green, 6);
        setWorldTile(greenTile);

        BufferedImage seaGreen = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*6, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile seaGreenTile = new WorldTile(seaGreen, 7);
        setWorldTile(seaGreenTile);

        BufferedImage blue = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*7, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile blueTile = new WorldTile(blue, 8);
        setWorldTile(blueTile);

        BufferedImage darkBlue = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*8, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile darkBlueTile = new WorldTile(darkBlue, 9);
        darkBlueTile.setSolid(true);
        setWorldTile(darkBlueTile);

        BufferedImage purple = primaryColorSheet.getSubimage(0,  SPRITE_TILE_HEIGHT*9, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
        WorldTile purpleTile = new WorldTile(purple, 10);
        setWorldTile(purpleTile);
    }

    private void setWorldTile(WorldTile tile) {
        worldTileList[tile.getID()] = tile;
    }
    public WorldTile getWorldTile(int id) {
        return worldTileList[id];
    }

    public static int getSPRITE_TILE_WIDTH() {
        return SPRITE_TILE_WIDTH;
    }

    public static int getSPRITE_TILE_HEIGHT() {
        return SPRITE_TILE_HEIGHT;
    }
}

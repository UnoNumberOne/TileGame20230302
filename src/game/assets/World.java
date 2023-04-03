package game.assets;

import game.utils.FileToStringLoader;
import game.utils.WorldGenerator;
import gfx.assets.WorldTile;
import gfx.utils.CameraHandler;
import gfx.utils.ImageHandler;

import java.awt.Graphics;

public class World {

    // tbd into singleton
    private ImageHandler imageHandler;

    private int worldRows, worldCols;

    private WorldGenerator worldGenerator;

    private int[][] worldTileArray;

    /*
    private int[][] worldTileArray = {{1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 1, 1, 1},
                                      {1, 7, 1, 7, 1},
                                      {1, 1, 7, 1, 1},
                                      {1, 1, 1, 1, 1}};
     */

    public World(int worldRows, int worldCols) {
        this.worldRows = worldRows;
        this.worldCols = worldCols;

        worldGenerator = new WorldGenerator(worldRows, worldCols);
        imageHandler = new ImageHandler();

        worldTileArray = new int[worldRows][worldCols];

        loadWorld(worldGenerator.getWORLD_FULL_DIRECTORY_NAME());
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for (int r = 0; r < worldTileArray.length; r++) {
            for (int c = 0; c < worldTileArray[r].length; c++) {
                getWorldTile(r, c).render(g, c * WorldTile.defaultWorldTileWidth - CameraHandler.getxOffset(), r * WorldTile.defaultWorldTileHeight - CameraHandler.getyOffset());
            }
        }
    }

    public WorldTile getWorldTile(int r, int c) {
        WorldTile tile = imageHandler.getWorldTile(worldTileArray[r][c]);
        if (tile == null) {
            return imageHandler.getWorldTile(1);
        }
        return tile;
    }

    private void loadWorld(String path) {
        String file = FileToStringLoader.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        worldTileArray = new int[worldRows][worldCols];

        for (int r = 0; r < worldRows; r++) {
            for (int c = 0; c < worldCols; c++) {
                worldTileArray[r][c] = FileToStringLoader.parseInt(tokens[r + c * worldCols]);
            }
        }
    }

    public void writeValue(int row, int col, int value)
    {
        worldTileArray[row][col] = value;
    }

}
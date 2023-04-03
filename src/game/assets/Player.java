package game.assets;
import game.utils.KeyManager;
import gfx.assets.WorldTile;
import gfx.utils.CameraHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

import static gfx.assets.WorldTile.defaultWorldTileHeight;
import static gfx.assets.WorldTile.defaultWorldTileWidth;
public class Player
{
    WorldTile tile;
    int x, y;

    boolean turnModeOn = true;

    public Player(WorldTile tile)
    {
        this.tile = tile;

        this.x = 0;
        this.y = 0;
    }

    public void tick()
    {
        KeyManager.getKeyManager().tick();
        getInput();
    }

    public void render(Graphics g)
    {
        tile.render(g, x - CameraHandler.getxOffset(), y - CameraHandler.getyOffset());
    }

    public int getRow()
    {
        return x/tile.getWorldTileWidth();
    }

    public int getColumn()
    {
        return y/tile.getWorldTileHeight();
    }

    public int getXSpecial()
    {
        return x;
    }

    public int getYSpecial()
    {
        return y;
    }

    public void getInput()
    {
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_W))
        {
            y -= WorldTile.defaultWorldTileHeight;
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_A))
        {
            x -= WorldTile.defaultWorldTileWidth;
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_S))
        {
            y += WorldTile.defaultWorldTileHeight;
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_D))
        {
            x += WorldTile.defaultWorldTileWidth;
        }
        if(KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_P))
        {
            System.out.println("Column: " + getRow());
            System.out.println("Row: " + getColumn());
        }
    }
}

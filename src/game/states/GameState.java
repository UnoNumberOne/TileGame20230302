package game.states;

import java.awt.*;
import game.assets.Player;
import gfx.assets.WorldTile;
import gfx.utils.CameraHandler;
import gfx.utils.ImageHandler;
import game.assets.World;
import java.awt.event.KeyEvent;
import game.utils.KeyManager;

public class GameState extends State {
    World world;
    Player player;
    ImageHandler imageHandler;


    public GameState() {
        imageHandler = new ImageHandler();
        player = new Player(imageHandler.getWorldTile(3));

        world = new World(64, 64);

    }

    boolean button = false;

    public void tick() {
        player.tick();
        if (KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_Q)) {
            button = !button;
        }
        if (button == true) {
            world.writeValue(player.getColumn(), player.getRow(), (int) ((Math.random() * (1 - 5)) + 5));
        }
        if (KeyManager.getKeyManager().keyJustPressed(KeyEvent.VK_D))
        {
            if(!checkSolid(player.getYSpecial()/ WorldTile.defaultWorldTileWidth, (player.getXSpecial()+WorldTile.defaultWorldTileHeight)))
            {
                player.adjustX(WorldTile.defaultWorldTileWidth);
            }
        }


        CameraHandler.getCameraHandler().centerOnEntity(player);
    }


    public boolean checkSolid(int r, int c)
    {
        return world.getWorldTile(r, c).isSolid();
    }
    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}

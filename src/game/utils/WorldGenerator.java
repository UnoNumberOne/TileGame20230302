package game.utils;

public class WorldGenerator {

    public static int worldRows, worldColumns;
    private final long TIME_STAMP = System.nanoTime() % 1000000;
    private final String WORLD_FILE_NAME = "thisIsMyFileName_" + TIME_STAMP + ".txt";
    private final String WORLD_DIRECTORY = "res\\worlds\\";
    private final String WORLD_FULL_DIRECTORY_NAME = WORLD_DIRECTORY + WORLD_FILE_NAME;
    private int[][] worldMap2DArr;

    public WorldGenerator(int worldRows, int worldColumns) {
        this.worldRows = worldRows;
        this.worldColumns = worldColumns;

        worldMap2DArr = new int[worldRows][worldColumns];


        setWater();
        blackBorder();
        SeedDrop();
        buildIsland();
        setLand();

        FileGenerator.getFileGenerator().createFile(WORLD_FULL_DIRECTORY_NAME, FileGenerator.getFileGenerator().intArr2DToString(worldMap2DArr));

    }

    private void setWater()
    {
        for(int r = 0; r < worldMap2DArr.length; r++)
        {
            for(int c = 0; c < worldMap2DArr[r].length; c++)
            {
                worldMap2DArr[r][c] = getWaterIndex();
            }
        }
    }

    public void setLand()
    {
        for(int r = 0; r < worldMap2DArr.length; r++)
        {
            for (int c = 0; c < worldMap2DArr[r].length; c++)
            {
                if(worldMap2DArr[r][c] == 1)
                {
                    worldMap2DArr[r][c] = getGrassIndex();
                }
            }
        }
    }
    private int getGrassIndex()
    {
        return (int)((Math.random() * (6-4)) + 6);
    }
    public int getWaterIndex()
    {
        return (int)((Math.random() * (10-8)) + 8);
    }


    private void buildIsland() {
        for (int r = 0; r < worldMap2DArr.length; r++)
        {
            for (int c = 0; c < worldMap2DArr[r].length; c++)
            {
                if (worldMap2DArr[r][c] == 5)
                {
                    for (int i = -7; i <= 7; i++)
                    {
                        for (int j = -7; j <= 7; j++)
                        {
                            if(j > -4 && j < 4 && i> -4 && i< 4 )
                            {
                                if((Math.random() < .99))
                                {
                                    worldMap2DArr[r + i][c + j] = 1;
                                }
                            }
                            else
                            {
                                if((Math.random() < .70))
                                {
                                    worldMap2DArr[r + i][c + j] = 1;
                                }
                            }

                        }
                    }
                }
            }
        }
    }


    private void blackBorder()
    {
        for(int r = 0; r < worldMap2DArr.length; r++)
        {
            for(int c = 0; c < worldMap2DArr.length; c++)
            {
                if(r == 0 || c == 0 || r == worldMap2DArr[r].length - 1 || c == worldMap2DArr[c].length - 1)
                {
                    worldMap2DArr[r][c] = 2;
                }
            }
        }
    }

    public void SeedDrop()
    {
        for(int count = 0; count <= 5; count++)
        {
            int dropSeedR = (int)(Math.random()*(55-10)+10);
            int dropSeedL = (int)(Math.random()*(55-10)+10);
            worldMap2DArr[dropSeedL][dropSeedR] = 5;
        }
    }



    public String getWORLD_FULL_DIRECTORY_NAME() {
        return WORLD_FULL_DIRECTORY_NAME;
    }

}
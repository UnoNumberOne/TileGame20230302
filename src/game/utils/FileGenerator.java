package game.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public static FileGenerator fileGenerator = null;

    private final String mainDirectory;

    private FileGenerator() {
        mainDirectory = "C:\\Users\\urebustes\\IdeaProjects\\TileGame20230302\\";
    }

    public static FileGenerator getFileGenerator() {
        if(fileGenerator == null) {
            return new FileGenerator();
        }
        return fileGenerator;
    }

    public void createFile(String directory, String content) {
        try {
            File file = new File(mainDirectory+directory);
            if(file.createNewFile()) {
                System.out.println("file created " + file.getName());
            }
            else {
                System.out.println("file already exists");
            }

            FileWriter fileWriter = new FileWriter(directory);
            fileWriter.write(content);
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("error occurred when creating file");
            e.printStackTrace();
        }
    }

    public String intArr2DToString(int[][] arr2D) {
        String returnString = "";
        for(int[] tempArr: arr2D) {
            for(int temp: tempArr) {
                returnString += temp + " ";
            }
            returnString += "\n";
        }
        return returnString;
    }

}

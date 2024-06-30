package script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
    final static String SAVE_FOLDER = "Saves";

    public static void save(String gameData) {
        File saveFolder = new File(SAVE_FOLDER);
        if (!saveFolder.exists()) {
            saveFolder.mkdir();
        }
        SimpleDateFormat savedateformat = new SimpleDateFormat("yyyy-MM-dd-mmss");
        String dateString = savedateformat.format(new Date());
        // saves to file to the correct folder
        String filename = SAVE_FOLDER + File.separator + "save-" + dateString + ".txt";

        // Write the game data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(gameData);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game.");
            e.printStackTrace();
        }
    }

    public static boolean hasSaveFiles() {
        File folder = new File(SAVE_FOLDER);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            // Check if there are any files in the folder
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile()) {
                        return true;
                    }
                }
            }
        }
        return false; // no files fould
    }
}

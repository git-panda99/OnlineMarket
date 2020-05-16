package classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadWriteFile {
    private static String filePath = "database.txt";

    /*public ReadWriteFile(String filePath){
        this.filePath=filePath;
    }*/

    //Read file content into string, decode it to UserList (Array list) and return it
    public static ArrayList<User> readFile() {
        String content = "";
        Path pathToFile = Paths.get(filePath);
        System.out.println(pathToFile.toAbsolutePath());
        try {
            content = new String ( Files.readAllBytes( pathToFile ) );

        } catch (IOException e) {
            e.printStackTrace();
        }

        //decode JSON
        ArrayList<User> userList;
        Gson gson=new Gson();
        userList=gson.fromJson(content, new TypeToken<ArrayList<User>>(){}.getType());

        return userList;
    }

    //Write file from userList
    public static void writeFile(ArrayList<User> userList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            String content;

            //encodeJSON
            Gson gson=new Gson();
            content=gson.toJson(userList);

            bufferedWriter.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package services;

import javax.sql.rowset.serial.SerialException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class TodayTime {
    protected static final Path PATH = Paths.get("today.ser");
    public static void save(HashMap<String, String> hashMap) throws IOException {
        if (Files.notExists(PATH)){
            Files.createFile(PATH);
        }

        try (ObjectOutputStream ois = new ObjectOutputStream(Files.newOutputStream(PATH))){
            ois.writeObject(hashMap);
        }


        System.out.println("DATES SERIALIZED");

    }


    public static HashMap verify() throws IOException {
        if (Files.notExists(PATH)){
            throw new FileNotFoundException("File not found");
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(PATH))){
            Object o = ois.readObject();
            if (o instanceof HashMap<?,?> ){
                return (HashMap<?, ?>) o;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}

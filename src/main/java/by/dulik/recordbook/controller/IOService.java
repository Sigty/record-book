package by.dulik.recordbook.controller;

import by.dulik.recordbook.entity.User;
import by.dulik.recordbook.util.Message;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class IOService {

    private static IOService instance;

    public static synchronized IOService getInstance() {
        if (instance == null) {
            instance = new IOService();
        }
        return instance;
    }

    private IOService() {
    }

    private static final Charset ENCODING = UTF_8;
    private static final String FILEPATH = System.getProperty("user.dir");
    private static final String FILEPATH_SERIAL = System.getProperty("user.dir") + "\\recordBook";

    public void writeSetToFile(Set<User> serObj) {
        try (FileOutputStream fileOut = new FileOutputStream(FILEPATH_SERIAL);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(serObj);
            System.out.println("The Object was successfully written to file");
        } catch (FileNotFoundException e) {
            System.out.println(Message.EX_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Message.EX_NOT_WRITE);
        }
    }

    public Set<User> readSetToFile() {
        Set<User> openSet = null;
        File f = new File(FILEPATH_SERIAL);
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(f))) {
            openSet = (Set<User>) oos.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        } catch (FileNotFoundException e) {
            System.out.println(Message.EX_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Message.EX_NOT_READ);
        }
        return openSet;
    }

    void writeUserText(User user) {
        String pathSafe = FILEPATH + "\\" + user.getFirstName() + user.getLastName() + ".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathSafe), ENCODING)) {
            writer.write(user.toString());
            System.out.println(pathSafe);
        } catch (FileNotFoundException ex) {
            System.out.println(Message.EX_NOT_FOUND);
        } catch (IOException e) {
            System.out.println(Message.EX_NOT_WRITE);
        }
    }
}
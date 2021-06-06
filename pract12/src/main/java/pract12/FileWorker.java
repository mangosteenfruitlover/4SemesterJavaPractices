package pract12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

@Component
public class FileWorker {
    @Autowired
    private ApplicationArguments arguments;

    private String hashed;

    public FileWorker() {
        hashed = "";
    }

    @PostConstruct
    public void init() throws IOException {
        System.out.println(arguments.getNonOptionArgs());
        try(InputStream file = new FileInputStream(arguments.getNonOptionArgs().get(0))) {
            hashed = DigestUtils.md5DigestAsHex(file);

            File secondFile = new File(arguments.getNonOptionArgs().get(1));
            if(!secondFile.exists())
                secondFile.createNewFile();

            FileWriter writer = new FileWriter(secondFile);
            writer.write(hashed);
            writer.close();

        } catch (FileNotFoundException e) {
            File file = new File(arguments.getNonOptionArgs().get(1));
            if(!file.exists())
                file.createNewFile();

            FileWriter writer = new FileWriter(file);
            writer.write("null");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void deleteFirst(){
        File file = new File(arguments.getNonOptionArgs().get(0));

        if(file.exists()) {
            file.delete();
        }
    }
}

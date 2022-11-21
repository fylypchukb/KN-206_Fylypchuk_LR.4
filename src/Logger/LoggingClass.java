package Logger;

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingClass {
    public static Logger logger;

    public LoggingClass(){
        try(FileInputStream ins = new FileInputStream("log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(Main.class.getName());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

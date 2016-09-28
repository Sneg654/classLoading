
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;
import java.util.jar.JarFile;

/**
 * Created by Sergey_Stefoglo on 8/15/2016.
 */
public class Run {
    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Run.class);
    public final static String START_MESSAGE = "Enter 1- for invoke FirstClassForClassLoader,2-for invoke SecondClassForClassLoader\n" +
            "3- for invoke ThirdClassForClassLoader and Anything for invoke UnknownForClassLoader";
    private final static String LOAD_JAR = "Please set path to jar";
    private final static String EXIT_MESSAGE = "for change jar enter exit";

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);


        log.info(LOAD_JAR);
        while (sc.hasNextLine()) {
            String pathToJar = sc.nextLine();
            try (//for check type of file
                 JarFile jarFile = new JarFile(pathToJar)) {


                URLClassLoader loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                URLClassLoaderImpl l = new URLClassLoaderImpl(loader.getURLs());
                l.addURL(new URL("file:" + pathToJar));

                log.info(START_MESSAGE);

                while (sc.hasNextLine()) {
                    String value = sc.nextLine();
                    Class<?> messageClass = null;
                    Object obj;

                    if (value.equalsIgnoreCase("exit")) {
                        break;
                    }
                    switch (value) {
                        case "1":
                            messageClass = l.loadClass("jmp.task.classloading.FirstClassForClassLoader");
                            break;
                        case "2":
                            messageClass = l.loadClass("jmp.task.classloading.SecondClassForClassLoader");

                            break;
                        case "3":
                            messageClass = l.loadClass("jmp.task.classloading.ThirdClassForClassLoader");

                            break;
                        default:
                            messageClass = l.loadClass("jmp.task.classloading.UnknownForClassLoader");

                    }

                    obj = messageClass.newInstance();
                    Method myMethod = messageClass.getMethod("getMessage");


                    String returnValue = (String) myMethod.invoke(obj);

                    log.info(returnValue);
                    log.info(START_MESSAGE);
                    log.info(EXIT_MESSAGE);
                }
                log.info(LOAD_JAR);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.info(LOAD_JAR);
            }


        }


    }
}

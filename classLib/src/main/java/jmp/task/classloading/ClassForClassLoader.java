package jmp.task.classloading;

/**
 * Created by Sergey_Stefoglo on 8/15/2016.
 */
public interface ClassForClassLoader {
    String FIRST_MESSAGE = "It's First class";
    String SECOND_MESSAGE = "It's Second class";
    String THIRD_MESSAGE = "It's Third class";
    String UNKNOWN_MESSAGE = "It's Unknown class";

    String getMessage();
}

package jmp.task.classloading;

/**
 * Created by Sergey_Stefoglo on 8/15/2016.
 */
public class FirstClassForClassLoader implements ClassForClassLoader {
    public String getMessage(){
       return FIRST_MESSAGE;
    }


}

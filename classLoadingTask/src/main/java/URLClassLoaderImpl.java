import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Created by Sergey_Stefoglo on 8/25/2016.
 */
public class URLClassLoaderImpl extends URLClassLoader {
    public URLClassLoaderImpl(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void addURL(URL url) {
        super.addURL(url);
    }

    public URLClassLoaderImpl(URL[] urls) {
        super(urls);
    }

    public URLClassLoaderImpl(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public Class findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}

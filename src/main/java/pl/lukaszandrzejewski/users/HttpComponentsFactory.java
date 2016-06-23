package pl.lukaszandrzejewski.users;

import pl.lukaszandrzejewski.users.loader.HttpLoader;
import pl.lukaszandrzejewski.users.loader.Loader;
import pl.lukaszandrzejewski.users.parser.Parser;
import pl.lukaszandrzejewski.users.parser.UserJsonParser;

import java.net.URL;

public class HttpComponentsFactory implements ComponentsFactory {

    private URL url;

    public HttpComponentsFactory(URL url) {
        this.url = url;
    }

    @Override
    public Loader createLoader() {
        return new HttpLoader(url);
    }

    @Override
    public Parser<?> createParser() {
        return new UserJsonParser();
    }

}

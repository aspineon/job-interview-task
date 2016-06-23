package pl.lukaszandrzejewski.users;

import pl.lukaszandrzejewski.users.loader.Loader;
import pl.lukaszandrzejewski.users.parser.Parser;

public interface ComponentsFactory<T> {

    Loader createLoader();

    Parser<T> createParser();

}

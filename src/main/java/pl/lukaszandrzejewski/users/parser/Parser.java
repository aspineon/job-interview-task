package pl.lukaszandrzejewski.users.parser;

public interface Parser<T> {

    T parse(String text);

}
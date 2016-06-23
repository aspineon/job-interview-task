package pl.lukaszandrzejewski.users;

import pl.lukaszandrzejewski.users.loader.Loader;
import pl.lukaszandrzejewski.users.model.User;
import pl.lukaszandrzejewski.users.parser.Parser;

import java.net.MalformedURLException;
import java.net.URL;

public class App {

    private static final int USERS_LIMIT = 20;

    public static void main(String[] args) throws MalformedURLException {
        ComponentsFactory factory = new HttpComponentsFactory(new URL("http://api.randomuser.me/"));

        Parser<User> parser = factory.createParser();
        Loader loader = factory.createLoader();

        for (int counter = 0; counter < USERS_LIMIT; counter++) {
            String dataAsText = loader.loadData();
            User user = parser.parse(dataAsText);
            System.out.println(user);
            System.out.println(user.getGender().getDescription());
        }
    }

}

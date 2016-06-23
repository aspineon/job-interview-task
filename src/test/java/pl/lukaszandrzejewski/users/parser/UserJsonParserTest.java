package pl.lukaszandrzejewski.users.parser;

import org.junit.Before;
import org.junit.Test;
import pl.lukaszandrzejewski.users.model.Gender;
import pl.lukaszandrzejewski.users.model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

public class UserJsonParserTest {

    private User user = new User("enora", "fournier", Gender.FEMALE);
    private Parser<User> parser = new UserJsonParser();
    private String json;

    @Before
    public void setUp() throws IOException {
        json = new String(readAllBytes(getPath("user.json")), StandardCharsets.UTF_8);
    }

    @Test
    public void shouldParseJsonToUser() {
        assertEquals(user, parser.parse(json));
    }

    @Test(expected = ParseException.class)
    public void shouldThrowParseExceptionWhenKeyDoesNotExist() {
        parser.parse("{}");
    }

    private Path getPath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }

}

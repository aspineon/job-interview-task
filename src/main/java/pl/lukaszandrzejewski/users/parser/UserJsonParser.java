package pl.lukaszandrzejewski.users.parser;

import org.json.JSONException;
import org.json.JSONObject;
import pl.lukaszandrzejewski.users.model.Gender;
import pl.lukaszandrzejewski.users.model.User;

public class UserJsonParser implements Parser<User> {

    private static final int FIRST = 0;
    private static final String MAIN_KEY = "results";
    private static final String GENDER_KEY = "gender";
    private static final String NAME_KEY = "name";
    private static final String FIRST_NAME_KEY = "first";
    private static final String LAST_NAME_KEY = "last";

    @Override
    public User parse(String text) {
        try {
            JSONObject resultsJsonObject = new JSONObject(text);
            JSONObject userJsonObject = resultsJsonObject.getJSONArray(MAIN_KEY).getJSONObject(FIRST);
            JSONObject jsonNameObject = userJsonObject.getJSONObject(NAME_KEY);

            String gender = userJsonObject.getString(GENDER_KEY);
            String firstName = jsonNameObject.getString(FIRST_NAME_KEY);
            String lastName = jsonNameObject.getString(LAST_NAME_KEY);

            return new User(firstName, lastName, Gender.valueOf(gender.toUpperCase()));
        } catch (JSONException ex) {
            throw new ParseException(ex.getLocalizedMessage());
        }
    }

}

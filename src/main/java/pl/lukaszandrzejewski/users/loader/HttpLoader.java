package pl.lukaszandrzejewski.users.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.util.stream.Collectors.joining;

public class HttpLoader implements Loader {

    private URL url;

    public HttpLoader(URL url) {
        this.url = url;
    }

    @Override
    public String loadData() {
        HttpURLConnection urlConnection = openConnection();
        return readContent(urlConnection);
    }

    private String readContent(HttpURLConnection urlConnection) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.lines().collect(joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new LoadContentException();
        }
    }

    private HttpURLConnection openConnection() {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new ConnectionOpenException();
        }
    }

}

package pl.lukaszandrzejewski.users.loader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HttpLoaderTest {

    private String testData = "Test content";

    @Mock
    private HttpURLConnection urlConnection;

    @Before
    public void setUp() throws IOException {
        initMocks(this);
        InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
        when(urlConnection.getInputStream()).thenReturn(inputStream);
    }

    @Test
    public void shouldLoadContentFromServer() throws IOException {
        URL url = new URL(null, "http://localhost", getURLStreamHandlerStub());
        HttpLoader loader = new HttpLoader(url);
        assertEquals(testData, loader.loadData());
    }

    // stubbing URLStreamHandler since we can not mock final URL class
    private URLStreamHandler getURLStreamHandlerStub() {

        return new URLStreamHandler() {

            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return urlConnection;
            }

        };

    }

}

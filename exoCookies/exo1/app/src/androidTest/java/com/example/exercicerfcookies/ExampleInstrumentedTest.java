package com.example.exercicerfcookies;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.exercicerfcookies.http.RetrofitCookie;
import com.example.exercicerfcookies.http.cookieService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.exercicerfcookies", appContext.getPackageName());
    }

    @Test
    public void testSimple() throws IOException {
        cookieService service = RetrofitCookie.get();
        for (int i = 0 ; i < 10 ; i++) {

            Call<String> call = service.cookieEcho();
            Response<String> response = call.execute();
            String resultat = response.body();
            Log.i("RETROFIT", resultat);
        }
    }
}
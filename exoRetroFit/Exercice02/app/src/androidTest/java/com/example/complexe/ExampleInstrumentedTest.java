package com.example.complexe;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.complexe.Transfer.objtransferer;
import com.example.complexe.http.RetrofitUtil;
import com.example.complexe.http.Service;

import java.io.IOException;
import java.util.List;

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
    public void testStructures() throws IOException {
        Service service = RetrofitUtil.get();
        Call<objtransferer> call = service.getObj("rayane");
        Response<objtransferer> response = call.execute();
        objtransferer resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}
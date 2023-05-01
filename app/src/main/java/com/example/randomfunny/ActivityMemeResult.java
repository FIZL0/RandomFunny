package com.example.randomfunny;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomfunny.networking.MemeResult;
import com.example.randomfunny.networking.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMemeResult extends AppCompatActivity {

    ImageView memeOutput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_image);

        memeOutput = findViewById(R.id.memeOutput);

        getMeme();
    }

    private void getMeme() {
        Call<MemeResult> apiCall = RetrofitClient.getInstance().getApis().getMemes();
        apiCall.enqueue(new Callback<MemeResult>() {
            @Override
            public void onResponse(Call<MemeResult> call, Response<MemeResult> response) {
                MemeResult memeResults = response.body();

                String title = memeResults.getTitle();
                String url = memeResults.toString();

                TextView memeTitle = findViewById(R.id.memeTitle);
                memeTitle.setText(title);

                Picasso.get().load(url).into(memeOutput);

            }

            @Override
            public void onFailure(Call<MemeResult> call, Throwable t) {
                Toast.makeText(ActivityMemeResult.this, "Unable to get meme, check internet connection. Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


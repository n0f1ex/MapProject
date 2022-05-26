package com.example.mapproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.maps.UiSettings;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.storage.FirebaseStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

public class Dictionary extends AppCompatActivity {
    String filis;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ListView listView = findViewById(R.id.listView);

// определяем строковый массив
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("dict").toString();
        /*String fileStr = (String)getIntent().getSerializableExtra("FILES_LIST");
        String fileName = fileStr + ".txt";
        String content = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String value = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        FirebaseStorage storage = FirebaseStorage.getInstance();
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
        String[] Names = new String[]{"Увы, пока что тут ничего нет"};
        switch (name){
            case "Батарейки":
                filis = getResources().getString(R.string.Батарейки);
                Names = getResources().getString(R.string.textБатарейки).split("///");
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                break;
            case "Дерево":
                filis = getResources().getString(R.string.Дерево);
                Names = getResources().getString(R.string.textДерево).split("///");
                break;
            case "Стекло":
                filis = getResources().getString(R.string.Стекло);
                Names = getResources().getString(R.string.textСтекло).split("///");
                break;
            case "Макулатура":
                filis = getResources().getString(R.string.Макулатура);
                Names = getResources().getString(R.string.textМакулатура).split("///");
                break;
            case "Пластик":
                filis = getResources().getString(R.string.Пластик);
                Names = getResources().getString(R.string.textПластик).split("///");
            case "Ртутосодержащие предметы":
                filis = getResources().getString(R.string.Ртутосодержащие);
                Names = getResources().getString(R.string.textРтутосодержащие).split("///");
                break;
            case "Металлы":
                filis = getResources().getString(R.string.Металлы);
                Names = getResources().getString(R.string.textМеталлы).split("///");
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Names);
        listView.setAdapter(adapter);
        final Button button = findViewById(R.id.butt);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent();
                intent.putExtra("info", filis);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Создание выпадающего меню
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /*private class CodeAdapter extends ArrayAdapter<String> {

        CodeAdapter(Context context, int textViewResourceId,
                      String[] objects) {
            super(context, textViewResourceId, objects);

        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Переадресация в меню
        switch(id){
            case R.id.chart :
                Intent intent = new Intent(Dictionary.this, MapsActivity.class);
                startActivity(intent);
                return true;
            case R.id.wiki:
                Intent intent_ = new Intent(Dictionary.this, WikiActivity.class);
                startActivity(intent_);
                return true;
            case R.id.exit:
                finish();
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
}
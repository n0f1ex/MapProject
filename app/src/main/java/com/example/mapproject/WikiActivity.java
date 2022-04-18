package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

public class WikiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wikilayout);
        ListView listView = findViewById(R.id.listView);

// определяем строковый массив
        String filename = "materials.txt";
        String text = readFile(filename);
// используем адаптер данных
        final String[] Names = {"Батарейки", "Дерево", "Стекло", "Макулатура", "Пластик", "Ртутосодержащие предметы", "Металлы"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(WikiActivity.this, Dictionary.class);
                switch(position) {
                    case 0:
                        intent.putExtra("dict", "Батарейки");
                        break;
                    case 1:
                        intent.putExtra("dict", "Дерево");
                        break;
                    case 2:
                        intent.putExtra("dict", "Стекло");
                        break;
                    case 3:
                        intent.putExtra("dict", "Макулатура");
                        break;
                    case 4:
                        intent.putExtra("dict", "Пластик");
                        break;
                    case 5:
                        intent.putExtra("dict", "Ртутосодержащие предметы");
                        break;
                    case 6:
                        intent.putExtra("dict", "Металлы");
                        break;
                }
                startActivityForResult(intent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String inf = data.getStringExtra("info");
        Intent intent = new Intent(WikiActivity.this, MapsActivity.class);
        intent.putExtra("map", inf);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Создание выпадающего меню
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Переадресация в меню
        switch(id){
            case R.id.chart :
                Intent intent = new Intent(WikiActivity.this, MapsActivity.class);
                intent.putExtra("map", "///");
                startActivity(intent);
                return true;
            case R.id.wiki:

                return true;
            case R.id.exit:
                finish();
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    private String readFile(String fileName) {
        /*
         * Аналогично создается объект файла
         */
        StringBuilder stringBuilder = new StringBuilder();
        File myFile = new File(Environment.getExternalStorageDirectory().toString() + "/" + fileName);
        try {
            FileInputStream inputStream = new FileInputStream(myFile);
            /*
             * Буфферезируем данные из выходного потока файла
             */
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            /*
             * Класс для создания строк из последовательностей символов
             */
            String line;
            try {
                /*
                 * Производим построчное считывание данных из файла в конструктор строки,
                 * Псоле того, как данные закончились, производим вывод текста в TextView
                 */
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "123321");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
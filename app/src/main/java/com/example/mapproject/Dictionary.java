package com.example.mapproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

public class Dictionary extends AppCompatActivity {
    String filis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ListView listView = findViewById(R.id.listView2);

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
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
        String[] Names = new String[]{"Увы, пока что тут ничего нет"};
        switch (name){
            case "Батарейки":
                filis = "ул. Тимашевская, 99в/// " +
                        "54.8465972/// 56.1466733/// " +
                        "ул.Рихарда Зорге, 17/1, Офис 303/// " +
                        "54.7529921/// 55.9835734/// " +
                        "ул. Путейская, 25/// " +
                        "54.8360377/// 56.0989059/// " +
                        "улица Маршала Жукова 29 ТЦ Простор/// " +
                        "54.7717116/// 56.0567189/// ";
                Names = new String[]{"Свинцово-кислотный аккумулятор(Автомобильные аккумуляторы)",
                        "Щелочная батарейка(alkaline)", "Никель-кадмиевый аккумулятор (NiCd)",
                        "Никель-металлогидридный аккумулятор (Ni-MH или NiMH)",
                        "Литий-ионный аккумулятор(Батареи мобильных телефонов, переносные зарядные устройства)"};
                break;
            case "Дерево":
                filis = "ул. Трамвайная, 9/// "+
                        "54.7990325/// 56.077904/// "+
                        "Сафроновский пр-д, 53/// "+
                        "54.7534171/// 55.9618593/// "+
                        "ул. Генерала Горбатова, 3/1А/// "+
                        "54.7183901/// 56.0077294/// ";
                break;
            case "Стекло":
                filis = "ул. Комсомольская, 167/1/// "+
                        "54.767331/// 56.0251666/// "+
                        "ул. Генерала Горбатова, 3/1А/// "+
                        "54.7183901/// 56.0077294/// "+
                        "ул. Ульяновых, 83/// "+
                        "54.83758/// 56.0891755/// ";
                break;
            case "Макулатура":
                filis = "ул. Степана Кувыкина, 102/// "+
                        "54.7134716/// 56.0038224/// "+
                        "Силикатная ул., 17/2/// "+
                        "54.746131/// 55.9125561/// "+
                        "ул. Бирский тракт, 3, к1/// "+
                        "54.8914686/// 56.087794/// ";
                break;
            case "Пластик":
                filis = "ул. Чайковского, 7/// "+
                        "54.7899003/// 56.052621/// "+
                        "ул. Кольская, 46литА/// "+
                        "54.7758287/// 56.0396909/// "+
                        "ул. Собинова, 22/// "+
                        "54.7478026/// 55.9673612/// ";
                break;
            case "Ртутосодержащие предметы":
                filis = "ул. Заки Валиди, 64/1/// "+
                        "54.7149781/// 55.9535853/// "+
                        "ул. 50 лет СССР, 46/// "+
                        "54.7461813/// 56.0222557/// "+
                        "ул. пр-т. Октября, 71а/// "+
                        "54.76712/// 56.0106495/// ";
                Names = new String[]{"Примеры домашних приборов содержащих ртуть",
                        "Люминесцентные лампы. Эти осветительные приборы для жилья, офиса и улиц выпускают десятками миллионов ежегодно. При этом в одной такой лампе содержится от 20 до 100 мг ртути.",
                        "Термометры и терморегуляторы. Хотя ртутные термометры понемногу уходят в прошлое, в России их насчитывается еще десятки миллионов. Это самые частые приборы. Они содержат до 20 г ртути.",
                        "Барометры и манометры. Профессиональные точные приборы для измерения атмосферного давления и давления в промышленных и иных установках содержат в зависимости от модели до 2 кг ртути.",
                        "Ртутные лампы. Существуют технические и медицинские модели. Их используют для обеззараживания производственных и лечебных помещений. Такие лампы содержат до 500 мг металлической ртути.",
                        "Выключатели и переключатели. Некоторые модели таких устройств заполнены ртутью и содержат ее в количестве нескольких граммов. Данные приборы установлены на производстве и даже в быту."};
                break;
            case "Металлы":
                filis = "ул. Бабушкина, 25/// "+
                        "54.743104/// 55.9842333/// "+
                        "ул. Юбилейная, 19/1/// "+
                        "54.8562999/// 56.0837268/// "+
                        "ул. Комсомольская, 83/// "+
                        "54.7515871/// 56.0024408/// "+
                        "ул. Усольская, 19/// "+
                        "54.7053168/// 55.9687941/// ";
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
                intent.putExtra("info", filis.toString());
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

    /*@NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = getLayoutInflater();
        View row = inflater.inflate(R.layout.list_item, parent, false);
        TextView label = (TextView) row.findViewById(R.id.text_view_zodiac);
        label.setText(mZodiacSigns[position]);
        ImageView iconImageView = (ImageView) row.findViewById(R.id.image_view_icon);
        // Если текст содержит кота, то выводим значок Льва (лев - это кот!)
        if (mZodiacSigns[position].equalsIgnoreCase("Лев")) {
            iconImageView.setImageResource(R.drawable.lion);
        } else {
            iconImageView.setImageResource(R.mipmap.ic_launcher);
        }
        return row;
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
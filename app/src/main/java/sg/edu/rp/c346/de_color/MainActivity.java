package sg.edu.rp.c346.de_color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed,edPosition;
    Button bt,btremove,btupdate;
    ListView lv;
    ArrayAdapter aaColour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.editTextColour);
        bt = findViewById(R.id.buttonAddItem);
        lv = findViewById(R.id.listViewColour);
        edPosition = findViewById(R.id.edPosition);
        btremove = findViewById(R.id.buttonRemove);
        btupdate = findViewById(R.id.buttonUpdate);

        final ArrayList<String> colour = new ArrayList<>();
        colour.add("Red");
        colour.add("Orange");

        aaColour = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,colour);
        lv.setAdapter(aaColour);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(edPosition.getText().toString());
                colour.add(position-1,ed.getText().toString());
                aaColour.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String select = lv.getAdapter().getItem(position).toString();
                Toast.makeText(MainActivity.this,select,Toast.LENGTH_SHORT).show();

            }
        });

        btremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colours = ed.getText().toString();
                int position = Integer.parseInt(edPosition.getText().toString());
                colour.remove(position-1);
                aaColour.notifyDataSetChanged();

            }
        });

        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colours = ed.getText().toString();
                int position = Integer.parseInt(edPosition.getText().toString());
                colour.set(position-1,colours);
                aaColour.notifyDataSetChanged();
            }
        });



    }
}

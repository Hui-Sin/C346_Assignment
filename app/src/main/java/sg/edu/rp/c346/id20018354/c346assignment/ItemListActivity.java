package sg.edu.rp.c346.id20018354.c346assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    EditText itemIndex,itemExpiryDate;
    Button btnadd,btnedit,btndelete;
    ListView item;
    Spinner sortdate;
    ArrayList<String> itemList;
    private static final String TAG ="ItemListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        itemIndex=findViewById(R.id.editTextItemindex);
        itemExpiryDate=findViewById(R.id.editTextExpiryDate);
        btnadd=findViewById(R.id.buttonAdd);
        btnedit=findViewById(R.id.buttonEdit);
        btndelete=findViewById(R.id.buttonDelete);
        item=findViewById(R.id.ToDoList);
        sortdate=findViewById(R.id.spinner);

        itemList=new ArrayList<String>();
        ArrayAdapter<String> list = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,itemList);
        item.setAdapter(list);


        sortdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newitem=itemExpiryDate.getText().toString();
                itemList.add(newitem);
                list.notifyDataSetChanged();
                itemExpiryDate.setText("");
                Collections.sort(itemList);
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newitem=itemExpiryDate.getText().toString();
                if (itemList.size() == 0) {
                    Toast.makeText(getApplicationContext(), "You don't have any item to edit", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    int index = Integer.parseInt(itemIndex.getText().toString());
                    if (itemList.size() <= index) {
                        Toast.makeText(ItemListActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        if (index==itemList.indexOf(index)){
                            itemExpiryDate.setText(newitem);
                            list.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemList.size() == 0) {
                    Toast.makeText(getApplicationContext(), "You don't have any item to remove", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    int index = Integer.parseInt(itemIndex.getText().toString());
                    if (itemList.size() <= index) {
                        Toast.makeText(ItemListActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        itemList.remove(index);
                        list.notifyDataSetChanged();
                        itemIndex.setText(null);
                    }
                }
            }
        });
    }
}
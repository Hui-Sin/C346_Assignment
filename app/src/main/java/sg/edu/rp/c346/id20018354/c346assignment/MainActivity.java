//Lim Hui Sin
//20018354
package sg.edu.rp.c346.id20018354.c346assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openApp;
    Button openWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openApp=findViewById(R.id.App);
        openWeb=findViewById(R.id.website);
        openApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
        openWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Hui-Sin/C346_Assignment"));
                startActivity(intentView);
            }
        });
    }
}
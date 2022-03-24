package mx.edu.greengates.ane.computerscienceiastudymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnSave = (Button) findViewById(R.id.btSave2);
        btnSave.setOnClickListener((View.OnClickListener) this);

    }
    public void onClick(View v) {
        if (v == btnSave) {
            Intent myIntent = new Intent(AddTaskActivity.this, MainActivity.class);
            myIntent.putExtra("progress", 50); //Optional parameters
            AddTaskActivity.this.startActivity(myIntent);
        }
    }

}
package mx.edu.greengates.ane.computerscienceiastudymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.edu.greengates.ane.computerscienceiastudymanagement.model.StudyManagement;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StudyManagement management = (StudyManagement) getApplicationContext();
        fillStudyManagement(management);
        btnAdd = (Button) findViewById(R.id.btAdd);
        btnAdd.setOnClickListener((View.OnClickListener) this);
        btnStart = (Button) findViewById(R.id.btStart);
        btnStart.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view) {
        if (view == btnAdd) {
            Intent myIntent = new Intent(MainActivity.this, AddTaskActivity.class);
            myIntent.putExtra("progress", 50); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
        if (view
                == btnStart) {
            Intent myIntent = new Intent(MainActivity.this, AddTaskActivity.class);
            myIntent.putExtra("progress", 50); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
    }

    private void fillStudyManagement (StudyManagement management) {

    }
}
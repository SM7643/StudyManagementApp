package mx.edu.greengates.ane.computerscienceiastudymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        btnStart = (Button) findViewById(R.id.btStart2);
        btnStart.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {
        if (v == btnStart) {
            Intent myIntent = new Intent(StudyActivity.this, MainActivity.class);
            myIntent.putExtra("progress", 50); //Optional parameters
            StudyActivity.this.startActivity(myIntent);
        }
    }
}
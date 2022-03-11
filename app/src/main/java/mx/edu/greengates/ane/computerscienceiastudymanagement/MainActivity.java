package mx.edu.greengates.ane.computerscienceiastudymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StudyManagement management = (StudyManagement) getApplicationContext();
        fillStudyManagement(management);
    }

    private void fillStudyManagement (StudyManagement management) {

    }
}
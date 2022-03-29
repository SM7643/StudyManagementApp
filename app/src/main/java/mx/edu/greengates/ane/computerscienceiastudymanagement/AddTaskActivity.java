package mx.edu.greengates.ane.computerscienceiastudymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import mx.edu.greengates.ane.computerscienceiastudymanagement.model.StudyManagement;
import mx.edu.greengates.ane.computerscienceiastudymanagement.model.Task;
import mx.edu.greengates.ane.computerscienceiastudymanagement.persistence.CSVReader;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText Task;
    private CalendarView Calendar;
    private EditText Hours;
    private Spinner Spinner;
    private TextView Date;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final StudyManagement management = (StudyManagement) getApplicationContext();

        btnSave = (Button) findViewById(R.id.btSave2);
        btnSave.setOnClickListener((View.OnClickListener) this);
        Task = (EditText) findViewById(R.id.eTTask);
        Calendar = (CalendarView) findViewById(R.id.calendarView);
        Hours = (EditText) findViewById(R.id.eTHours);
        Spinner = (android.widget.Spinner) findViewById(R.id.spinner);
        Date = (TextView) findViewById(R.id.tVDD2);

        CalendarView.OnDateChangeListener listener = new CalendarListener(Date);
        Calendar.setOnDateChangeListener(listener);

        CSVReader fileReader = new CSVReader(this);
        List<String> rewardsFromCSV = fileReader.readRewardsFromCSV();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTaskActivity.this,
                android.R.layout.simple_spinner_item,rewardsFromCSV);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);
        Spinner.setOnItemSelectedListener(this);

    }

    private void fillStudyManagement(StudyManagement management) {
    }

    public void onClick(View view) {
        if (view == btnSave) {
            long dueDateCal = Calendar.getDate();
            Date dueDate = new Date(dueDateCal);
            String studyHoursText = Hours.getText().toString();
            long studyHours = Long.parseLong(studyHoursText);
            String taskName = Task.getText().toString();

            mx.edu.greengates.ane.computerscienceiastudymanagement.model.Task task = new Task(taskName, dueDate, studyHours);
            StudyManagement.insertTask(task);

            Intent myIntent = new Intent(AddTaskActivity.this, MainActivity.class);
            myIntent.putExtra("progress", 50); //Optional parameters
            AddTaskActivity.this.startActivity(myIntent);
        }
    }

}

class CalendarListener implements CalendarView.OnDateChangeListener {

    TextView textView;

    CalendarListener(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "-" + (month + 1) + "-" + year;
        this.textView.setText(date);
    }
}
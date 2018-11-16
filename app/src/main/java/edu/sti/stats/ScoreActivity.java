package edu.sti.stats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_main);

        String[] subjectSpinner = new String[] {
                "MathPlus", "EnglishMinus", "Science"
        };
        Spinner spinner_subject = (Spinner) findViewById(R.id.spinner_subject);
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjectSpinner);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_subject.setAdapter(subjectAdapter);

        String[] sectionSpinner = new String[] {
                "BSIT4101", "HRM4101"
        };
        Spinner spinner_section = (Spinner) findViewById(R.id.spinner_section);
        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sectionSpinner);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_section.setAdapter(sectionAdapter);

        String[] periodSpinner = new String[] {
                "Prelim", "Midterm", "Prefinal","Final"
        };
        Spinner spinner_period = (Spinner) findViewById(R.id.spinner_period);
        ArrayAdapter<String> periodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, periodSpinner);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_period.setAdapter(periodAdapter);

        EditText search = (EditText) findViewById(R.id.search) ;
        search.setSelected(false);

        ListView studentlist = (ListView) findViewById(R.id.studentlist);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Carl Alexson Patan-ao");
        arrayList.add("Micky Mojado");
        arrayList.add("Kim Hermano");
        arrayList.add("Renato Singcol Jr.");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        studentlist.setAdapter(arrayAdapter);

        /*View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm  = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }*/
    }
}

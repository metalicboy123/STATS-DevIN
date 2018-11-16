package edu.sti.stats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String[] sectionSpinnerString = new String[] {
                "BSIT", "HRM", "Tourism"
        };
        Spinner sectionSpinner = (Spinner) findViewById(R.id.section);
        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sectionSpinnerString);
        sectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectionSpinner.setAdapter(sectionAdapter);

        String[] subjectSpinnerString = new String[] {
                "MathPlus", "EnglishMinus", "Science"
        };
        Spinner subjectSpinner = (Spinner) findViewById(R.id.subject);
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjectSpinnerString);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);

        String[] classcodeSpinnerString = new String[] {
                "Aleg1", "Technop", "ITS"
        };
        Spinner classcode = (Spinner) findViewById(R.id.classcode);
        ArrayAdapter<String> classcodeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, classcodeSpinnerString);
        classcodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classcode.setAdapter(classcodeAdapter);

        String HTML_studentGradeDetails = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title></title>\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\ttable {\n" +
                "\t\t    border-collapse: collapse;\n" +
                "\t\t    font-size: 120%;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ttable, th, td {\n" +
                "\t\t\tpadding: 10px;\n" +
                "\t\t    border: 1px solid black;\n" +
                "\t\t}\n" +
                "\t\t.number{\n" +
                "\t\t\ttext-align: right;\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<center><table style=\"\">\n" +
                "\t\t<thead>\n" +
                "\t\t\t<th>Title</th>\n" +
                "\t\t\t<th>Component</th>\n" +
                "\t\t\t<th>Average</th>\n" +
                "\t\t\t<th>Failed</th>\n" +
                "\t\t</thead>\n" +
                "\t\t<tbody>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Fractions</td>\n" +
                "\t\t\t\t<td class='number'>Quiz</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(0, 255, 0);text-align: left; width: 400px;\">80%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>4</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Spelling</td>\n" +
                "\t\t\t\t<td class='number'>Quiz</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(0, 255, 0);text-align: left; width: 500px;\">100%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>3</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Long Quiz</td>\n" +
                "\t\t\t\t<td class='number'>Quiz</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(0, 255, 0);text-align: left; width: 425px;\">85%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>3</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Binomials</td>\n" +
                "\t\t\t\t<td class='number'>Assignment</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(255, 0 , 0);text-align: left; width: 375px;\">75%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>4</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Spelling</td>\n" +
                "\t\t\t\t<td class='number'>Quiz</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(0, 255, 0);text-align: left; width: 425px;\">85%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>3</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class='number'>Long Quiz</td>\n" +
                "\t\t\t\t<td class='number'>Quiz</td>\n" +
                "\t\t\t\t<td>\n" +
                "\t\t\t\t\t<h2 style=\"background-color:rgb(0, 255, 0);text-align: left; width: 425px;\">85%<br></h2>\n" +
                "\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t\t<td class='number'>0</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</tbody>\n" +
                "\t</table></center>\n" +
                "</body>\n" +
                "</html>";

        WebView webViewScores = (WebView) findViewById(R.id.webViewScores);
        webViewScores.loadData(HTML_studentGradeDetails, "text/html; charset=UTF-8", null);
    }
}

package edu.sti.stats;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.Date;

class ReminderClass{

    int id;

    String subject;
    String time;
    String date;
    String location;
    String agenda;


    public ReminderClass(int id,String subject,String time,String date,String location,String agenda){
        this.id = id;
        this.subject = subject;
        this.time = time;
        this.date = date;
        this.location = location;
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }



}
class ReminderListAdapter extends BaseAdapter{

    Context context;
    ArrayList<ReminderClass> reminderList;

    public ReminderListAdapter(Context context, ArrayList<ReminderClass> reminderList){
        this.context = context;
        this.reminderList = reminderList;
    }

    @Override
    public int getCount() {
        return reminderList.size();
    }

    @Override
    public Object getItem(int i) {
        return reminderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return reminderList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.fragment_reminder,null);

        ((TextView)view.findViewById(R.id.title)).setText(reminderList.get(i).getSubject());
        ((TextView)view.findViewById(R.id.subtitle)).setText(reminderList.get(i).getLocation());
        ((TextView)view.findViewById(R.id.day)).setText(reminderList.get(i).getTime());
        ((TextView)view.findViewById(R.id.date)).setText(reminderList.get(i).getDate());
        return view;
    }
}
class TodoClass{
    int id;
    String title;
    String subtitle;
    String day;
    String date;

    public TodoClass(int id,String title,String subtitle,String day,String date){
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.day = day;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
class TodoListAdapter extends BaseAdapter{
    Context context;
    ArrayList<TodoClass> todoList;

    public TodoListAdapter(Context context, ArrayList<TodoClass> todoList){
        this.context = context;
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int i) {
        return todoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return todoList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.todo_listview_layout,null);

        ((TextView)view.findViewById(R.id.title)).setText(todoList.get(i).getTitle());
        ((TextView)view.findViewById(R.id.subtitle)).setText(todoList.get(i).getSubtitle());
        ((TextView)view.findViewById(R.id.date)).setText(todoList.get(i).getDate());
        ((TextView)view.findViewById(R.id.time)).setText(todoList.get(i).getDay());

        return view;
    }
}
class StudentUpdateClass{

    int id;
    String name,subject,remarks;
    public StudentUpdateClass(int id,String name, String subject,String remarks){
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
class StudentListAdapter extends BaseAdapter{

    Context context;
    ArrayList<StudentUpdateClass> studentList;

    public StudentListAdapter(Context context, ArrayList<StudentUpdateClass> studentList){
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return studentList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.student_update_list_layout,null);
        ((TextView)view.findViewById(R.id.studentName)).setText(studentList.get(i).getName());
        ((TextView)view.findViewById(R.id.studentSubject)).setText(studentList.get(i).getSubject());
        ((TextView)view.findViewById(R.id.studentRemarks)).setText(studentList.get(i).getRemarks());
        return view;
    }
}

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    View contentView;
    ListView reminderListView;
    ReminderListAdapter reminderListAdapter;
    ArrayList<ReminderClass> reminderClass = new ArrayList<>();
    Firebase myFirebase;

    ListView todoListView;
    TodoListAdapter todoListAdapter;
    ArrayList<TodoClass> todoClass = new ArrayList<>();

    ListView studentListView;
    StudentListAdapter studentListAdapter;
    ArrayList<StudentUpdateClass> studentUpdateClass = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Firebase.setAndroidContext(getActivity());
        myFirebase = new Firebase("https://statsreminders.firebaseio.com/");

        contentView = inflater.inflate(R.layout.fragment_dashboard,null);

        reminderListView = (ListView) contentView.findViewById(R.id.reminderListView);
        reminderListAdapter = new ReminderListAdapter(getActivity(),reminderClass);

        todoListView = (ListView) contentView.findViewById(R.id.todoListView);
        todoListAdapter = new TodoListAdapter(getActivity(),todoClass);

        studentListView = (ListView) contentView.findViewById(R.id.studentUpdateListView);
        studentListAdapter = new StudentListAdapter(getActivity(),studentUpdateClass);

        contentView.findViewById(R.id.addReminderButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddReminderDialog();
                    }
                });

        addTodoData();
        addStudentData();

        return contentView;
    }

    public void addStudentData(){
        studentListView.setAdapter(studentListAdapter);
        studentUpdateClass.add(new StudentUpdateClass(0,"Carl Alexon M. Patan-ao","MATH_IT1101","3 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Ronelio M. Mesa","MATH_IT1101","Prelim failed"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Kevin B. Fontanoza","MATH_IT1101","2 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Micky Q. Mojado","MATH_IT1101","1 Absent"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Kim J. Hermano","MATH_IT1101","5 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Renato S. Singcol","MATH_IT1101","Pre-lim failed"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Abeln V. Jumao-as","MATH_IT1101","1 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Mia C. Dalanon","MATH_IT1101","2 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Rico J. Belusco","MATH_IT1101","3 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Arnold D. Cuevo","MATH_IT1101","6 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Letchard G. Quizol","MATH_IT1101","5 Absences"));
        studentUpdateClass.add(new StudentUpdateClass(0,"Siason D. Diego","MATH_IT1101","1 Absences"));
        studentListAdapter.notifyDataSetChanged();
    }

    public void addTodoData(){
        todoListView.setAdapter(todoListAdapter);
        todoClass.add(new TodoClass(0,"Math_ABM101","Pending Quiz Scores","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Copro_IT1101","Pending Exam Scores","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Datstruc_ASCT2102","Pending Exam Scorses","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Forlang_BSIT4101","Pending Quiz Scores","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Disruct_BSIT2101","Pending Meet-up Scores","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Alegbra_2101","Make-up Class","Monday","11/16/18"));
        todoClass.add(new TodoClass(0,"Prostat_3101","Pending Quiz Scores","Monday","11/16/18"));

    }

    public void addReminderData(ReminderClass rClass){
        reminderClass.add(0,rClass);
        reminderListAdapter.notifyDataSetChanged();
        reminderListView.setAdapter(reminderListAdapter);
        reminderListView.smoothScrollToPosition(0);
    }

    public void showAddReminderDialog(){

        final java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        final String currentDate = dateFormat.format(new Date());

        final LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View reminderView = inflater.inflate(R.layout.add_reminder_layout,null);

        final AlertDialog.Builder alertDialog =
                new AlertDialog.Builder(getActivity())
                        .setView(reminderView)
                        .setTitle("Add Reminder")
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String subject = ((TextView)reminderView.findViewById(R.id.subject)).getText().toString();
                                        String time = ((TextView)reminderView.findViewById(R.id.time)).getText().toString();
                                        String location = ((TextView)reminderView.findViewById(R.id.location)).getText().toString();
                                        String agenda = ((TextView)reminderView.findViewById(R.id.agenda)).getText().toString();
                                        addReminderData(new ReminderClass(0,subject,location,time,currentDate,agenda));
                                        myFirebase.child("sample").push().setValue(new ReminderClass(0,subject,location,time,currentDate,agenda),
                                                new Firebase.CompletionListener() {
                                                    @Override
                                                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                                                        Toast.makeText(getActivity(),"Reminder Successfully Added",Toast.LENGTH_SHORT);
                                                    }
                                                });
                                        dialogInterface.dismiss();
                                    }
                                })
                .setNeutralButton("Broadcast",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

        alertDialog.show();
    }
}

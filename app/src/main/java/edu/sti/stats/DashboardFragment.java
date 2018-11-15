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

import java.util.ArrayList;
import java.util.Date;

class ReminderClass{

    int id;
    String title,subtitle,day,date;

    public ReminderClass(int id, String title,String subtitle,String day, String date){
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

        ((TextView)view.findViewById(R.id.title)).setText(reminderList.get(i).getTitle());
        ((TextView)view.findViewById(R.id.subtitle)).setText(reminderList.get(i).getSubtitle());
        ((TextView)view.findViewById(R.id.day)).setText(reminderList.get(i).getDay());
        ((TextView)view.findViewById(R.id.date)).setText(reminderList.get(i).getDate());

        return view;
    }
}
class TodoClass{
    int id;
    String title;
    String subtitle;
    String day;

    public TodoClass(int id,String title,String subtitle,String day){
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.day = day;
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

    String date;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        contentView = inflater.inflate(R.layout.fragment_dashboard,null);

        reminderListView = (ListView) contentView.findViewById(R.id.reminderListView);
        reminderListAdapter = new ReminderListAdapter(getActivity(),reminderClass);


        contentView.findViewById(R.id.addReminderButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddReminderDialog();
                    }
                });

        return contentView;
    }

    public void addReminderData(ReminderClass rClass){
        reminderClass.add(rClass);
        reminderListAdapter.notifyDataSetChanged();
        reminderListView.setAdapter(reminderListAdapter);
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
                                        addReminderData(new ReminderClass(0,subject,location,time,currentDate));
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

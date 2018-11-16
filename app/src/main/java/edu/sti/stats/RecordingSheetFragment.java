package edu.sti.stats;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


class RecordingSheetClass{
    int id;
    String initials,completeName;

    public RecordingSheetClass(int id,String initials,String completeName){
        this.id = id;
        this.initials = initials;
        this.completeName = completeName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIntitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }
}
class RecordingSheetViewAdapter extends RecyclerView.Adapter<RecordingSheetViewAdapter.ViewHolder>{

    Context context;
    ArrayList<RecordingSheetClass> recordingSheetList;
    public RecordingSheetViewAdapter(Context context, ArrayList<RecordingSheetClass> recordingSheetList){
        this.context = context;
        this.recordingSheetList = recordingSheetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.seat_view_list_layout,null);

        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.studentId.setText(recordingSheetList.get(position).getId()+"");
        holder.studentIntitials.setText(recordingSheetList.get(position).getIntitials());
        holder.studentName.setText(recordingSheetList.get(position).getCompleteName());
        holder.recordingSheetCardView.
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View addScoreView = inflater.inflate(R.layout.add_score_layout,null);

                        AlertDialog.Builder builder
                                 = new AlertDialog.Builder(context)
                                .setTitle("Enter " + recordingSheetList.get(position).getCompleteName() + "'s Score")
                                .setView(addScoreView)
                                .setPositiveButton("Finish",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                final int rawScore =
                                                        Integer.parseInt(((EditText)addScoreView.findViewById(R.id.rawScore)).getText().toString());
                                                final int totalScore = 100;
                                                if(rawScore < (100 * .50)){
                                                    setCardViewStyle(holder.itemView,"#ffcc0000","#ffffffff");
                                                }else{
                                                    setCardViewStyle(holder.itemView,"#ffffffff","#ff000000");
                                                }
                                                dialogInterface.dismiss();
                                            }
                                        })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                            builder.show();
                    }
                });
    }


    private void setCardViewStyle(View aov,String bgColor, String textColor){
        ((CardView)aov.findViewById(R.id.seatViewCardView)).setBackgroundColor(Color.parseColor(bgColor));
        ((TextView)aov.findViewById(R.id.studentID)).setTextColor(Color.parseColor(textColor));
        ((TextView)aov.findViewById(R.id.studentInitials)).setTextColor(Color.parseColor(textColor));
        ((TextView)aov.findViewById(R.id.studentName)).setTextColor(Color.parseColor(textColor));
    }

    @Override
    public int getItemCount() {
        return recordingSheetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentId;
        TextView studentIntitials;
        TextView studentName;
        CardView recordingSheetCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            studentId = (TextView) itemView.findViewById(R.id.studentID);
            studentIntitials = (TextView) itemView.findViewById(R.id.studentInitials);
            studentName = (TextView) itemView.findViewById(R.id.studentName);
            recordingSheetCardView = (CardView) itemView.findViewById(R.id.seatViewCardView);
        }
    }
}


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordingSheetFragment extends Fragment {

    View contentView,addComponentView;
    RecyclerView recordingSheetRecyclerView;
    RecordingSheetViewAdapter recordingSheetViewAdapter;
    ArrayList<RecordingSheetClass> recordingSheetList = new ArrayList<>();

    ArrayAdapter<String> componentAdapter;
    String[] componentList = {"Quiz","Task Performance","Exam","Assignments","Seat Works"};
    Spinner componentSpinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        contentView = inflater.inflate(R.layout.fragment_recording_sheet, container, false);
        recordingSheetViewAdapter = new RecordingSheetViewAdapter(getActivity(),recordingSheetList);
        recordingSheetRecyclerView = (RecyclerView) contentView.findViewById(R.id.recordingSheetRecyclerView);
        recordingSheetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),11));
        recordingSheetRecyclerView.setAdapter(recordingSheetViewAdapter);

        contentView.findViewById(R.id.addSubcomponentsButton)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        LayoutInflater componentInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        addComponentView = componentInflater.inflate(R.layout.add_component_layout,null);
                        componentSpinner = (Spinner) addComponentView.findViewById(R.id.componentSpinner);
                        componentAdapter = new ArrayAdapter<String>(getActivity()
                                ,android.R.layout.simple_list_item_1
                                ,android.R.id.text1
                                ,componentList);
                        componentSpinner.setAdapter(componentAdapter);



                        AlertDialog.Builder
                                builder = new AlertDialog.Builder(getActivity())
                                .setTitle("Sub-component details")
                                .setView(addComponentView)
                                .setPositiveButton("Finish",
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

                            builder.show();
                    }
                });

        addSampleData();

        return contentView;
    }

    public void addSampleData(){
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetList.add(new RecordingSheetClass(11010,"MQM","Micky Q. Mojado"));
        recordingSheetList.add(new RecordingSheetClass(11011,"KJH","Kim J. Hermano"));
        recordingSheetList.add(new RecordingSheetClass(11012,"RGS","Renato G. Singcol"));
        recordingSheetList.add(new RecordingSheetClass(11013,"RKM","Ronelio K. Mesa"));
        recordingSheetList.add(new RecordingSheetClass(11014,"KBF","Kevin B. Fontanoza"));
        recordingSheetList.add(new RecordingSheetClass(11015,"CAP","Card A. Patan-ao"));
        recordingSheetViewAdapter.notifyDataSetChanged();
    }

}

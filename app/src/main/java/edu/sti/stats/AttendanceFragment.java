package edu.sti.stats;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


class SeatClass{
    int id;
    String initials,completeName;

    public SeatClass(int id,String initials,String completeName){
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

class SeatViewAdapter extends RecyclerView.Adapter<SeatViewAdapter.ViewHolder> {

    Context context;
    ArrayList<SeatClass> seatList;
    View attendanceOptionView;

    public SeatViewAdapter(Context context,ArrayList<SeatClass> seatList){
        this.context = context;
        this.seatList = seatList;
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        attendanceOptionView = layoutInflater.inflate(R.layout.attendance_option_list_layout,null);
    }

    @NonNull
    @Override
    public SeatViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.seat_view_list_layout,parent,false);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SeatViewAdapter.ViewHolder holder, final int position) {
        holder.studentId.setText(seatList.get(position).getId()+"");
        holder.studentIntitials.setText(seatList.get(position).getIntitials());
        holder.studentName.setText(seatList.get(position).getCompleteName());

        holder.seatViewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder
                        builder = new AlertDialog.Builder(context)
                        .setTitle("Select status")
                        .setView(attendanceOptionView)
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                builder.show();

            }
        });

    }

    private void setCardViewStyle(View aov,int bgColor, int textColor){
        ((CardView)aov.findViewById(R.id.seatViewCardView)).setBackgroundColor(bgColor);
        ((TextView)aov.findViewById(R.id.studentID)).setTextColor(textColor);
        ((TextView)aov.findViewById(R.id.studentInitials)).setTextColor(textColor);
        ((TextView)aov.findViewById(R.id.studentName)).setTextColor(textColor);
    }

    @Override
    public int getItemCount() {
        return seatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView studentId;
        TextView studentIntitials;
        TextView studentName;
        CardView seatViewCardView;

        public ViewHolder(View itemView) {
            super(itemView);

             studentId = (TextView) itemView.findViewById(R.id.studentID);
             studentIntitials = (TextView) itemView.findViewById(R.id.studentInitials);
             studentName = (TextView) itemView.findViewById(R.id.studentName);
             seatViewCardView = (CardView) itemView.findViewById(R.id.seatViewCardView);
        }

    }
}
/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {

    View contentView;
    RecyclerView seatRecyclerView;
    SeatViewAdapter seatViewAdapter;
    ArrayList<SeatClass> seatClass = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView = inflater.inflate(R.layout.fragment_attendance, container, false);

        seatViewAdapter = new SeatViewAdapter(getActivity(),seatClass);
        seatRecyclerView = (RecyclerView) contentView.findViewById(R.id.seatRecyclerView);
        seatRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),11));
        seatRecyclerView.setAdapter(seatViewAdapter);
        addSampleData();

        return contentView;
    }

    public void addSampleData(){

        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatClass.add(new SeatClass(11010,"MQM","Micky Q. Mojado"));
        seatClass.add(new SeatClass(11011,"KJH","Kim J. Hermano"));
        seatClass.add(new SeatClass(11012,"RGS","Renato G. Singcol"));
        seatClass.add(new SeatClass(11013,"RKM","Ronelio K. Mesa"));
        seatClass.add(new SeatClass(11014,"KBF","Kevin B. Fontanoza"));
        seatClass.add(new SeatClass(11015,"CAP","Card A. Patan-ao"));
        seatViewAdapter.notifyDataSetChanged();
    }

}

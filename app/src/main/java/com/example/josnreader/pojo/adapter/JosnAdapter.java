package com.example.josnreader.pojo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.josnreader.R;
import com.example.josnreader.model.Josn;
import java.util.ArrayList;
import java.util.List;

public class JosnAdapter extends RecyclerView.Adapter<JosnAdapter.viewHolder> {
    private List<Josn> arrayList = new ArrayList<>();
  //  private Context context;

  /*  public JosnAdapter(List<Josn> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }*/
    public JosnAdapter(){}

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.josn_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.body.setText(arrayList.get(position).getBody());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.id.setText(String.valueOf(arrayList.get(position).getId()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setList(List<Josn> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView id,title,body;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idTV);
            title = itemView.findViewById(R.id.titleTV);
            body = itemView.findViewById(R.id.bodyTV);
        }
    }
}

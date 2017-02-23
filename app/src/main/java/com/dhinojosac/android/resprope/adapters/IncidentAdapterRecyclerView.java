package com.dhinojosac.android.resprope.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhinojosac.android.resprope.R;
import com.dhinojosac.android.resprope.model.Incidencium;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by negro-PC on 22-Feb-17.
 */

public class IncidentAdapterRecyclerView extends RecyclerView.Adapter<IncidentAdapterRecyclerView.IncidentViewHolder> {

    private ArrayList<Incidencium> incidentList;
    private int resource;       // es el cardview que queremos inflar
    private Activity activity;  //desde donde se llama (sirve para cargar imagenes)

    public IncidentAdapterRecyclerView(ArrayList<Incidencium> incidentList, int resource, Activity activity) {
        this.incidentList = incidentList;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public IncidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inicializa IncidentViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new IncidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncidentViewHolder holder, int position) {
        Incidencium incident = incidentList.get(position);

        holder.title.setText(incident.getCategoria());
        holder.detail.setText(incident.getTitulo());
        holder.distance.setText("100 m");
        holder.picture.setImageResource(setImage(incident.getIdEvento()));
    }

    public int setImage(String idEvent){
        if(idEvent=="1"){
            return R.drawable.accidente;
        }
        else if (idEvent=="2"){
            return R.drawable.trabajo;
        }
        else if (idEvent=="3"){
            return R.drawable.trafico;
        }
        else if (idEvent=="4"){
            return R.drawable.desvio;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return incidentList.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        //Todos los views que componen el cardview
        private ImageView picture;
        private TextView title;
        private TextView detail;
        private TextView distance;

        public IncidentViewHolder(View itemView) {
            super(itemView);
            //Cargar desde la vista del cardview
            picture = (ImageView) itemView.findViewById(R.id.cardview_image);
            title = (TextView) itemView.findViewById(R.id.cardview_title);
            detail = (TextView) itemView.findViewById(R.id.cardview_detail);
            distance = (TextView) itemView.findViewById(R.id.cardview_distance);
        }
    }
}

package com.dhinojosac.android.resprope.adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhinojosac.android.resprope.R;
import com.dhinojosac.android.resprope.model.Incidencium;
import com.dhinojosac.android.resprope.view.IncidentDetailActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by negro-PC on 22-Feb-17.
 */

public class IncidentAdapterRecyclerView extends RecyclerView.Adapter<IncidentAdapterRecyclerView.IncidentViewHolder> {

    private ArrayList<Incidencium> incidentList;
    private int resource;       // es el cardview que queremos inflar
    private Activity activity;  //desde donde se llama (sirve para cargar imagenes)
    ArrayList<String> ImageLinks = new ArrayList<>(); //TEST


    public IncidentAdapterRecyclerView(ArrayList<Incidencium> incidentList, int resource, Activity activity) {
        this.incidentList = incidentList;
        this.resource = resource;
        this.activity = activity;
        //Imagenes de prueba, borrar despues
        ImageLinks.add("http://www.best-truck.net/public/image/news/semi-truck-EQq3R9eKOaU.jpg");
        ImageLinks.add("http://static.news-gazette.com/sites/all/files/imagecache/300_width_scale/images/2012/10/19/20121019-152118-pic-719978895.jpg");
        ImageLinks.add("http://www.thefinderonline.com/images/PREZ-PULMAKO-ROAD.jpg");
        ImageLinks.add("http://www.angelesrising.org/wp-content/uploads/2010/02/Mudslide_cars2-300x150.jpg");
        ImageLinks.add("http://www.waterforum.jp/assets/img/top/focus_img_11.jpg");
    }

    @Override
    public IncidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inicializa IncidentViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new IncidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncidentViewHolder holder, int position) {
        final Incidencium incident = incidentList.get(position);

        holder.title.setText(incident.getCategoria());
        holder.detail.setText(incident.getTitulo());
        holder.distance.setText("100 m");
        //holder.picture.setImageResource(setImage(incident.getIdEvento()));
        Picasso.with(activity).load(getLinkImage()).into(holder.picture);

        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, IncidentDetailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    public int setImage(String idEvent) {
       //TODO: agregar logica para decidir imagen
        return R.drawable.no_load;
    }

    public String getLinkImage(){
        //Escoge del total de imagenes de forma random una
        int index = new Random().nextInt(ImageLinks.size());
        Log.d("RANDOM", String.valueOf(index));
        String url = ImageLinks.get(index);
        Log.d("URL", url);
        return url;
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

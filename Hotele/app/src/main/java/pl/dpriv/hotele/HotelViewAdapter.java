package pl.dpriv.hotele;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by course on 03/11/2017.
 */

class HotelViewAdapter extends ArrayAdapter<Hotel> {
    Context ctx;
    int layoutTemplate;
    List<Hotel> hotelList;

    public HotelViewAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.hotelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.imageViewPhoto);
        TextView name = v.findViewById(R.id.textViewName);
        TextView cost = v.findViewById(R.id.textViewCost);
        TextView costInfo = v.findViewById(R.id.textViewInfoCost);
        TextView oldCost = v.findViewById(R.id.textViewOldCost);
        TextView ratingInfo = v.findViewById(R.id.textViewRatingInfo);

        Hotel current = hotelList.get(position);

        name.setText(current.getName());
        cost.setText("$"+current.getCost());
        costInfo.setText(current.getCostInfo());
        oldCost.setText(current.getOldCost());
        ratingInfo.setText(current.getRatingInfo());

        Picasso.with(ctx)
                .load(current.getPhotoUrl())
                .into(photo);

        return v;
    }
}

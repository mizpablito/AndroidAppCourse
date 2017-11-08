package pl.dpriv.mecaround;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAwariaItemRecyclerViewAdapter extends RecyclerView.Adapter<MyAwariaItemRecyclerViewAdapter.ViewHolder> {

    private final List<AwariaItem> mValues;
    private Context ctx;

    public MyAwariaItemRecyclerViewAdapter(Context context, List<AwariaItem> items) {
        mValues = items;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_awariaitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //get the current element (awaria)
        holder.mItem = mValues.get(position);

        holder.textViewTitle.setText(holder.mItem.getTitle());
        holder.textViewCarModel.setText(holder.mItem.getCarModel());
        Picasso.with(ctx)
                .load(holder.mItem.getPhotoUrl())
                .resize(200,200)
                .centerCrop()
                .into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView photoImageView;
        public final TextView textViewTitle, textViewCarModel;
        public AwariaItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            photoImageView = (ImageView) view.findViewById(R.id.imageViewPhoto);
            textViewCarModel = (TextView) view.findViewById(R.id.textViewCarModel);
            textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitle.getText() + "'";
        }
    }
}

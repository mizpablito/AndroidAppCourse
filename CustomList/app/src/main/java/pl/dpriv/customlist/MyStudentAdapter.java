package pl.dpriv.customlist;

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

class MyStudentAdapter extends ArrayAdapter<Student>{
    Context ctx;
    int layoutTemplate;
    List<Student> studentList;

    public MyStudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.studentList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        ImageView photo = v.findViewById(R.id.imageViewAvatar);
        TextView name = v.findViewById(R.id.textViewName);
        TextView age = v.findViewById(R.id.textViewAge);
        TextView school = v.findViewById(R.id.textViewSchool);
        TextView traning = v.findViewById(R.id.textViewTraining);

        Student current = studentList.get(position);

        name.setText(current.getName());
        age.setText(current.getAge() + " years age");
        school.setText(current.getSchool());
        traning.setText(current.getTraining());

        Picasso.with(ctx)
                .load(current.getUrlPhoto())
                .into(photo);

        return v;
    }
}

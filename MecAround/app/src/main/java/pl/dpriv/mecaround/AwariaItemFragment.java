package pl.dpriv.mecaround;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AwariaItemFragment extends Fragment {

    List<AwariaItem> awariaItemList;

    private int mColumnCount = 1;

    public AwariaItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        awariaItemList = new ArrayList<>();
        awariaItemList.add(new AwariaItem("Lusterko", "Urwane lusterko", "Audi A4", "http://img1.autocentrum.pl/_awc.blogi-41720-1.jpg"));
        awariaItemList.add(new AwariaItem("Wgniecenie", "Wgniecenie przedniego zderzaka", "Audi A5", "http://www.lublin112.pl/wp-content/gallery/audi/1131.jpg"));
        awariaItemList.add(new AwariaItem("Guma", "Dziura w kole xD", "Audi 80", "http://static.gazetapowiatowa.pl/2015/06/przebita-opona-686x515.jpg"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_awariaitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyAwariaItemRecyclerViewAdapter(getActivity(),awariaItemList));
        }
        return view;
    }
}

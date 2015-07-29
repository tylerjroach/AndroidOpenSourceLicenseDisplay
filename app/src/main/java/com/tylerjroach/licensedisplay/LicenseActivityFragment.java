package com.tylerjroach.licensedisplay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.tylerjroach.licensedisplaylibrary.model.Library;
import com.tylerjroach.licensedisplaylibrary.model.LibraryList.LibraryListBuilder;

public class LicenseActivityFragment extends Fragment {

    public LicenseActivityFragment() {
    }

    private ExpandableListView expandableListView;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_license, container, false);

        expandableListView = (ExpandableListView) rootView.findViewById(R.id.licenses_list_view);

        new LibraryListBuilder(context, expandableListView)
                .addLibrary(new Library("Retrofit", "https://github.com/square/retrofit", "square_license.txt"))
                .addLibrary(new Library("Picasso", "https://github.com/square/picasso", "square_license.txt"))
                .build();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = getActivity();
    }
}

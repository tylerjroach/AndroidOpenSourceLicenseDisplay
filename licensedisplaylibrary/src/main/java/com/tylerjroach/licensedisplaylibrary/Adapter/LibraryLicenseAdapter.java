package com.tylerjroach.licensedisplaylibrary.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tylerjroach.licensedisplaylibrary.R;
import com.tylerjroach.licensedisplaylibrary.model.Library;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by tylerroach on 7/29/15.
 */
public class LibraryLicenseAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Library> libraries;
    LayoutInflater inflater;

    public LibraryLicenseAdapter(Context context, ArrayList<Library> libraries) {
        this.context = context;
        this.libraries = libraries;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public Library getChild(int groupPosition, int childPosition) {
        return this.getGroup(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final DetailViewHolder holder;
        View view = convertView;
        Library library = getGroup(groupPosition);


        if (view == null) {
            holder = new DetailViewHolder();
            view = inflater.inflate(R.layout.license_display_library_details, null);

            holder.link = (TextView) view.findViewById(com.tylerjroach.licensedisplaylibrary.R.id.license_display_library_link);
            holder.license = (TextView) view.findViewById(com.tylerjroach.licensedisplaylibrary.R.id.license_display_library_license);

            view.setTag(holder);
        } else {
            holder = (DetailViewHolder) view.getTag();
        }

        holder.link.setText(library.getLink());

        try {

            InputStream is = context.getAssets().open(library.getLicenseAssetFileName());
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            String licenseString = new String(buffer);
            holder.license.setText(licenseString);
        } catch (Exception e) {
            Log.v("failure", e.getMessage());
        }

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Library getGroup(int groupPosition) {
        return this.libraries.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.libraries.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        final HeaderViewHolder holder;
        View view = convertView;
        Library library = getGroup(groupPosition);


        if (view == null) {
            holder = new HeaderViewHolder();
            view = inflater.inflate(R.layout.license_display_library_header, null);

            holder.name = (TextView) view.findViewById(com.tylerjroach.licensedisplaylibrary.R.id.license_display_library_name);
            holder.groupIndicator = (ImageView) view.findViewById(com.tylerjroach.licensedisplaylibrary.R.id.license_display_library_indicator);

            view.setTag(holder);
        } else {
            holder = (HeaderViewHolder) view.getTag();
        }

        if (isExpanded) {
            holder.groupIndicator.setImageDrawable(context.getResources().getDrawable(com.tylerjroach.licensedisplaylibrary.R.drawable.license_display_library_up_arrow));
        } else {
            holder.groupIndicator.setImageDrawable(context.getResources().getDrawable(com.tylerjroach.licensedisplaylibrary.R.drawable.license_display_library_down_arrow));
        }

        holder.name.setText(library.getName());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class HeaderViewHolder {
        TextView name;
        ImageView groupIndicator;
    }

    static class DetailViewHolder {
        TextView link;
        TextView license;
    }
}
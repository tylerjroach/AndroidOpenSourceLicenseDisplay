package com.tylerjroach.licensedisplaylibrary.model;

import android.content.Context;
import android.widget.ExpandableListView;

import com.tylerjroach.licensedisplaylibrary.Adapter.LibraryLicenseAdapter;

import java.util.ArrayList;

/**
 * Created by tylerroach on 7/29/15.
 */
public class LibraryList {
    private Context context;
    private LibraryLicenseAdapter libraryLicenseAdapter;
    private ExpandableListView expandableListView;
    private ArrayList<Library> libraries;

    private LibraryList(LibraryListBuilder builder) {
        this.context = builder.context;
        this.libraries = builder.libraries;
        this.expandableListView = builder.expandableListView;
        this.libraryLicenseAdapter = new LibraryLicenseAdapter(this.context, this.libraries);
        this.expandableListView.setAdapter(this.libraryLicenseAdapter);
        this.expandableListView.setGroupIndicator(null);
    }

    public static class LibraryListBuilder {
        private Context context;
        private ExpandableListView expandableListView;
        private ArrayList<Library> libraries = new ArrayList<>();

        public LibraryListBuilder(Context context, ExpandableListView expandableListView) {
            this.expandableListView = expandableListView;
            this.context = context;
        }

        public LibraryListBuilder addLibrary(Library library) {
            this.libraries.add(library);
            return this;
        }

        public LibraryList build() {
            return new LibraryList(this);
        }

    }
}

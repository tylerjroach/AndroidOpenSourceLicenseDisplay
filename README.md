# AndroidOpenSourceLicenseDisplay

This is a library to quickly display open source licenses used in your app.

1. Add an ExpandableListView to your activity or fragment.
2. Use the LibraryListBuilder to add libraries to the ExpandableListView. Include the name, url, and license.

```
//The license.txt files should be stored in src/main/assets of your project
new LibraryListBuilder(context, expandableListView)
                .addLibrary(new Library("Retrofit", "https://github.com/square/retrofit", "square_license.txt"))
                .addLibrary(new Library("Picasso", "https://github.com/square/picasso", "square_license.txt"))
                .build();
```

Right now, there are no customization options. Unless this project fits your exact needs, you will need to clone it and modify the library yourself.

I'll attmept to publish this to MavenCentral if anyone is interested. Until then, git clone and assembleRelease the licensedisplaylibrary.

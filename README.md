# AndroidOpenSourceLicenseDisplay

This is a library to quickly display open source licenses used in your app.

1. Add an ExpandableListView to your activity or fragment.
2. Use the LibraryListBuilder to add libraries to the ExpandableListView. Include the name, url, and license.

```
//The license.txt files should be stored in src/main/assets of your project
new LibraryListBuilder(context, expandableListView)
                .addLibrary(new Library("Retrofit", "https://github.com/square/retrofit", "square_license.txt", "Copyright 2013 Square, Inc."))
                .addLibrary(new Library("Picasso", "https://github.com/square/picasso", "square_license.txt", "Copyright 2013 Square, Inc."))
                .build();
```

Right now, there are no customization options. Unless this project fits your exact needs, you will need to clone it and modify the library yourself.

The library is published to the jCenter repo, but not MavenCentral.
```
compile 'com.tylerjroach:licensedisplaylibrary:1.0.3'
```

![](https://www.dropbox.com/s/grnic5tw68wna7c/licensedisplay.png?dl=1)

```
The MIT License (MIT)

Copyright (c) 2015 Tyler Roach

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

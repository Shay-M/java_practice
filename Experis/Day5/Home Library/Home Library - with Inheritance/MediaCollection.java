public final class MediaCollection{

    final private IRentable[] _library = new IRentable[0];

    public final void add(final IRentable newItem){

        final IRentable[] newLibrary = new IRentable[_library.length + 1]; 
        System.arraycopy(_library, 0, newLibrary, 0, _library.length);

        newLibrary[_library.length] = newItem;
        _library = newLibrary;;   
    }
}


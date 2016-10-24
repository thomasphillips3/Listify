package engineering.aspire.listify.data;

import android.util.ArrayMap;

/**
 * Created by thomas on 10/24/16.
 */

public final class NotesServiceApiEndpoint {

    static {
        DATA = new ArrayMap(2);
        addNote("I think this will be in a unit test", null);
        addNote("This is another unit test", null);
    }

    private final static ArrayMap<String, Note> DATA;

    private static void addNote(String title, String description, String imageUrl) {
        Note newNote = new Note(title, description, imageUrl);
        DATA.put(newNote.getId(), newNote);
    }

    public static ArrayMap<String, Note> loadPersistedNotes() {
        return DATA;
    }
}

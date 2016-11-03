package engineering.aspire.listify.data;

import android.os.Handler;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 10/24/16.
 */

public class NotesServiceApiImpl implements NotesServiceApi {

    private static final int SERVICE_LATENCY_IN_MILLIS = 2000;
    private static final ArrayMap<String, Note> NOTES_SERVICE_DATA =
            NotesServiceApiEndpoint.loadPersistedNotes();

    @Override
    public void getAllNotes(final NotesServiceCallback<List<Note>> callback) {
        // Simulate network with a delay in execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Note> notes = new ArrayList<>(NOTES_SERVICE_DATA.values());
                callback.onLoaded(notes);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getNote(String noteId, NotesServiceCallback<Note> callback) {
        // TODO: Add network latency.
        Note note = NOTES_SERVICE_DATA.get(noteId);
        callback.onLoaded(note);
    }

    @Override
    public void saveNote(Note note) {
        NOTES_SERVICE_DATA.put(note.getId(), note);
    }
}

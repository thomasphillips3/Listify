package engineering.aspire.listify.testing.data;

import android.util.ArrayMap;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

import java.util.List;

import engineering.aspire.listify.data.Note;
import engineering.aspire.listify.data.NotesServiceApi;

/**
 * Created by thomas on 11/2/16.
 */

public class FakeNotesServiceApiImpl implements NotesServiceApi {

    private static final ArrayMap<String, Note> NOTES_SERVICE_DATA = new ArrayMap();

    @Override
    public void getAllNotes(NotesServiceCallback<List<Note>> callback) {
        callback.onLoaded(Lists.newArrayList(NOTES_SERVICE_DATA.values()));
    }

    @Override
    public void getNote(String noteId, NotesServiceCallback<Note> callback) {
        Note note = NOTES_SERVICE_DATA.get(noteId);
        callback.onLoaded(note);
    }

    @Override
    public void saveNote(Note note) {
        NOTES_SERVICE_DATA.put(note.getId(), note);
    }

    @VisibleForTesting
    public static void addNotes(Note... notes) {
        for (Note note : notes) {
            NOTES_SERVICE_DATA.put(note.getId(), note);
        }
    }
}

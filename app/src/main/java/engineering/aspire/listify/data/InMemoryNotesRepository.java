package engineering.aspire.listify.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by thomas on 10/24/16.
 */

public class InMemoryNotesRepository implements NotesRepository {

    private final NotesServiceApi mNotesServieApi;

    @VisibleForTesting
    List<Note> mCachedNotes;

    public InMemoryNotesRepository(@NonNull NotesServiceApi notesServiceApi) {
        mNotesServieApi = checkNotNull(notesServiceApi);
    }

    @Override
    public void getNotes(@NonNull LoadNotesCallback callback) {
        checkNotNull(callback);

        // Load from API only if necessary
        if (mCachedNotes == null) {
            mNotesServieApi.getAllNotes(new NotesServiceApi.NotesServiceCallback<List<Note>>() {
                @Override
                public void onLoaded(List<Note> notes) {
                    mCachedNotes = ImmutableList.copyOf(notes);
                    callback.onNotesLoaded(mCachedNotes);
                }
            });
        } else {
            callback.onNotesLoaded(mCachedNotes);
        }
    }

    @Override
    public void saveNote(@NonNull Note note) {
        checkNotNull(note);
        mNotesServieApi.saveNote(note);
        refreshData();
    }

    @Override
    public void getNote(@NonNull final String noteId, @NonNull final GetNoteCallback callback) {
        checkNotNull(noteId);
        checkNotNull(callback);
        // Load matching notes using the API
        mNotesServieApi.getNote(noteId, new NotesServiceApi.NotesServiceCallback<Note>() {
            @Override
            public void onLoaded(Note note) {
                callback.onNoteLoaded(note);
            }
        });
    }

    @Override
    public void refreshData() {
        mCachedNotes = null;
    }
}

package engineering.aspire.listify.data;

import android.support.annotation.NonNull;

import java.util.List;

//import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by thomas on 10/16/16.
 */

public interface NotesRepository {
    interface LoadNotesCallback {

        void onNotesLoaded(List<Note> notes);
    }

    interface GetNoteCallback {

        void onNoteLoaded(Note note);
    }

    void getNotes(@NonNull LoadNotesCallback callback);

    void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback);

    void saveNote(@NonNull Note note);

    void refreshData();

}

package engineering.aspire.listify.notes;

import android.support.annotation.NonNull;

import java.util.List;

import engineering.aspire.listify.data.Note;

/**
 * Created by thomas on 10/17/16.
 */

public interface NotesContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showNotes(List<Note> notes);

        void showAddNote();

        void showNoteDetailUi(String noteId);
    }

    interface UserActionsListener {

        void loadNotes(boolean forceUpdate);

        void addNewNote();

        void openNoteDetails(@NonNull Note requestedNote);
    }
}

package engineering.aspire.listify.data;

/**
 * Created by thomas on 10/16/16.
 */

public interface NotesServiceApi {

    interface NotesServiceCallback<T> {

        void onLoaded(T notes);
    }

    void getAllNotes(NotesServiceCallback<List<Note>> callback);

    void getNote(String noteId, NotesServiceCallback<Note> callback);

    void saveNote(Note note);
}

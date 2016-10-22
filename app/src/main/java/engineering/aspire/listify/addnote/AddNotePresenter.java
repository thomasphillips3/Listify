package engineering.aspire.listify.addnote;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import engineering.aspire.listify.data.NotesRepository;
import engineering.aspire.listify.util.ImageFile;
import engineering.aspire.listify.data.Note;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by thomas on 10/20/16.
 */

public class AddNotePresenter implements AddNoteContract.UserActionsListener {

    @NonNull
    private final NotesRepository mNotesRepository;
    @NonNull
    private final AddNoteContract.View mAddNoteView;
    @NonNull
    private final ImageFile mImageFile;

    public AddNotePresenter(@NonNull NotesRepository notesRepository,
                            @NonNull AddNoteContract.View addNoteView,
                            @NonNull ImageFile imageFile) {
        mNotesRepository = checkNotNull(notesRepository);
        mAddNoteView = checkNotNull(addNoteView);
        mImageFile = imageFile;
    }

    @Override
    public void saveNote(String title, String description) {
        String imageUrl = null;
        if (mImageFile.exists()) {
            imageUrl = mImageFile.getPath();
        }
        Note newNote = new Note(title, description, imageUrl);
        if (newNote.isEmpty()) {
            mAddNoteView.showEmptyNoteError();
        } else {
            mNotesRepository.saveNote(newNote);
            mAddNoteView.showNotesList();
        }
    }

    @Override
    public void takePicture() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        mImageFile.create(imageFileName, ".jpg");
        mAddNoteView.openCamera(mImageFile.getPath());
    }

    @Override
    public void imageAvailable() {
        if (mImageFile.exists()) {
            mAddNoteView.showImagePreview(mImageFile.getPath());
        } else {
            imageCaptureFailed();
        }
    }

    @Override
    public void imageCaptureFailed() {
        captureFailed();
    }

    private void captureFailed() {
        mImageFile.delete();
        mAddNoteView.showImageError();
    }
}


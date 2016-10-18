package engineering.aspire.listify.addnote;

import android.support.annotation.NonNull;

import java.io.IOException;

/**
 * Created by thomas on 10/16/16.
 */

public interface AddNoteContract {

    interface View {

        void showEmptyNoteError();

        void showNotesList();

        void openCamera(String saveTo);

        void showImagePreview(@NonNull String uri);

        void showImageError();
    }

    interface UserActionsListener {

        void saveNote(String title, String description);

        void takePicture() throws IOException;

        void imageAvailable();

        void imageCaptureFailed();
    }
}

package engineering.aspire.listify.notedetail;

import android.support.annotation.NonNull;

public interface  NoteDetailContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showMissingNote();

        void hideTitle();

        void showTitle(String title);

        void showImage(String imageUrl);

        void hideImage();

        void hideDescription();

        void showDescription(String description);
    }

    interface UserActionsListener {

        void openNote(@NonNull String noteId);
    }
}
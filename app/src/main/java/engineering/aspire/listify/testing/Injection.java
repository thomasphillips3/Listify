package engineering.aspire.listify.testing;

import engineering.aspire.listify.data.NoteRepositories;
import engineering.aspire.listify.data.NotesRepository;
import engineering.aspire.listify.testing.data.FakeNotesServiceApiImpl;
import engineering.aspire.listify.testing.util.FakeImageFileImpl;
import engineering.aspire.listify.util.ImageFile;

/**
 * Created by thomas on 11/2/16.
 */

public class Injection {

    public static ImageFile provideImageFile() {
        return new FakeImageFileImpl();
    }

    public static NotesRepository provideNotesRepository() {
        return NoteRepositories.getInMemoryRepoInstance(new FakeNotesServiceApiImpl());
    }
}

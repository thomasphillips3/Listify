package engineering.aspire.listify.util;

import android.net.Uri;
import android.os.Environment;

import com.google.common.annotations.VisibleForTesting;

import java.io.File;
import java.io.IOException;

/**
 * Created by thomas on 11/2/16.
 */

public class ImageFileImpl implements ImageFile {

    @VisibleForTesting
    File mImageFile;

    @Override
    public void create(String name, String extension) throws IOException {
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        mImageFile = File.createTempFile(
                name,
                extension,
                storageDir
        );
    }

    @Override
    public boolean exists() {
        return null != mImageFile && mImageFile.exists();
    }

    @Override
    public void delete() {
        mImageFile = null;
    }

    @Override
    public String getPath() {
        return Uri.fromFile(mImageFile).toString();
    }
}

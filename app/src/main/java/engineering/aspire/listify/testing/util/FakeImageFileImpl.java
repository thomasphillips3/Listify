package engineering.aspire.listify.testing.util;

import java.io.IOException;

import engineering.aspire.listify.util.ImageFileImpl;

/**
 * Created by thomas on 11/2/16.
 */

public class FakeImageFileImpl extends ImageFileImpl {
    @Override
    public void create(String name, String extension) throws IOException {

    }

    @Override
    public String getPath() {
        return "file:///android_asset/atsl-logo.png";
    }

    @Override
    public boolean exists() {
        return true;
    }
}

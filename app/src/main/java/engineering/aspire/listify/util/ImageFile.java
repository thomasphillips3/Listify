package engineering.aspire.listify.util;

import java.io.IOException;

/**
 * Created by thomas on 10/17/16.
 */

public interface ImageFile {

    void create(String name, String extension) throws IOException;

    boolean exists();

    void delete();

    String getPath();
}

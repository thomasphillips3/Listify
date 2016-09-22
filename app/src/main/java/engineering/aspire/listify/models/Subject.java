package engineering.aspire.listify.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
//import engineering.aspire.listify.models.

/**
 * Created by thomas on 9/21/16.
 */

@Table(name="Subjects")
public class Subject extends Model {
    @Column (name="remote_id", unique = true)
    public long remoteId;

    @Column (name="Name")
    public String name;

    public Subject() {
        super();
    }
}

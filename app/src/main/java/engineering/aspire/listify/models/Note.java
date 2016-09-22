package engineering.aspire.simpletodo.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

import engineering.aspire.listify.models.Subject;

/**
 * Created by thomas on 9/11/16.
 */
@Table(name="Notes")
public class Note extends Model {
    @Column (name="remote_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public long remoteId;

    @Column (name="Subject", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Subject subject;

    @Column(name="Body")
    public String body;

    @Column(name="Priority")
    public int priority;

    @Column(name="Status")
    public boolean done;

    @Column(name="Date")
    public long dueDate;

    public Note() {
        super();
    }

    public Note(Subject subject, String body) {
        super();
        this.subject = subject;
        this.body = body;
        this.priority = 1;
        this.done = false;
    }

    public List<Note> notes() {
        getMany(Note.class, "Subject");
    }
}

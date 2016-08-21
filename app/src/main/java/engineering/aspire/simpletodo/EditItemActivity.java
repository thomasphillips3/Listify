package engineering.aspire.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
//        Log.v("tomdodo", "in onCreate of EditItemActivity");
        String itemUnderEdit = getIntent().getStringExtra("itemUnderEdit");
//        Log.v("tomtodo", "Currently editing: " + itemUnderEdit);

        EditText etCurrentItem = (EditText) findViewById(R.id.etEditCurrentItem);
        etCurrentItem.setText(itemUnderEdit);
    }
}

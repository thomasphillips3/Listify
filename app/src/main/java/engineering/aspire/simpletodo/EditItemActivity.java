package engineering.aspire.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemUnderEdit = getIntent().getStringExtra("itemUnderEdit");
        EditText etCurrentItem = (EditText) findViewById(R.id.etEditCurrentItem);
        etCurrentItem.setText(itemUnderEdit);
        setupButtonListener();
    }

    private void setupButtonListener() {
        final Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        EditText etEditedItem = (EditText) findViewById(R.id.etEditCurrentItem);
                        String editedText = etEditedItem.getText().toString();
                        Intent data = new Intent (EditItemActivity.this, MainActivity.class);
                        data.putExtra("editedText", editedText);
                        setResult(RESULT_OK, data);
                        finish();
                    }
                });
    }
}
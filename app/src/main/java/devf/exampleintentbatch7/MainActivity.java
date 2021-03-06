package devf.exampleintentbatch7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextSome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonApplication = (Button) findViewById(R.id.button_start_activity);
        buttonApplication.setOnClickListener(this);

        Button buttonActivity = (Button) findViewById(R.id.button_start_activity);
        buttonActivity.setOnClickListener(this);

        editTextSome = (EditText) findViewById(R.id.edittext_some);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_start_application:

                Uri uri = Uri.parse("http://www.devf.mx/");
                Intent intentApplication = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentApplication);

                break;

            case R.id.button_start_activity:

                Intent intentActivity = new Intent(this, SecondActivity.class);
                String textSome = editTextSome.getText().toString();
                intentActivity.putExtra("my_key", textSome);

                startActivity(intentActivity);
                break;
        }
    }
}

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

        setupButtons();

        setupEdittexts();

    }


    private void setupButtons() {
        findViewById(R.id.button_start_activity).setOnClickListener(this);
        findViewById(R.id.button_start_application_link).setOnClickListener(this);
        findViewById(R.id.button_start_application_call).setOnClickListener(this);
    }

    private void setupEdittexts() {
        editTextSome = (EditText) findViewById(R.id.edittext_some);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_start_application_link:

                startApplication("http://www.devf.mx/", Intent.ACTION_VIEW);
                break;

            case R.id.button_start_application_call:

                startApplication("tel:5543567654", Intent.ACTION_CALL);
                break;

            case R.id.button_start_activity:

                String textSome = editTextSome.getText().toString();
                startOtherActivity(SecondActivity.class, Constants.MY_KEY, textSome);

                break;
        }
    }

    private void startApplication(String data, String action)
    {
        Uri uri = Uri.parse(data);
        Intent intentApplication = new Intent(action, uri);
        startActivity(intentApplication);
    }

    private void startOtherActivity(Class activityClass, String key, String value) {
        Intent intent = new Intent(this, activityClass);
        intent.putExtra(key, value);

        startActivity(intent);

    }

}

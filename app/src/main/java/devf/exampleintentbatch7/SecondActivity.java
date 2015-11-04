package devf.exampleintentbatch7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String textSome = intent.getStringExtra(Constants.MY_KEY);

        TextView textViewSecondActivity = (TextView) findViewById(R.id.text_view_second_activity);
        textViewSecondActivity.setText(textSome);

    }
}

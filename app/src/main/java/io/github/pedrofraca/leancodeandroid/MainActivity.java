package io.github.pedrofraca.leancodeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mTextView;
    Button mButton;

    private Cart mCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mCart.addItem(mEditText.getText().toString());
                    mTextView.setText(mCart.toString());
                    mEditText.setText("");

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, R.string.error_fruit_not_supported, Toast.LENGTH_SHORT).show();
                }
            }
        });


        mTextView = (TextView) findViewById(R.id.textView);

        mCart = new Cart();
    }
}

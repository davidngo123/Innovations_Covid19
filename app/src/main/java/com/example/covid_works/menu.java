package com.example.covid_works;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class menu extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openCases();
            }
        });
    }
        public void openCases(){
            Intent intent = new Intent(this, cases.class);
            startActivity(intent);

        }


}

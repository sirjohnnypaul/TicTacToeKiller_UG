package pl.edu.ug.tictactoeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singleplayer (View view){
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
    }

    public void about (View view) {
        Toast.makeText(this, "Tic Tac Toe Multiplayer Game", Toast.LENGTH_SHORT).show();
    }
    public void multiplayer (View view){
        Intent intent = new Intent(getApplicationContext(), OnlineLoginActivity.class);
        startActivity(intent);
    }
    public void stats (View view){
        Intent intent = new Intent(getApplicationContext(), StatisticActivity.class);
        startActivity(intent);
    }
}

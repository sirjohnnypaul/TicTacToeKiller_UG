package pl.edu.ug.tictactoeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatisticActivity extends AppCompatActivity {

    //add Firebase Database stuff
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    TextView p1TextView;
    TextView p2TextView;
    TextView p3TextView;
    TextView p4TextView;
    TextView p5TextView;
    TextView p6TextView;
    TextView s1TextView;
    TextView s2TextView;
    TextView s3TextView;
    TextView s4TextView;
    TextView s5TextView;
    TextView s6TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        p1TextView = (TextView) findViewById(R.id.p1TextView);
        p2TextView = (TextView) findViewById(R.id.p2TextView);
        p3TextView = (TextView) findViewById(R.id.p3TextView);
        p4TextView = (TextView) findViewById(R.id.p4TextView);
        p5TextView = (TextView) findViewById(R.id.p5TextView);
        p6TextView = (TextView) findViewById(R.id.p6TextView);
        s1TextView = (TextView) findViewById(R.id.s1TextView);
        s2TextView = (TextView) findViewById(R.id.s2TextView);
        s3TextView = (TextView) findViewById(R.id.s3TextView);
        s4TextView = (TextView) findViewById(R.id.s4TextView);
        s5TextView = (TextView) findViewById(R.id.s5TextView);
        s6TextView = (TextView) findViewById(R.id.s6TextView);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int i =1;
                int x = 1;
                for (DataSnapshot dst : dataSnapshot.child("users").getChildren()) {
                    String key = dst.getKey();
                    switch (i) {
                        case 1:
                            p1TextView.setText(key);
                            break;
                        case 2:
                            p2TextView.setText(key);
                            break;
                        case 3:
                            p3TextView.setText(key);
                            break;
                        case 4:
                            p4TextView.setText(key);
                            break;
                        case 5:
                            p5TextView.setText(key);
                            break;
                        case 6:
                            p6TextView.setText(key);
                            break;
                        default:
                            Log.i("Wszystkie pola", " wypełnione");
                    }
                    i++;

                    for (DataSnapshot dst2 : dataSnapshot.child("users").child(key).child("points").child("all").getChildren()) {
                        String key2 = dst2.getValue().toString();
                        switch (x) {
                            case 1:
                                s1TextView.setText(key2);
                                break;
                            case 2:
                                s2TextView.setText(key2);
                                break;
                            case 3:
                                s3TextView.setText(key2);
                                break;
                            case 4:
                                s4TextView.setText(key2);
                                break;
                            case 5:
                                s5TextView.setText(key2);
                                break;
                            case 6:
                                s6TextView.setText(key2);
                                break;
                            default:
                                Log.i("Wszystkie pola", " wypełnione");
                        }
                        x++;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }) ;
    }
}

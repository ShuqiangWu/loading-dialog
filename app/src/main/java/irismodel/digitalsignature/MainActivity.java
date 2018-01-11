package irismodel.digitalsignature;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity implements DigtialSignDialog.SaveSignBitmapPath {

    private Button button;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        image = (ImageView) findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DigtialSignDialog dialog = new DigtialSignDialog(MainActivity.this);
                dialog.show();
            }
        });
    }

    @Override
    public void getSignBitmap(String path) {

        Picasso.with(this).load(new File(path)).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);
    }


}


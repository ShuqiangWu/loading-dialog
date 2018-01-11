package irismodel.digitalsignature;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by Iris on 2018/1/9.
 */

public class DigtialSignDialog extends Dialog implements View.OnClickListener {

    private Button yes, reset, back;
    private LinePathView sign;
    private MainActivity mainActivity;

    private Context context;

    public DigtialSignDialog(Context context) {
        super(context);
        this.context = context;
        this.mainActivity=(MainActivity)context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sign);
        initView();
    }

    private void initView() {
        yes = (Button) findViewById(R.id.yes);
        reset = (Button) findViewById(R.id.reset);
        back = (Button) findViewById(R.id.back);
        sign = (LinePathView) findViewById(R.id.sign);
        yes.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes:
//                mainActivity.getSignBitmap(sign.getBitMap());

                String path = "";
                try {
                    path = String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"test.jpg");
                    sign.save(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainActivity.getSignBitmap(path);
                this.dismiss();
                break;
            case R.id.reset:
                sign.clear();
                break;
            case R.id.back:
                this.dismiss();
                break;
        }
    }

    public interface SaveSignBitmapPath {
        void getSignBitmap(String signBitmap);
    }
}

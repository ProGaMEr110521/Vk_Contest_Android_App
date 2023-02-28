package com.example.vk_contest;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{
    public static boolean flag = true;
    public static boolean flag2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialogHand(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Помаши ручкой")
                .setMessage("Привет дружище!")
                .setCancelable(true)
                .setNegativeButton("Привет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Приятно иметь дело с тобой", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void ShowInProgress(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Вот незадача!")
                .setMessage("Извините эта функция была не доработана автором, по причине автор" +
                        " был в отчаянии от взлетов, падений и неудач в процессе своей своей работы." +
                        "\n Идентификационный номер ошибки:\n java.android.ErrorType:ЁмаёАйНидХелпХир\n \n" +
                        "Автор 22:27 28.02.23")
                .setCancelable(true)
                .setNegativeButton("Хорошо", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Спасибо за понимание)", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void OpenCalls(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }

    public void OpenSendings(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }

    public void onCallButtonClick(View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    public void ImageButtonChange1(View view){
        FloatingActionButton imageButton = (FloatingActionButton) findViewById(R.id.floatingActionButton2);;
        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (flag) {
                    imageView.setImageResource(R.drawable.microphone_off);
                    imageButton.setImageResource(R.drawable.microphone_off);
                    flag = false;
                } else {
                    imageView.setImageResource(R.drawable.microphone_active);
                    imageButton.setImageResource(R.drawable.microphone_active);
                    flag = true;
                }
            }
        });
    }
    public void ImageButtonChange2(View view) {
        FloatingActionButton imageButton = (FloatingActionButton) findViewById(R.id.floatingActionButton5);
        ;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (flag2) {
                    imageButton.setImageResource(R.drawable.videocam_off);
                    flag2 = false;
                } else {
                    imageButton.setImageResource(R.drawable.videocam_active);
                    flag2 = true;
                }
            }
        });
    }

}

package com.xxx.viewmodelsample;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.bt1).setOnClickListener((v) -> {
            new MyDialog(this).show();
        });

        findViewById(R.id.bt2).setOnClickListener((v) -> {
            new MyDialogFragment().show(getSupportFragmentManager(), null);
        });
    }

    /***
     *
     */
    public static class MyDialog extends Dialog {
        public MyDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_dialog);
        }
    }

    /***
     *
     */
    public static class MyDialogFragment extends DialogFragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_dialog_fragment, container, false);
        }
    }
}

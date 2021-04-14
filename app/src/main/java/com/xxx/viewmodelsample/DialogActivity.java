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

    MyDialog myDialog;
    static final String KEY_DIALOG_SAVED_INSTANCE = "dialog-saved-instance";

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


        findViewById(R.id.bt3).setOnClickListener((v) -> {
            (myDialog = new MyDialog(this)).show();
        });

        //restore dialog UI state
        if (savedInstanceState != null) {
            final Bundle dialogSavedInstance = savedInstanceState.getBundle(KEY_DIALOG_SAVED_INSTANCE);
            if (dialogSavedInstance != null) {
                (myDialog = new MyDialog(this)).onRestoreInstanceState(dialogSavedInstance);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //save dialog UI state
        if (myDialog != null) {
            outState.putBundle(KEY_DIALOG_SAVED_INSTANCE, myDialog.onSaveInstanceState());
        }
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

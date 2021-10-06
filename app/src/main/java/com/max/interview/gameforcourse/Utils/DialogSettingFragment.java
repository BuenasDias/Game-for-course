package com.max.interview.gameforcourse.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;

import com.max.interview.gameforcourse.R;

import java.util.Objects;

public class DialogSettingFragment extends AlertDialog {

    public DialogSettingFragment(@NonNull Context context, NavController navController) {
        super(context);

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.CustomDialog);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom, null);
        builder.setView(view);
        AlertDialog alert = builder.create();

        if (alert.getWindow() != null)
            alert.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;

        alert.show();

        Button btnStartGame = view.findViewById(R.id.btn_start_game);

        btnStartGame.setOnClickListener(v -> {
            if (Objects.requireNonNull(navController.getCurrentDestination()).getId() != R.id.gameFragment) {
                alert.cancel();
                navController.navigate(R.id.gameFragment,
                        null,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.anim_show)
                                .setExitAnim(R.anim.anim_hide)
                                .setPopEnterAnim(R.anim.anim_show)
                                .setPopExitAnim(R.anim.anim_hide)
                                .build());
            }
        });
    }
}

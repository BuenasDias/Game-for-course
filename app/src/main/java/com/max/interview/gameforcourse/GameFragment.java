package com.max.interview.gameforcourse;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.max.interview.gameforcourse.databinding.FragmentGameBinding;
import com.max.interview.gameforcourse.databinding.FragmentMainBinding;

import java.util.Objects;

public class GameFragment extends Fragment {

    private FragmentGameBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(LayoutInflater.from(requireParentFragment().getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }


    private void initView() {
        navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = Objects.requireNonNull(navHostFragment).getNavController();

//        //Без анимации
//        binding.btnGoMain.setOnClickListener(v ->
//                navController.navigate(R.id.action_gameFragment_to_mainFragment));

//        // Вариант со стандартными анимациями скрытия и показа
//        binding.btnGoMain.setOnClickListener(v ->
//                navController.navigate(R.id.action_gameFragment_to_mainFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.fade_in)
//                                .setExitAnim(android.R.anim.fade_out)
//                                .setPopEnterAnim(android.R.anim.fade_in)
//                                .setPopExitAnim(android.R.anim.fade_out)
//                                .build()));

        // Вариант со стандартными анимациями выезда слева заезд справа
        binding.btnGoMain.setOnClickListener(v ->
                navController.navigate(R.id.action_gameFragment_to_mainFragment,
                        null,
                        new NavOptions.Builder()
                                .setEnterAnim(android.R.anim.slide_in_left)
                                .setExitAnim(android.R.anim.slide_out_right)
                                .setPopEnterAnim(android.R.anim.slide_in_left)
                                .setPopExitAnim(android.R.anim.slide_out_right)
                                .build()));

//        binding.btnGoMain.setOnClickListener(v ->
//                navController.navigate(R.id.action_gameFragment_to_mainFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(R.anim.anim_show)
//                                .setExitAnim(R.anim.anim_hide)
//                                .build())
//        );
    }
}
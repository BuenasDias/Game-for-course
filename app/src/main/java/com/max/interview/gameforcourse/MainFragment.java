package com.max.interview.gameforcourse;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.max.interview.gameforcourse.databinding.FragmentMainBinding;

import java.util.Objects;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(requireParentFragment().getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = Objects.requireNonNull(navHostFragment).getNavController();

//        // Вариант без анимаций
//        binding.btnGoGame.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_ladderFragment));
//
//        binding.btnGoLadder.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_ladderFragment));
//        // Вариант со стандартными анимациями скрытия и показа
//        binding.btnGoGame.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_gameFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.fade_in)
//                                .setExitAnim(android.R.anim.fade_out)
//                                .setPopEnterAnim(android.R.anim.fade_in)
//                                .setPopExitAnim(android.R.anim.fade_out)
//                                .build()));
//
//        binding.btnGoLadder.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_gameFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.fade_in)
//                                .setExitAnim(android.R.anim.fade_out)
//                                .setPopEnterAnim(android.R.anim.fade_in)
//                                .setPopExitAnim(android.R.anim.fade_out)
//                                .build()));

//        // Вариант со стандартными анимациями скрытия и показа
//        binding.btnGoGame.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_gameFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.slide_in_left)
//                                .setExitAnim(android.R.anim.slide_out_right)
//                                .setPopEnterAnim(android.R.anim.slide_in_left)
//                                .setPopExitAnim(android.R.anim.slide_out_right)
//                                .build()));
//
//        binding.btnGoLadder.setOnClickListener(v ->
//                navController.navigate(R.id.action_mainFragment_to_gameFragment,
//                        null,
//                        new NavOptions.Builder()
//                                .setEnterAnim(android.R.anim.slide_in_left)
//                                .setExitAnim(android.R.anim.slide_out_right)
//                                .setPopEnterAnim(android.R.anim.slide_in_left)
//                                .setPopExitAnim(android.R.anim.slide_out_right)
//                                .build()));

        // Вариант с картомными анимациями скрытия и показа
        binding.btnGoGame.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_gameFragment,
                        null,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.anim_show)
                                .setExitAnim(R.anim.anim_hide)
                                .setPopEnterAnim(R.anim.anim_show)
                                .setPopExitAnim(R.anim.anim_hide)
                                .build()));

        binding.btnGoLadder.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_ladderFragment,
                        null,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.anim_show)
                                .setExitAnim(R.anim.anim_hide)
                                .setPopEnterAnim(R.anim.anim_show)
                                .setPopExitAnim(R.anim.anim_hide)
                                .build()));
    }
}
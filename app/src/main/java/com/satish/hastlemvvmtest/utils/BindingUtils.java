package com.satish.hastlemvvmtest.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingUtils {


    @BindingAdapter("image")
    public static void setImageResource(ImageView imageView, String url){
        Glide.with(imageView).load(url).into(imageView);
    }


    @BindingAdapter({"format", "argId"})
    public static void setFormattedText(TextView textView, String format, int argId){
        if(argId == 0) return;
        textView.setText(String.format(format, textView.getResources().getString(argId)));
    }
}

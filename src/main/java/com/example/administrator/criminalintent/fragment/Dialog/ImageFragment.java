package com.example.administrator.criminalintent.fragment.Dialog;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.criminalintent.utils.PictureUtils;

/**
 * Created by Administrator on 2016/3/14.
 */
public class ImageFragment extends DialogFragment {
    public static final String EXTRA_IMAGE_PATH = "com.example.administrator.criminalintent.image_path";

    public static ImageFragment newInstance(String imagePath) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_IMAGE_PATH, imagePath);

        ImageFragment imageFragment = new ImageFragment();
        imageFragment.setArguments(args);
        imageFragment.setStyle(STYLE_NO_TITLE, 0);
        return imageFragment;
    }

    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mImageView=new ImageView(getActivity());
        String path= (String) getArguments().getSerializable(EXTRA_IMAGE_PATH);
        BitmapDrawable drawable= PictureUtils.getScaledDrawable(getActivity(),path);
        mImageView.setImageDrawable(drawable);
        return mImageView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        PictureUtils.cleanImageView(mImageView);
    }
}

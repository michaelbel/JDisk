package org.michaelbel.jdisk.ui.adapter;

import android.content.Context;

import org.michaelbel.jdisk.R;
import org.michaelbel.jdisk.ui.fragment.FilesFragment;
import org.michaelbel.jdisk.ui.fragment.PhotosFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainPagerAdapter(Context context, FragmentManager manager) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FilesFragment();
        } else if (position == 1){
            return new PhotosFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tab_files);
            case 1:
                return context.getString(R.string.tab_photos);
            default:
                return null;
        }
    }
}
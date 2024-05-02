// ManagerFragment.java
package com.l2101600074.eventguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ManagerFragment extends Fragment {

    private TabAdapter tabAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager = view.findViewById(R.id.viewPager2);
        TabLayout tabs = view.findViewById(R.id.tabs);

        tabAdapter = new TabAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(tabAdapter);

        // Attach TabLayoutMediator
        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> tab.setText(tabAdapter.getPageTitle(position)))
                .attach();
    }
}

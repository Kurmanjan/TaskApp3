package com.geektech.taskapp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.taskapp.R;
import com.geektech.taskapp.Task;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {
  private  RecyclerView recyclerView;
    private  Taskadapter adapter;
    private List<Task> mList;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);
        addList();
        return root;







    }


 public void addList(){

     recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
     recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
     mList = new ArrayList<>();
     adapter =  new Taskadapter(mList);
     recyclerView.setAdapter(adapter);
     adapter.notifyDataSetChanged();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
           if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
               Task task = (Task) data.getSerializableExtra("task");
               mList.add(0, task);
               adapter.notifyDataSetChanged();
               Log.e("TAG", "HomeFRG" + task.getDesk() + task.getTitle());
           }

    }
}
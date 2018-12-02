package com.example.vaibh.gobiz.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;
import com.example.vaibh.gobiz.pojos.Module;
import com.example.vaibh.gobiz.pojos.ModuleMapLock;

import java.util.ArrayList;

public class LessonsAdapter extends ArrayAdapter<Module> {

    private boolean enabledModule = true;
    public LessonsAdapter(Context context, ArrayList<Module> modules) {
        super(context, 0, modules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Module module = getItem(position);
        Log.d("Module Value Lesson",ModuleMapLock.moduleMap.get(module.getModuleNumber()).toString());
        if(ModuleMapLock.moduleMap.get(module.getModuleNumber()).toString().equals("false")){
            enabledModule = false;
        }
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_lesson_item, parent, false);
        }

        TextView lessonTitle = convertView.findViewById(R.id.lesson_title);
        TextView lessonDescription = convertView.findViewById(R.id.lesson_description);

        assert module != null;
        lessonTitle.setText(module.getTitle());

        // todo: add description field to module class
        //lessonDescription.setText(module.get);

        return convertView;
    }

    @Override
    public boolean isEnabled(int position){
        return enabledModule;
    }
}

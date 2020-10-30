package com.example.dgrove.rpgassistant.Activities.SkillActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.DB.ViewModels.GameSkillViewModel;
import com.example.dgrove.rpgassistant.MiscPrograms.SkillAdapter;
import com.example.dgrove.rpgassistant.R;

import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SkillListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SkillAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    GameSkillViewModel skillViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.skill_list_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SkillAdapter();
        recyclerView.setAdapter(mAdapter);

        skillViewModel = ViewModelProviders.of(this).get(GameSkillViewModel.class);
        skillViewModel.getAllGameSkills().observe(this, new androidx.lifecycle.Observer<List<GameSkillsEntity>>() {
            @Override
            public void onChanged(List<GameSkillsEntity> skillsEntities) {
                mAdapter.setDataset(skillsEntities);
            }
        });
    }

    public void newSkill(View view) {
        Intent intent = new Intent(this, NewSkillActivity.class);
        startActivity(intent);
    }

}

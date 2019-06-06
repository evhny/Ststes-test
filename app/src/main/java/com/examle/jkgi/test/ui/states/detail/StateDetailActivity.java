package com.examle.jkgi.test.ui.states.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.examle.api.rest.states.entity.ui.State;
import com.examle.jkgi.test.R;

public class StateDetailActivity extends AppCompatActivity {

    public static final String STATE_KEY = "stateKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        State state = (State) getIntent().getSerializableExtra(STATE_KEY);

        setTitle(String.format("%s, %s, %s", state.getName(), state.getCountry(), state.getAbbr()));
        ((TextView) findViewById(R.id.capital)).setText(state.getCapital());
        ((TextView) findViewById(R.id.largestCity)).setText(state.getLargestCity());
        ((TextView) findViewById(R.id.id)).setText(String.format("%d", state.getId()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

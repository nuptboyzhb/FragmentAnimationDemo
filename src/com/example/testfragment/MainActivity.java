package com.example.testfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	private FragmentManager fragmentManager;

	private Button northBtn;
	private Button southBtn;
	private Button eastBtn;
	private Button westBtn;
	private Button popBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();
		initButton();
	}

	private void initButton() {
		northBtn = (Button) findViewById(R.id.btn_north);
		southBtn = (Button) findViewById(R.id.btn_south);
		eastBtn = (Button) findViewById(R.id.btn_east);
		westBtn = (Button) findViewById(R.id.btn_west);
		popBtn = (Button) findViewById(R.id.btn_pop);
		northBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addNorthFragment();
			}
		});
		southBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addSouthFragment();
			}
		});
		eastBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addEastFragment();
			}
		});
		westBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addWestFragment();
			}
		});

		popBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				fragmentManager.popBackStack();
			}
		});

	}

	private void addNorthFragment() {
		addFragment(R.anim.fragment_slide_in_from_top,
				R.anim.fragment_slide_out_to_top,
				R.anim.fragment_slide_in_from_top,
				R.anim.fragment_slide_out_to_top, 0xa0ff0000);
	}

	private void addSouthFragment() {
		addFragment(R.anim.fragment_slide_in_from_bottom,
				R.anim.fragment_slide_out_to_bottom,
				R.anim.fragment_slide_in_from_bottom,
				R.anim.fragment_slide_out_to_bottom, 0xa000ff00);
	}

	private void addEastFragment() {
		addFragment(R.anim.fragment_slide_in_from_left,
				R.anim.fragment_slide_out_to_left,
				R.anim.fragment_slide_in_from_left,
				R.anim.fragment_slide_out_to_left, 0xa00000ff);
	}

	private void addWestFragment() {
		addFragment(R.anim.fragment_slide_in_from_right,
				R.anim.fragment_slide_out_to_right,
				R.anim.fragment_slide_in_from_right,
				R.anim.fragment_slide_out_to_right, 0xa0ff00ff);
	}

	/**
	 * add the fragment
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param color
	 */
	private void addFragment(int arg0, int arg1, int arg2, int arg3, int color) {
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.setCustomAnimations(arg0, arg1, arg2, arg3);
		MyFragment fragment = new MyFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("color", color);
		fragment.setArguments(bundle);
		ft.add(R.id.rl_container, fragment);
		ft.addToBackStack(null);
		ft.commitAllowingStateLoss();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

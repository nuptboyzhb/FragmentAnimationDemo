package com.example.testfragment;

/**
 * @date 2014年10月16日 上午10:09:24
 * @author Zheng Haibo
 * @Description: TODO
 */
/*
 * $filename: MyFragment.java,v $
 * $Date: 2014-5-16  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-16  Nanjing,njupt,China
 */
public class MyFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment1, container, false);
		Bundle bundle = getArguments();
		int color = bundle.getInt("color");
		rootView.setBackgroundColor(color);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	/**
	 * if you need add animation listener for the fragment
	 * please use this method
	 */
//	@Override
//	public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//		Animation anim;
//		if (enter) {
//			anim = AnimationUtils.loadAnimation(getActivity(),
//					android.R.anim.fade_in);
//		} else {
//			anim = AnimationUtils.loadAnimation(getActivity(),
//					android.R.anim.fade_out);
//		}
//
//		anim.setAnimationListener(new AnimationListener() {
//			public void onAnimationEnd(Animation animation) {
//				
//			}
//
//			public void onAnimationRepeat(Animation animation) {
//				
//			}
//
//			public void onAnimationStart(Animation animation) {
//				
//			}
//		});
//
//		return anim;
//	}
}

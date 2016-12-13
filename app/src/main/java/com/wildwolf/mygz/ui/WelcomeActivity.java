package com.wildwolf.mygz.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wildwolf.mygz.MainActivity;
import com.wildwolf.mygz.R;
import com.wildwolf.mygz.base.BaseActivity;
import com.wildwolf.mygz.component.ImageLoader;
import com.wildwolf.mygz.model.WelcomeBean;
import com.wildwolf.mygz.presenter.WelcomePresenter;
import com.wildwolf.mygz.presenter.contract.WelcomeContract;

import butterknife.BindView;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tvWelcomeAuthor;


    @Override
    public int getLayout() {
        return R.layout.activity_welcom;
    }

    @Override
    protected void initInject() {
//        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.load(this, welcomeBean.getImg(), ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        tvWelcomeAuthor.setText(welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    protected void onDestroy() {
        Glide.clear(ivWelcomeBg);
        super.onDestroy();
    }
}

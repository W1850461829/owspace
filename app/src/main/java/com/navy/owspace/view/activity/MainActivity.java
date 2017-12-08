package com.navy.owspace.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TimeUtils;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.navy.owspace.R;
import com.navy.owspace.model.entity.Event;
import com.navy.owspace.model.entity.Item;
import com.navy.owspace.presenter.MainContract;
import com.navy.owspace.util.AppUtil;
import com.navy.owspace.util.PreferenceUtils;
import com.navy.owspace.util.TimeUtil;
import com.navy.owspace.util.tool.RxBus;
import com.navy.owspace.view.fragment.LeftMenuFragment;
import com.navy.owspace.view.fragment.RightMenuFragment;

import java.util.List;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements  MainContract.View{

    private String deviceId;
    private SlidingMenu slidingMenu;
    private LeftMenuFragment leftMenu;
    private RightMenuFragment rightMenu;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initMenu();
        initPage();
        deviceId = AppUtil.getDeviceId(this);
        String getLunar = PreferenceUtils.getPrefString(this, "getLunar", null);
        if (!TimeUtil.getDate("yyyyMMdd").equals(getLunar)) {
            loadRecommend();

        }
        loadData(1, 0, "0", "0");

    }

    private void loadData(int i, int i1, String s, String s1) {

    }

    private void loadRecommend() {

    }

    private void initPage() {
     new Verti
    }

    private void initMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.setFadeEnabled(true);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.left_menu);
        leftMenu = new LeftMenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.left_menu, leftMenu).commit();
        slidingMenu.setSecondaryMenu(R.layout.right_menu);
        rightMenu = new RightMenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.right_menu, rightMenu).commit();
        subscription = RxBus.getInstance().toObservable(Event.class)
                .subscribe(new Action1<Event>() {
                    @Override
                    public void call(Event event) {
                        slidingMenu.showContent();
                    }
                });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showNoMore() {

    }

    @Override
    public void updateListUI(List<Item> itemList) {

    }

    @Override
    public void showOnFailure() {

    }

    @Override
    public void showLunar(String content) {

    }
}

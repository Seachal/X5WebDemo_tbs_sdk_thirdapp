package com.example.test_webview_demo.shouldOverrideUrlLoading;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.test_webview_demo.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListErrorSchemeHtmlActivity extends Activity {

    public static boolean firstOpening = true;
    private static String[] titles = null;

    public static final int MSG_WEBVIEW_CONSTRUCTOR = 1;
    public static final int MSG_WEBVIEW_POLLING = 2;

    // /////////////////////////////////////////////////////////////////////////////////////////////////
    // add constant here

    private static final int TBS_WEB_1 = 0;
    private static final int TBS_WEB_2 = 1;
    private static final int TBS_WEB_3 = 2;
    private static final int TBS_WEB_4 = 3;
    private static final int TBS_WEB_5 = 4;
    private static final int TBS_WEB_6 = 5;
    private static final int TBS_WEB_7 = 6;

    private static final String hyperlink = "file:///android_asset/webpage/scheme_error.html";

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // for view init
    private Context mContext = null;
    private SimpleAdapter gridAdapter;
    private GridView gridView;
    private ArrayList<HashMap<String, Object>> items;

    private static boolean main_initialized = false;

    // ////////////////////////////////////////////////////////////////////////////////////////////////
    // Activity OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_advanced);
        mContext = this;
        if (!main_initialized) {
            this.new_init();
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////////////////////
    // Activity OnResume
    @Override
    protected void onResume() {
        this.new_init();

        // this.gridView.setAdapter(gridAdapter);
        super.onResume();
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // initiate new UI content
    private void new_init() {
        items = new ArrayList<HashMap<String, Object>>();
        this.gridView = (GridView) this.findViewById(R.id.item_grid);

        if (gridView == null)
            throw new IllegalArgumentException("the gridView is null");

        titles = getResources().getStringArray(R.array.index_titles_2);
        int[] iconResourse = { R.drawable.should_override_url_loading,
                R.drawable.should_override_url_loading, R.drawable.should_override_url_loading,
                R.drawable.should_override_url_loading, R.drawable.should_override_url_loading,
                R.drawable.should_override_url_loading,   R.drawable.should_override_url_loading
        };

        HashMap<String, Object> item = null;
        // HashMap<String, ImageView> block = null;
        for (int i = 0; i < titles.length; i++) {
            item = new HashMap<String, Object>();
            item.put("title", titles[i]);
            item.put("icon", iconResourse[i]);

            items.add(item);
        }
        this.gridAdapter = new SimpleAdapter(this, items,
                R.layout.function_block, new String[]{"title", "icon"},
                new int[]{R.id.Item_text, R.id.Item_bt});
        if (null != this.gridView) {
            this.gridView.setAdapter(gridAdapter);
            this.gridAdapter.notifyDataSetChanged();
            this.gridView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> gridView, View view,
                                        int position, long id) {
                    Intent intent = null;
                    switch (position) {
                        case TBS_WEB_1: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity1.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        case TBS_WEB_2: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity2True.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        case TBS_WEB_3: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity2False.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        case TBS_WEB_4: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity3True.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        case TBS_WEB_5: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity3False.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        case TBS_WEB_6: {
                            intent = new Intent(ListErrorSchemeHtmlActivity.this,
                                    BrowserActivity4.class);
                            intent.setData(Uri.parse(hyperlink));
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
//                        [Android调用系统自带浏览器打开网页的实现方法 - 云+社区 - 腾讯云](https://cloud.tencent.com/developer/article/1726768)
                        case TBS_WEB_7: {
                            intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            Uri content_url = Uri.parse(hyperlink);
                            intent.setData(content_url);
                            ListErrorSchemeHtmlActivity.this.startActivity(intent);

                        }
                        break;
                        default:
                            break;
                    }

                }
            });

        }
        main_initialized = true;

    }

    // ///////////////////////////////////////////////////////////////////////////////////////////
    // Activity menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.tbsSuiteExit();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void tbsSuiteExit() {
        // exit TbsSuite?
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle("X5功能演示");
        dialog.setPositiveButton("OK", new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Process.killProcess(Process.myPid());
            }
        });
        dialog.setMessage("quit now?");
        dialog.create().show();
    }
}

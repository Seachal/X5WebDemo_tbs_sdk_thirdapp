package filedemo.tencent.com.filedemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements QbSdk.PreInitCallback ,ValueCallback<String>
{

    public String				mFilePath	= null;

    private ListView mListView	= null;

    private ArrayList<String> mFileList	= new ArrayList<String>();

    private FileListAdapter		mAdapter	= null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_miniqb_file);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        QbSdk.forceSysWebView();
        String[] list = new String[1];
        list[0]="android.permission.WRITE_EXTERNAL_STORAGE";
        MainActivity.this.requestPermissions(list, 105);

        QbSdk.initX5Environment(this,this);

        mFilePath = Environment.getExternalStorageDirectory().toString();
        mAdapter = new FileListAdapter(this, R.layout.vlist, mFileList);
        mListView = (ListView) findViewById(R.id.miniqb_file_list_view);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                File file = new File("/sdcard/edit.pptx");
                HashMap<String, String> params =  new HashMap<String, String>();
                params.put("local", "true");
                params.put("entryId", "2");
                params.put("allowAutoDestory", "true");

                JSONObject Object = new JSONObject();
                try
                {
                    Object.put("pkgName",MainActivity.this.getApplication().getPackageName());
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                params.put("menuData",Object.toString());
                openFileReader(MainActivity.this,file.getAbsolutePath());
                //QbSdk.openFileReader(MainActivity.this,"/sdcard/edit.pptx",params,MainActivity.this);
            }
        });

        getFileFromSD(mFilePath);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCoreInitFinished()
    {
        Log.d("test","onCoreInitFinished");
    }

    @Override
    public void onViewInitFinished(boolean isX5Core)
    {
        Log.d("test","onViewInitFinished,isX5Core ="+isX5Core);
    }

    @Override
    public void onReceiveValue(String val)
    {
        Log.d("test","onReceiveValue,val ="+val);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

    }

    private void getFileFromSD(String filePath)
    {
        File mfile = new File(filePath);
        File[] files = mfile.listFiles();
        for (int i = 0; i < files.length; i++)
        {
            File file = files[i];
            checkIsTestFile(file.getPath());
        }
    }

    private void checkIsTestFile(final String fName)
    {
        //#if ${enable.tbs_reader}
        QbSdk.canOpenFile(this, fName, new ValueCallback<Boolean>()
        {

            @Override
            public void onReceiveValue(Boolean arg0)
            {
                if (arg0 == true)
                {
                    mFileList.add(fName);
                    mAdapter.notifyDataSetChanged();
                }
                else
                {
                    Log.d("test", "unsupported file:" + fName);
                }
            }
        });
        //#endif
    }

    public void openFileReader(Context context, String pathName)
    {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("local", "true");
        JSONObject Object = new JSONObject();
        try
        {
            Object.put("pkgName",context.getApplicationContext().getPackageName());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        params.put("menuData",Object.toString());
        QbSdk.getMiniQBVersion(context);
        int ret = QbSdk.openFileReader(context, pathName, params, this);

    }

    class FileListAdapter extends ArrayAdapter<String> implements AdapterView.OnItemClickListener
    {

        Context mContext	= null;
        int				mRes		= 0;

        List<String> mObjects	= null;

        public FileListAdapter(Context context, int textViewResourceId, List<String> objects)
        {
            super(context, textViewResourceId, objects);
            mContext = context;
            mRes = textViewResourceId;
            mObjects = objects;
        }


        public View getView(int position, View convertView, ViewGroup parent)
        {

            if (convertView == null)
            {
                convertView = View.inflate(mContext, R.layout.vlist, null);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.title);
            final CharSequence text = (CharSequence) mObjects.get(position);
            textView.setText(text);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(16);

            return convertView;
        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            File file = new File((java.lang.String) mObjects.get(position));
            openFileReader(mContext, file.getAbsolutePath());
        }

    }

}

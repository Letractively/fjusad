package your.retest.namespace;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Favorite_search extends ListActivity{
	private TextView mTxtResult;
	private ArrayList<HashMap<String, Object>>   listItems;    //摮����縑��
    private SimpleAdapter listItemAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendlist);
        
        //ListView list = getListView();
        //ListView list = (ListView)findViewById(R.id.listView1);
        
        //String[] friends = {"�喳尿瘙�,"����,"�單�瘨�};
        
        //list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends)); 
       
        /*list.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
            long arg3) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(friendlist.this, Personalpage_friend.class); 
            startActivity(intent);
            }
        });*/	
        
        setupViewComponent();
                  
    }
	
	private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.favorite_search);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.favorite_search, android.R.layout.simple_list_item_1);
        setListAdapter(adapAllvotelist);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(listviewOnItemClkLis);
    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
			// TODO Auto-generated method stub
			//mTxtResult.setText(((TextView) view).getText());
		}
	};
}

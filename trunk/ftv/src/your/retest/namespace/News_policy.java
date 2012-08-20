package your.retest.namespace;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class News_policy extends ListActivity {
	private TextView mTxtResult;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
    	mTxtResult = (TextView)findViewById(R.id.news_policy);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.news_policy, android.R.layout.simple_list_item_1);
        setListAdapter(adapAllvotelist);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(listviewOnItemClkLis);
    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
			// TODO Auto-generated method stub

			
			switch(position){
			case 0:
				change(1);
				break;
			case 1:
				break;
			default:
				break;
			
			}
		}
	};
	
	private void change(int x){
		if(x == 1){
			Intent intent = new Intent();
			intent.setClass(News_policy.this, News_policy_show.class);
			startActivity(intent);
		}
		
	}
}

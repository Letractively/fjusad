package your.retest.namespace;

//import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class News_latest extends ListActivity{
	private TextView mTxtResult;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.friendlist);
        setupViewComponent();
	}
	
	private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.news_latest);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.news_latest, android.R.layout.simple_list_item_1);
        setListAdapter(adapAllvotelist);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(listviewOnItemClkLis);
    }
	
	AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
			
			switch(position){
			case 0:
				change(1);
				break;
			case 1:
				change(2);
				break;
			default:
				break;
			}
			// TODO Auto-generated method stub
			//mTxtResult.setText(((TextView) view).getText());
		}
	};


	
	private void change(int x){
		if(x == 1){
			Intent intent = new Intent();
			intent.setClass(News_latest.this, Jeremy.class);
			startActivity(intent);
		}
		if(x == 2){
			Intent intent = new Intent();
			intent.setClass(News_latest.this, Jeremy_2.class);
			startActivity(intent);
			
		}
		
	}
	
	
}



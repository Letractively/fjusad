package your.retest.namespace;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Vote_all extends ListActivity {
	private TextView mTxtResult;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.allvotelist);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.vote_all, android.R.layout.simple_list_item_1);
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
				Intent intent = new Intent();
				intent.setClass(Vote_all.this, Vote1.class);
				startActivity(intent);
				break;
			default:
				break;
			}
			// TODO Auto-generated method stub
			//mTxtResult.setText(((TextView) view).getText());
		}
	};
}
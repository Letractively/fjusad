package your.retest.namespace;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Vote_hot extends ListActivity {
	private TextView mTxtResult;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.vote_hot);
        
        ArrayAdapter<CharSequence> adapHotvotelist = ArrayAdapter.createFromResource(
				this, R.array.vote_hot, android.R.layout.simple_list_item_1);
        setListAdapter(adapHotvotelist);
        
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
package your.retest.namespace;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Broadcast extends ListActivity {
	private TextView mTxtResult;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.broadcast);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.broadcast, android.R.layout.simple_list_item_multiple_choice);
        setListAdapter(adapAllvotelist);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //listview.setOnItemClickListener(listviewOnItemClkLis);
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	   // TODO Auto-generated method stub
    	   super.onListItemClick(l, v, position, id);

    	//   Toast.makeText(this,"Item Clicked", Toast.LENGTH_SHORT).show();
    	  
    	  }
    /*AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
			// TODO Auto-generated method stub
			//mTxtResult.setText(((TextView) view).getText());
			
			switch(position){
			case 0:
				
				break;
			case 1:
				change(1);
				break;
			default:
				break;
			
			}
		}
	};
	
	private void change(int x){
		if(x == 1){
			Intent intent = new Intent();
			intent.setClass(Setting.this, Information.class);
			startActivity(intent);
		}
		
	}*/
}

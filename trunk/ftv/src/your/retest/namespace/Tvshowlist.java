package your.retest.namespace;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Tvshowlist extends ListActivity{
	private Facebook facebook = new Facebook("372919396087688");
	private TextView mTxtResult;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tvshowlist);
        
        facebook.authorize( this, new DialogListener(){
			//@Override
			public void onComplete(Bundle values) {
				// TODO Auto-generated method stub
			}
			//@Override
			public void onFacebookError(FacebookError e) {
				// TODO Auto-generated method stub
			}
			//@Override
			public void onError(DialogError e) {
				// TODO Auto-generated method stub
			}
			//@Override
			public void onCancel() {
				// TODO Auto-generated method stub
			}
        });
        
        setupViewComponent();
	}
	
	private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.news_latest);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.tvshowlist, android.R.layout.simple_list_item_1);
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
			case 2:
				change(3);
				break;
			case 3:
				change(4);
				break;
			case 4:
				change(5);
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
			intent.setClass(Tvshowlist.this, Vote.class);
			startActivity(intent);
		}
		if(x == 2){
			Intent intent = new Intent();
			intent.setClass(Tvshowlist.this, Passsentence.class);
			startActivity(intent);
			
		}
		
		if(x == 3){
			Intent intent = new Intent();
			intent.setClass(Tvshowlist.this, Pictureload.class);
			startActivity(intent);
			
		}
		
		if(x == 4){
			Intent intent = new Intent();
			intent.setClass(Tvshowlist.this, PictureDIY_1.class);
			startActivity(intent);
		}
		
		if(x == 5){
			Intent intent = new Intent();
			intent.setClass(Tvshowlist.this, Camera.class);
			startActivity(intent);
		}
	}
}
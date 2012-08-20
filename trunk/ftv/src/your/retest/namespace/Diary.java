package your.retest.namespace;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Diary extends ListActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tvdiary);
        
        /*Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Diary.this, Diary_1.class);
        		startActivity(intent);
        	}
        });*/
        
        
        ListView list = getListView();
        
        String[] program = {"父與子","絕對達令","篤姬"};
        
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,program)); 
	}
	
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
	   // TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch(position){
		case 0:
			change(1);
			break;
		default:
			break;
		
		}
			
		
	}
	private void change(int x){
		if(x == 1){
			Intent intent = new Intent();
			intent.setClass(Diary.this, Diary_1.class);
			startActivity(intent);
		}
		
	}
	
}

package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PictureDIY_1 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.tvshowlist_pic_1);
	    
	    Spinner spinner_items = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.drama,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_items.setAdapter(adapter);
		spinner_items.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				
 
			}
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
	    });
		
		Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(PictureDIY_1.this, PictureDIY_2.class);
        		startActivity(intent);
        	}
        });
	    
	}

}

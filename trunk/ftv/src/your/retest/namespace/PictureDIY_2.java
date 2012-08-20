package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class PictureDIY_2 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.tvshowlist_pic_2);
	    
	    		
	    ImageButton b1 = (ImageButton) findViewById(R.id.imageButton5);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(PictureDIY_2.this, PictureDIY_3.class);
        		startActivity(intent);
        	}
        });
	    
	}

}

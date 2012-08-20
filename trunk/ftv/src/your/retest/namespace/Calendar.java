package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calendar extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        
        Button b1 = (Button) findViewById(R.id.Button26);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Calendar.this, Program_schedule.class);
        		startActivity(intent);
        	}
        });
        
        Button b2 = (Button) findViewById(R.id.favorite);
        b2.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Calendar.this, Favorite.class);
        		startActivity(intent);
        	}
        });
	}
}

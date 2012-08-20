package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Show_intro extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_intro);
        
        Button b1 = (Button) findViewById(R.id.Newpreview);
        Button b2 = (Button) findViewById(R.id.Chatroom_public);
        
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Show_intro.this, Newpreview.class);
        		startActivity(intent);
        	}
        });
        
        b2.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Show_intro.this, Chatroom_public.class);
        		startActivity(intent);
        	}
        });
        
	}

}

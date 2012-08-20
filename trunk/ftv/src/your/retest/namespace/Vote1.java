package your.retest.namespace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vote1 extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote1);
        
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{new AlertDialog.Builder(Vote1.this)
    		.setTitle(R.string.vote)
    		.setMessage(R.string.sendvote)
    		.setPositiveButton
    		(
    			R.string.confirm,
    			new DialogInterface.OnClickListener()
    			{
    				public void onClick(DialogInterface dialoginterface, int i)
    				{
    					Intent intent = new Intent();
    					intent.setClass(Vote1.this, Vote.class);
    					startActivity(intent);
    				}
    			}
    				).show();
        	}
        });
        
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
    					Intent intent = new Intent();
    					intent.setClass(Vote1.this, Vote.class);
    					startActivity(intent);
        	
    		}
        });

}
}
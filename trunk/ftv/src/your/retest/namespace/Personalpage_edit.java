package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Personalpage_edit extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalpage_edit);
        
        Button b1 = (Button) findViewById(R.id.confirm);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Personalpage_edit.this, Personalpage_self.class);
        		startActivity(intent);
        	}
        });
        
        Button b2 = (Button) findViewById(R.id.cancel);
        b2.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Personalpage_edit.this, Personalpage_self.class);
        		startActivity(intent);
        	}
        });

}
}

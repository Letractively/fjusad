package your.retest.namespace;

import your.retest.namespace.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.Button;
import android.widget.Spinner;

public class Diary_3 extends Activity {
	
	//private ArrayAdapter<CharSequence> adapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tvdiary_2);
        
        Spinner spinner_items = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.diary_2,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_items.setAdapter(adapter);
		spinner_items.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				// parent = �ƥ�o�ͪ����� spinner_items
				// position = �Q��ܪ�����index = parent.getSelectedItemPosition()
				// id = row id�A�q�`����Ʈw�ϥ�
 
			}
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
	    });
		
		
		Button b1 = (Button) findViewById(R.id.submit);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		new AlertDialog.Builder(Diary_3.this)
        		.setTitle(R.string.submitdiary)
        		.setMessage(R.string.submitsuccess)
        		.setPositiveButton
        		(
        			R.string.confirm,
        			new DialogInterface.OnClickListener()
        			{
        				public void onClick(DialogInterface dialoginterface, int i)
        				{
        					Intent intent = new Intent();
        	        		intent.setClass(Diary_3.this, Diary_2.class);
        	        		startActivity(intent);
        				}
        			}
        				).show();
        		
        	}
        });
        
        /*Button b1 = (Button) findViewById(R.id.Button15);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(diary.this, calendar.class);
        		startActivity(intent);
        	}
        });*/
	}
}

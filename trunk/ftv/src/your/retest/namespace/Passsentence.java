package your.retest.namespace;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;



public class Passsentence extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.passsentence);
		Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		new AlertDialog.Builder(Passsentence.this)
        		.setTitle(R.string.passphrase)
        		.setMessage(R.string.sendpass)
        		.setPositiveButton
        		(
        			R.string.confirm,
        			new DialogInterface.OnClickListener()
        			{
        				public void onClick(DialogInterface dialoginterface, int i)
        				{
        					Intent intent = new Intent();
        					intent.setClass(Passsentence.this, Tvshowlist.class);
        					startActivity(intent);
        				}
        			}
        				).show();
        		
        	}
        });
        
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,new String[]{"父與子","篤姬","絕對達令"});
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			
			

	public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
		Toast.makeText(Passsentence.this, "您選擇"+adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
	}
	public void onNothingSelected(AdapterView<?> arg0) {
		Toast.makeText(Passsentence.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
	}

	});
		
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.pass_item,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_items.setAdapter(adapter);
		spinner_items.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				// parent = 事件發生的母體 spinner_items
				// position = 被選擇的項目index = parent.getSelectedItemPosition()
				// id = row id，通常給資料庫使用
 
			}
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
	    });*/


	}
}
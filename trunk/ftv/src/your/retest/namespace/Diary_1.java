package your.retest.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Diary_1 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tvdiary_1);
        
        Button b1 = (Button) findViewById(R.id.Button05);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent();
        		intent.setClass(Diary_1.this, Diary_2.class);
        		startActivity(intent);
        	}
        });
        
        Spinner spinner_items = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.diary_1,android.R.layout.simple_spinner_item);
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
	}
}

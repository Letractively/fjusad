package your.retest.namespace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Diary_2 extends Activity {
	
	//private ArrayAdapter<CharSequence> adapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_2);
        
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
		
		
		
		
        
       
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 0, "編輯");
		menu.add(0, 1, 1, "返回個人專頁");
		menu.add(0, 2, 2, "登入/登出");
        menu.add(0, 3, 3, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
    	Intent intent = new Intent();
        switch(item.getItemId()) {
            case 0:
        		intent.setClass(Diary_2.this, Diary_3.class);
        		startActivity(intent);
                break;
            case 1:
            	
            	intent.setClass(Diary_2.this, Personalpage_self.class);
				startActivity(intent);
                //結束此程式
            	//describe.setText("");
                break;
                
            case 2:
            	finish();
            	break;
            	
            case 3:
            	onClick(1);
            	break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onClick(int i)
	{
		new AlertDialog.Builder(Diary_2.this)
		.setTitle(R.string.app_name)
		.setMessage(R.string.Welcome)
		.setPositiveButton
		(
			R.string.confirm,
			new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialoginterface, int i)
				{
					
				}
			}
				).show();
		
	}
}
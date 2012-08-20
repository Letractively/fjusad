package your.retest.namespace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;

public class Chatroom extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom);
        
        /*Button b1 = (Button) findViewById(R.id.tvshow);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Chatroom.this, Tvshowlist.class);
        		startActivity(intent);
        	}
        });*/  
    }
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
    	menu.add(0, 0, 0, "返回首頁");
        menu.add(0, 1, 1, "登入/登出");
        menu.add(0, 2, 2, "關於民視一點通");
        
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
    	Intent intent = new Intent();
        switch(item.getItemId()) {
        
        	case 0:
        		
				intent.setClass(Chatroom.this, RetestActivity.class);
				startActivity(intent);
				break;
            case 1:
                //在TextView上顯示說明
            	finish();
                break;
            case 2:
                //結束此程式
            	onClick(1);
            	//describe.setText("");
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onClick(int i)
	{
		new AlertDialog.Builder(Chatroom.this)
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
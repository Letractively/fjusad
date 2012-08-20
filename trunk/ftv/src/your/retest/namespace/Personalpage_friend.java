package your.retest.namespace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Personalpage_friend extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalpage_friend);
        
        Button b1 = (Button) findViewById(R.id.friendlist);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Personalpage_friend.this, Friendlist.class);
        		startActivity(intent);
        	}
        });
        
        Button b2 = (Button) findViewById(R.id.diary);
        b2.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Personalpage_friend.this, Diary.class);
        		startActivity(intent);
        	}
        });
        
        Button b3 = (Button) findViewById(R.id.chatwith);
        b3.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(Personalpage_friend.this, Chatroom.class);
        		startActivity(intent);
        	}
        });
        
      /*  Button b4 = (Button) findViewById(R.id.addfriend);
        b4.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		new AlertDialog.Builder(Personalpage_self.this)
        		.setTitle(R.string.addfriend)
        		.setMessage(R.string.addsuccess)
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
        }); */
       
    }
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 0, "管理好友");
		menu.add(0, 1, 1, "登入/登出");
        menu.add(0, 2, 2, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
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
		new AlertDialog.Builder(Personalpage_friend.this)
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
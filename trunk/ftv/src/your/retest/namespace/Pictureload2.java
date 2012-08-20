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

public class Pictureload2 extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pictureload2);
        
        Button b1 = (Button) findViewById(R.id.download);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		new AlertDialog.Builder(Pictureload2.this)
        		.setTitle(R.string.pictureload)
        		.setMessage(R.string.pictureload_success)
        		.setPositiveButton
        		(
        			R.string.confirm,
        			new DialogInterface.OnClickListener()
        			{
        				public void onClick(DialogInterface dialoginterface, int i)
        				{
        					Intent intent = new Intent();
        	        		intent.setClass(Pictureload2.this, Pictureload1.class);
        	        		startActivity(intent);
        				}
        			}
        				).show();
        	}
        });

}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 0, "設為來電大頭貼");
		menu.add(0, 1, 1, "設為桌面");
		menu.add(0, 2, 2, "返回首頁");
		menu.add(0, 3, 3, "登入/登出");
        menu.add(0, 4, 4, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
        
        	case 0:
        		new AlertDialog.Builder(Pictureload2.this)
        		.setTitle(R.string.pictureload)
        		.setMessage(R.string.pictureload_success1)
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
        		break;
        		
        	case 1:
        		new AlertDialog.Builder(Pictureload2.this)
        		.setTitle(R.string.pictureload)
        		.setMessage(R.string.pictureload_success2)
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
        		break;
        		
        	case 2:
        		Intent intent = new Intent();
        		intent.setClass(Pictureload2.this, RetestActivity.class);
				startActivity(intent);
        	
            case 3:
                //在TextView上顯示說明
            	finish();
                break;
            case 4:
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
		new AlertDialog.Builder(Pictureload2.this)
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
    //menu end
}
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
import android.widget.ImageButton;
import android.widget.Spinner;

public class PictureDIY_3 extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.tvshowlist_pic_3);
	    
	    Button b1 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{	
        		Intent intent = new Intent();
        		intent.setClass(PictureDIY_3.this, PictureDIY_4.class);
        		startActivity(intent);
        	}
        });
	    
        
	    
	   
	    
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 0, "分享");
		menu.add(0, 1, 1, "下載圖片");
        menu.add(0, 2, 2, "我也要玩");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
        	
        	case 0:
            //在TextView上顯示說明
        		break;
        		
        	case 1:
            //在TextView上顯示說明
        		onClick(1);
        		break;
            
            case 2:
            	Intent intent = new Intent();
        		intent.setClass(PictureDIY_3.this, PictureDIY_4.class);
        		startActivity(intent);
                //結束此程式
            	//describe.setText("");
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onClick(int i)
	{
		new AlertDialog.Builder(PictureDIY_3.this)
		.setTitle(R.string.app_name)
		.setMessage(R.string.pictureload_success)
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

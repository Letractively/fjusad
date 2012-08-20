package your.retest.namespace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
//import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Jeremy extends Activity {
	private Facebook facebook = new Facebook("372919396087688");
	private TextView mTxtResult;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeremy);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 1, "分享到facebook");
		menu.add(0, 1, 1, "登入/登出");
        menu.add(0, 2, 1, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
        
        	case 0:
        		postToWall();
        		break;
            case 1:
            	
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
		new AlertDialog.Builder(Jeremy.this)
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
    
    public void postToWall() {
        // post on user's wall.
        facebook.dialog(this, "feed", new DialogListener() {
     
            public void onFacebookError(FacebookError e) {
            }
            public void onError(DialogError e) {
            }
            public void onComplete(Bundle values) {
            }
            public void onCancel() {
            }
        });
     
    }
    
}

package your.retest.namespace;


import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class Vote extends TabActivity {
   
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);

        Resources res = getResources(); 
        TabHost tabHost = getTabHost(); 
        TabHost.TabSpec spec; 
        Intent intent = new Intent();  

      
        intent.setClass(this, Vote_all.class);
        spec = tabHost.newTabSpec("all").setIndicator("全部",res.getDrawable(R.drawable.smile)) .setContent(intent);
        tabHost.addTab(spec);

 
        intent.setClass(this, Vote_friend.class);
        spec = tabHost.newTabSpec("friend").setIndicator("朋友", res.getDrawable(R.drawable.smile)).setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
    	menu.add(0, 0, 0, "新增票選活動");
        menu.add(0, 1, 1, "返回首頁");
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
				intent.setClass(Vote.this, Vote_add.class);
				startActivity(intent);
				break;
				
        	case 1:
				intent.setClass(Vote.this, RetestActivity.class);
				startActivity(intent);
				break;
            case 2:
                //在TextView上顯示說明
            	finish();
                break;
            case 3:
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
		new AlertDialog.Builder(Vote.this)
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
    
    /*public void logoutFromFacebook() {
		mAsyncRunner.logout(this, new RequestListener() {
			public void onComplete(String response, Object state) {
				Log.d("Logout from Facebook", response);
				if (Boolean.parseBoolean(response) == true) {
					// User successfully Logged out
				}
			}
			public void onIOException(IOException e, Object state) {
			}

			public void onFileNotFoundException(FileNotFoundException e,
					Object state) {
			}
			public void onMalformedURLException(MalformedURLException e,
					Object state) {
			}

			public void onFacebookError(FacebookError e, Object state) {
			}
		});
	}*/
}

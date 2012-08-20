package your.retest.namespace;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Favorite extends ListActivity {
	private TextView mTxtResult;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setupViewComponent();
    }
    
    private void setupViewComponent() {
        mTxtResult = (TextView)findViewById(R.id.favorite_list);
        
        ArrayAdapter<CharSequence> adapAllvotelist = ArrayAdapter.createFromResource(
				this, R.array.favorite_list, android.R.layout.simple_list_item_1);
        setListAdapter(adapAllvotelist);
        
        ListView listview = getListView();
        listview.setTextFilterEnabled(true);

        listview.setOnItemClickListener(listviewOnItemClkLis);
    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
			// TODO Auto-generated method stub
			//mTxtResult.setText(((TextView) view).getText());
		}
	};
	
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
		menu.add(0, 0, 0, "新增");
		menu.add(0, 1, 1, "刪除");
		menu.add(0, 2, 2, "登入/登出");
        menu.add(0, 3, 3, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
        
        case 0:
        	Intent intent = new Intent();
			intent.setClass(Favorite.this, Favorite_search.class);
			startActivity(intent);
        	
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
		new AlertDialog.Builder(Favorite.this)
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


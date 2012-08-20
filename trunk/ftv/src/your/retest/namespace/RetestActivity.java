package your.retest.namespace;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class RetestActivity extends Activity {
    /** Called when the activity is first created. */
	private TextView describe;
	private GridView gv;
	private Intent intent = new Intent();
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        describe = (TextView) findViewById(R.id.describe);
        
        gv = (GridView)findViewById(R.id.gridView01);
		gv.setNumColumns(2);
		//final String[] strs = {"�s�D","�q��@","���s","�`�ت�"};
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,strs);
		//gv.setAdapter(adapter);
		gv.setAdapter(new MyAdapter(this));
		
		gv.setOnItemClickListener(new GridView.OnItemClickListener(){
			public void onItemClick(AdapterView adapterView,View view,int position,long id) {
	              switch(position){
	              	case 0:
	            	    intent.setClass(RetestActivity.this, News.class);
	          			startActivity(intent);
	          			break;
	              	case 1:
	              		intent.setClass(RetestActivity.this, Tvshowlist.class);
	            		startActivity(intent);
	            		break;
	              	case 2:
	              		intent.setClass(RetestActivity.this, Personalpage_self.class);
	            		startActivity(intent);
	            		break;
	              	case 3:
	              		intent.setClass(RetestActivity.this, Calendar.class);
	            		startActivity(intent);
	            		break;
	              	case 4:
	              		intent.setClass(RetestActivity.this, Setting.class);
	            		startActivity(intent);
	            		break;
	            		
	            	default:
	            		break;
	              }
	           }
	     });
        
    }
	
	class MyAdapter extends BaseAdapter{
			
			private Integer[] imgs = {
					R.drawable.news,
					R.drawable.tvshow,
					R.drawable.person,
					R.drawable.tvshowlist,
					R.drawable.setting
			};
			Context context;
			MyAdapter (Context context){
				this.context = context;
			}
	
			public int getCount() {
				// TODO Auto-generated method stub
				return imgs.length;
			}
	
			public Object getItem(int item) {
				// TODO Auto-generated method stub
				return item;
			}
	
			public long getItemId(int id) {
				// TODO Auto-generated method stub
				return id;
			}
	
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView;
				
				if(convertView == null){
					imageView = new ImageView(context);
					imageView.setLayoutParams(new GridView.LayoutParams(210,210));
					imageView.setAdjustViewBounds(false);
					imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
					imageView.setPadding(8, 8, 8, 8);
				}else{
					imageView = (ImageView) convertView;
				}
				imageView.setImageResource(imgs[position]);
				return imageView;
				
			}
			
			
		}
	
	//menu start
	public boolean onCreateOptionsMenu(Menu menu) {
        //參數1:群組id, 參數2:itemId, 參數3:item順序, 參數4:item名稱
        menu.add(0, 0, 0, "登入/登出");
        menu.add(0, 1, 1, "關於民視一點通");
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //依據itemId來判斷使用者點選哪一個item
        switch(item.getItemId()) {
            case 0:
                //在TextView上顯示說明
            	finish();
                break;
            case 1:
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
		new AlertDialog.Builder(RetestActivity.this)
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
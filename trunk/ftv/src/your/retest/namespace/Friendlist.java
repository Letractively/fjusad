package your.retest.namespace;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
//import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.view.View;
//import android.widget.Button;
import android.widget.SimpleAdapter;

public class Friendlist extends ListActivity{
	
	private ArrayList<HashMap<String, Object>>   listItems;    //摮����縑��
    private SimpleAdapter listItemAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendlist);
        
        //ListView list = getListView();
        //ListView list = (ListView)findViewById(R.id.listView1);
        
        //String[] friends = {"�喳尿瘙�,"����,"�單�瘨�};
        
        //list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends)); 
       
        /*list.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
            long arg3) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(friendlist.this, Personalpage_friend.class); 
            startActivity(intent);
            }
        });*/	
        	
        initListView();
        
        this.setListAdapter(listItemAdapter);	
                  
    }
	
	private void initListView()   {   
    	
        listItems = new ArrayList<HashMap<String, Object>>();
        
        String[] friends = {"陳姿汶","林盈萱","陳思涵"};
        Integer[] pic = {R.drawable.jill,R.drawable.bob,R.drawable.jenny};       
        
        for(int i=0;i<3;i++)    {   
            HashMap<String, Object> map = new HashMap<String, Object>();   
            map.put("FriendName", friends[i]);    //��
            map.put("FriendImage", pic[i]);   //�曄�   
            listItems.add(map);   
        }   
        
        //�����函�Item��蝏笆摨���   
        listItemAdapter = new SimpleAdapter(this,listItems,   // listItems�唳皞�   
                R.layout.forlistviewlayout,  //ListItem�ML撣�摰  
                new String[] {"FriendName", "FriendImage"},     //�冽��啁�銝mageItem撖孵���憿�        
                new int[ ] {R.id.ItemTitle, R.id.ItemImage}      //list_item.xml撣��辣���銝杷mageView�D,銝�葵TextView �D  
        );   
        
    }
	@Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
	   // TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch(position){
		case 0:
			change(1);
			break;
		case 1:
			change(2);
		default:
			break;
		
		}
			
		
	}
	private void change(int x){
		if(x == 1){
			Intent intent = new Intent();
			intent.setClass(Friendlist.this, Personalpage_friend.class);
			startActivity(intent);
		}
		if(x == 2){
			Intent intent = new Intent();
			intent.setClass(Friendlist.this, Personalpage_self.class);
			startActivity(intent);
			
		}
		
	}
	
	
	
}
package your.retest.namespace;

//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.view.View;
//import android.widget.Button;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;


public class News extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, News_latest.class);
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("latest").setIndicator("最新",
                          res.getDrawable(R.drawable.ic_tab_latest))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, News_life.class);
        spec = tabHost.newTabSpec("life").setIndicator("生活",
                          res.getDrawable(R.drawable.ic_tab_entertainment))
                      .setContent(intent);
        tabHost.addTab(spec);

        
        intent = new Intent().setClass(this, News_finance.class);
        spec = tabHost.newTabSpec("finance").setIndicator("財經",
                          res.getDrawable(R.drawable.ic_tab_sports))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, News_policy.class);
        spec = tabHost.newTabSpec("policy").setIndicator("政治",
                          res.getDrawable(R.drawable.ic_tab_sports))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, News_social.class);
        spec = tabHost.newTabSpec("social").setIndicator("社會",
                          res.getDrawable(R.drawable.ic_tab_sports))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, News_international.class);
        spec = tabHost.newTabSpec("international").setIndicator("國際",
                          res.getDrawable(R.drawable.ic_tab_sports))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, News_sport.class);
        spec = tabHost.newTabSpec("sport").setIndicator("體育",
                          res.getDrawable(R.drawable.ic_tab_sports))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(0);
    }
}

package sg.edu.rp.c346.id22022448.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.textViewDBS);
        OCBC = findViewById(R.id.textViewOCBC);
        UOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText("星展銀行");
            OCBC.setText("華僑銀行");
            UOB.setText("大华银行");
            return true;
        } else {
            DBS.setText("Error translation");
            OCBC.setText("Error translation");
            UOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    String wordClicked = "";

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == DBS) {
            wordClicked = "dbs";
        } else if (v == OCBC) {
            wordClicked = "ocbc";
        } else if (v == UOB) {
            wordClicked = "uob";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                // Code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/personal/default.page"));
                startActivity(intent);
                return true; // Menu item successfully handled
            } else if (item.getItemId() == 1) {
                // Code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800111111"));
                startActivity(intentCall);
                return true; // Menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                // Code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intent);
                return true; // Menu item successfully handled
            } else if (item.getItemId() == 1) {
                // Code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:63633333"));
                startActivity(intentCall);
                return true; // Menu item successfully handled
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                // Code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/index.page"));
                startActivity(intent);
                return true; // Menu item successfully handled
            } else if (item.getItemId() == 1) {
                // Code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800222212"));
                startActivity(intentCall);
                return true; // Menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); // Pass menu item to the superclass implementation
    }
}
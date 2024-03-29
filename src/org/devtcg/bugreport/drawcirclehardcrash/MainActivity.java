
package org.devtcg.bugreport.drawcirclehardcrash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CrashView crashView = (CrashView)findViewById(R.id.crash_view);
        findViewById(R.id.big_red_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                crashView.setTryCrash(true);
            }
        });
    }
}

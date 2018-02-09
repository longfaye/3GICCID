package com.pei.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * class name£ºAndroidUtilActivity<BR>
 * class description£ºshow get sim card info activity<BR>
 * PS£º×¢ÒâÈ¨ÏÞ <BR>
 * Date:2012-3-12<BR>
 * @version 1.00
 * @author CODYY)peijiangping
 */
public class AndroidUtilActivity extends Activity {
	private Button button_getSIMInfo;
	private TextView number;
	private TextView privoid;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button_getSIMInfo = (Button) this.findViewById(R.id.getSIMInfo);
		number = (TextView) this.findViewById(R.id.textView1);
		privoid = (TextView) this.findViewById(R.id.textView2);
		button_getSIMInfo.setOnClickListener(new ButtonListener());
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v == button_getSIMInfo) {
				SIMCardInfo siminfo = new SIMCardInfo(AndroidUtilActivity.this);
				siminfo.getSimSerialNumber();
				System.out.println(siminfo.getProvidersName());

				if(siminfo.getSimSerialNumber()==null){
					System.out.println("000000");
					number.setText("000000");
				}else{
				System.out.println(siminfo.getSimSerialNumber());
				number.setText(siminfo.getSimSerialNumber());
				}
				privoid.setText(siminfo.getProvidersName());
			}
		}

	}
}
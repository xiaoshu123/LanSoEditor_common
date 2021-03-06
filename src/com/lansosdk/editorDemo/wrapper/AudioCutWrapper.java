package com.lansosdk.editorDemo.wrapper;

import android.util.Log;
import android.view.View;

import com.lansoeditor.demo.R;

public class AudioCutWrapper extends CmdWrapper{

	private boolean isPrepareSuccess=false;
	public AudioCutWrapper()
	{
		super();
		VideoPlayVisibility=View.INVISIBLE;
		AudioPlayVisibility=View.VISIBLE;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "音频剪切";
	}
	@Override
	public int getHint() {
		// TODO Auto-generated method stub
		return R.string.audiocut_hint;
	}
	
	public void doCommand()
	{
		Log.i("sno","isPrepareSuccess:"+isPrepareSuccess);
		if(isPrepareSuccess){
			if(mInfo.aDuration>20)
				mEditor.executeAudioCutOut(srcPath,dstAudio,0,20);
			else
				mEditor.executeAudioCutOut(srcPath,dstAudio,0,mInfo.aDuration/2);
		}
	}
	public boolean prepare()
	{
		//这里额外检查是否同时有音频轨道.
		if(super.prepare() && mInfo.aBitRate>0 && mInfo.aDuration>0)
		{
			isPrepareSuccess=true;
			return true;
		}
		else
			return false;
	}
	
}

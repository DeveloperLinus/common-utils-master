package com.linus.liu.showruzeltui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.linus.common.R;

import java.util.ArrayList;
import java.util.List;

public class ShowDtNameLayout extends LinearLayout {

    private List<DtInfo> dtNames =new ArrayList<>();
    private Context mContext;
    private boolean isVip;

    public ShowDtNameLayout(Context context) {
        super(context);
        mContext=context;
    }

    public ShowDtNameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    public ShowDtNameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;

    }

    public void setVipAndDtNames(boolean vip, List<DtInfo> dtNames) {
        this.dtNames = dtNames;
        isVip = vip;
        myAddView();
        invalidate();
    }



    private void myAddView(){
        removeAllViews();

        int itemSize=dtNames.size()/2+ dtNames.size()%2;
        for (int i = 0; i < itemSize; i++) {


            View view  = LayoutInflater.from(mContext).inflate(R.layout.item_dt_name_view,null,false);
            addView(view);

            TextView dtNameTV1=view.findViewById(R.id.dt_name_1);
            TextView dtNameTV2=view.findViewById(R.id.dt_name_2);

            dtNameTV1.setText(dtNames.get(i*2).getDtName());
            if(i==itemSize-1){
                if(dtNames.size()%2!=1){
                    Log.e("liu","i*2+1="+(i*2+1));
                    dtNameTV2.setText(dtNames.get(i*2+1).getDtName());
                }

            }else{
                Log.e("liu","i*2+1="+(i*2+1));
                dtNameTV2.setText(dtNames.get(i*2+1).getDtName());
            }


            if(isVip){
                dtNameTV1.setBackground(getResources().getDrawable(R.drawable.go_to_dts_name_vip_bg));
                dtNameTV2.setBackground(getResources().getDrawable(R.drawable.go_to_dts_name_vip_bg));

                dtNameTV1.setTextColor(getResources().getColor(R.color.dt_rs_vip_text));
                dtNameTV2.setTextColor(getResources().getColor(R.color.dt_rs_vip_text));
            }else{
                dtNameTV1.setBackground(getResources().getDrawable(R.drawable.go_to_dts_name_pt_bg));
                dtNameTV2.setBackground(getResources().getDrawable(R.drawable.go_to_dts_name_pt_bg));

                dtNameTV1.setTextColor(getResources().getColor(R.color.dt_rs_pt_text));
                dtNameTV2.setTextColor(getResources().getColor(R.color.dt_rs_pt_text));
            }
            if(dtNames.size()==1){
                dtNameTV2.setVisibility(GONE);
                view.findViewById(R.id.show_one_1).setVisibility(VISIBLE);
                view.findViewById(R.id.show_one_2).setVisibility(VISIBLE);
            }else if(i==itemSize-1 && dtNames.size()%2==1){

                dtNameTV2.setVisibility(INVISIBLE);
            }
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }
}

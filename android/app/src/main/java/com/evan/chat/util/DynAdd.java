package com.evan.chat.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class DynAdd {

//    public static boolean addImgTxtBtn(ViewGroup parent,ImageTextButton imgTxtBtn,int width,int height) {
//        return addLayout(parent, width, height,imgTxtBtn);
//    }

//    public static boolean addBBSLineBtn(ViewGroup parent,BBSLineButton bbsLineButton){
//        return addLayout(parent,bbsLineButton);
//    }

    /**
     * @param parent 父容器
     * @param child 子元素
     * @return 添加成功
     */
    public static boolean addView(ViewGroup parent, View child){
        if(parent==null||child==null)
            return false;
        parent.addView(child);
        return true;
    }

    /**
     * @param parent 父容器
     * @param child 子元素
     * @return 添加成功
     */
    public static boolean addLayout(ViewGroup parent,View child,int...rule ){
        return addLayout(parent,null,null,child,rule);
    }

    /**
     * @param parent 父容器
     * @param width 子元素的高
     * @param height 自元素的宽
     * @param child 子元素
     * @param rule 排版规则
     * @return 添加成功
     */
    private static boolean addLayout(ViewGroup parent, Object width, Object height, View child, int... rule){
        if(parent==null||child==null)
            return false;
        int wid,hei;
        if(width==null)
            wid=ViewGroup.LayoutParams.WRAP_CONTENT;
        else {
            switch (width.getClass().getSimpleName()) {
                case "Boolean":
                    if ((boolean) width) {
                        wid = ViewGroup.LayoutParams.WRAP_CONTENT;
                    } else {
                        wid = ViewGroup.LayoutParams.MATCH_PARENT;
                    }
                    break;
                case "Integer":
                    wid = (int) width;
                    break;
                default:
                    wid = ViewGroup.LayoutParams.WRAP_CONTENT;
                    break;
            }
        }
        if(height==null){
            hei=ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        else {
            if (height.getClass().getSimpleName().equals("Boolean")) {
                if ((boolean) height) {
                    hei = ViewGroup.LayoutParams.WRAP_CONTENT;
                } else {
                    hei = ViewGroup.LayoutParams.MATCH_PARENT;
                }
            } else if (height.getClass().toString().equals("Integer")) {
                hei = (int) height;
            } else {
                hei = ViewGroup.LayoutParams.WRAP_CONTENT;
            }
        }
        if(parent.getClass().getSimpleName().equals("RelativeLayout")){
            RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(wid, hei);
            if (rule.length>0){
                for (int aRlue : rule) {
                    layoutParams.addRule(aRlue);
                }
            }
            parent.addView(child, layoutParams);
        }else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(wid, hei);
            parent.addView(child, layoutParams);
        }
        return true;
    }


}

package com.xzt.routerdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：Created by Ding on 2019/4/6
 * 文件描述：
 */
// ARouter传递对象的时候，首先该对象需要Parcelable或者Serializable序列化
public class UserBean implements Parcelable {
   public  String userMessage;

    public String getUserMessage() {
        return userMessage;
    }

    protected UserBean(String userMdessage) {
        userMessage =userMdessage;
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in.readString());
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userMessage);

    }



}

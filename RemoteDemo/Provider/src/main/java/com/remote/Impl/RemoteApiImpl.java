package com.remote.Impl;

import com.remote.api.RemoteApi;

/**
 * Created by Ray on 2017/6/23.
 */
public class RemoteApiImpl implements RemoteApi{
    public String say(String word) {
        return this.getClass().getName()+" says:"+word;
    }
}

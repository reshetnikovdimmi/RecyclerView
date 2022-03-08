package com.recyclerview.RVInterface;

import com.recyclerview.DynamicRvAdapter;
import com.recyclerview.DynamicRvModel;

import java.util.ArrayList;

public interface UpdateRv {
    public void callback(int position, ArrayList<DynamicRvModel> item);
}

package com.sadikul.nestedrecycler.Model;

import java.util.List;

/**
 * Created by ASUS on 01-Jan-18.
 */

public class RecyclerViewItem {
    String name;
    List<InnerRecyclerItem> innerRecyclerItem;

    public RecyclerViewItem(String name, List<InnerRecyclerItem> innerItem) {
        this.name = name;
        this.innerRecyclerItem = innerItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InnerRecyclerItem> getInnerRecyclerItem() {
        return innerRecyclerItem;
    }

    public void setInnerRecyclerItem(List<InnerRecyclerItem> innerRecyclerItem) {
        this.innerRecyclerItem = innerRecyclerItem;

    }
}

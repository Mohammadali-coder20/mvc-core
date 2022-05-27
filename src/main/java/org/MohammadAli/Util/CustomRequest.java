package org.MohammadAli.Util;


import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CustomRequest implements Request{


    final private Map<String, Object> requestAttributes;

    public <E extends Map<String, Object>> CustomRequest(Supplier<E> supplier){
        this.requestAttributes =  supplier.get();
    }

    private CustomRequest(){
        requestAttributes = new HashMap<>();
    }



    public void setAttribute(@NotNull String key , @Nullable Object value){
        this.requestAttributes.put(key , value);
    }

    public Object getAttribute(String key) {
        return requestAttributes.get(key);
    }
}

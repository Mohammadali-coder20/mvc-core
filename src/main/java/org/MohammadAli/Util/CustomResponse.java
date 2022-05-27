package org.MohammadAli.Util;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CustomResponse implements Response {

    private final  Map<String , Object> responseAttributes;

    public <E extends Map<String , Object>> CustomResponse(Supplier<E> supplier){
        responseAttributes = supplier.get();
    }

    private CustomResponse(){
        responseAttributes = new HashMap<>();
    }


    public void setAttribute(@NotNull String key , @Nullable Object value){
        this.responseAttributes.put(key , value);
    }

    public Object getAttribute(String key) {
        return responseAttributes.get(key);
    }

}

package org.MohammadAli.Util;

import org.MohammadAli.entities.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class Repository<T> {

    private final Collection<T> collection;


    public Repository(){
        collection = new ArrayList<>();
    }


    public  <E extends Collection<T>> Repository(Supplier<E> supplier){
        collection = supplier.get();
    }

    public Collection<T> getCollector(){
        return this.collection;
    }
    
}

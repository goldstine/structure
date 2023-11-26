package com.goldstine.disruptor.util;

import com.goldstine.disruptor.Sequence;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class Util {

    public static int ceilingNextPowerOfTwo(final int x){
        return 1<<(32-Integer.numberOfLeadingZeros(x-1));
    }

    public static long getMinimumSequence(final Sequence[] sequences){
        return 1L;
    }

    private static final Unsafe THE_UNSAFE;

    static{
        try{
            final PrivilegedExceptionAction<Unsafe> action = () -> {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            };
            THE_UNSAFE= AccessController.doPrivileged(action);
        }catch (Exception e){
            throw new RuntimeException("Unable to load unsafe",e);
        }
    }

    public static Unsafe getUnsafe(){
        return THE_UNSAFE;
    }
}

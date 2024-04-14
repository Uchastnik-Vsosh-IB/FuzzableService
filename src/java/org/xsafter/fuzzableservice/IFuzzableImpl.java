package org.xsafter.fuzzableservice;

import android.os.RemoteException;

public class IFuzzableImpl extends IFuzzable.Stub {
    @Override
    public int crashMe(int a, String b) throws RemoteException {
        if (a < 15) {
            if (a % 2 == 1) {
                return b.length()/(a-1);
            }
            return 42;
        }
        return b.length();
    }
}
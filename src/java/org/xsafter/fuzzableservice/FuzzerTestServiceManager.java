package org.xsafter.fuzzableservice;

import android.os.RemoteException;
import android.os.ServiceManager;

public class FuzzerTestServiceManager {
    private static final String SERVICE_NAME ="FuzzerTestService";
    private final IFuzzable serviceInterface;

    public static FuzzerTestServiceManager getInstance(){
        return new FuzzerTestServiceManager();
    }

    public int crashMe(int a, String b){
        try {
            return serviceInterface.crashMe(a,b);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }


    private FuzzerTestServiceManager() {
        this.serviceInterface = IFuzzable.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        if (this.serviceInterface == null) {
            throw new IllegalStateException("Failed to find IFuzzerTestInterface by name [" + SERVICE_NAME + "]");
        }
    }
}
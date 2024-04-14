package org.xsafter.fuzzableservice;

public class FuzzerTestService extends Service {
    private final String TAG = FuzzerTestService.class.getSimpleName();
    private static final String SERVICE_NAME = "FuzzerTestService";
    private IFuzzableImpl fuzzableImpl;
    public void onCreate() {
        super.onCreate();
        this.fuzzableImpl = new IFuzzableImpl();
        ServiceManager.addService(SERVICE_NAME,this.fuzzableImpl);
    }
    @Override
    public IBinder onBind(final Intent intent) {
        return fuzzableImpl.asBinder();
    }
}

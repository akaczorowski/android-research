
 	//heap size that app SHOULD use to allow other apps and system work efficiently
    ActivityManager am = (ActivityManager) getSystemService(getApplicationContext().ACTIVITY_SERVICE);
    int appMemInMBytes = am.getMemoryClass();

    // heap expand limit - can be different than value proposed in
    // android memory class on rooted devices with manually set value of VM heap size.
    // This is max allowed size - after that limit error occurs.
    // Setting VM heap size to value lower than proposed by Android, can lead to system crash.
    Runtime rt = Runtime.getRuntime();
    long maxMemoryInBytes = rt.maxMemory();

    // heap current size e.g. 12MB
    long totalMemoryInBytes = rt.totalMemory();
 
    // heap free memory e.g. 4MB - base on current size e.g. 12MB
    long freeMemoryInBytes = rt.freeMemory();
package com.sonido.sonido;

import android.content.Context;
import android.os.PowerManager;

/*----------------------------------------------------------------------------------------------------------------
* Author: Jonathan Gorman
* Date: 26/12/2016
*
* Description: XXX
* ---------------------------------------------------------------------------------------------------------------*/

public abstract class WakeLocker
{
    private static PowerManager.WakeLock wakeLock;

    public static void acquire(Context ctx)
    {
        if (wakeLock != null) wakeLock.release();

        PowerManager pm = (PowerManager) ctx.getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK |
                PowerManager.ACQUIRE_CAUSES_WAKEUP |
                PowerManager.ON_AFTER_RELEASE, "WakeLockTag");
        wakeLock.acquire();
    }

    public static void release()
    {
        if (wakeLock != null)
        {
            wakeLock.release();
            wakeLock = null;
        }
    }
}
package co.tinyqs.tinyqs4j.api;

import java.util.ServiceLoader;

public class MessagingFactory
{
    /**
     * Convenience SPI factory to load a message store from the class path. Simply returns the
     * first service encountered on the class path by the current thread's class loader or throws 
     * UnsupportedOperationException if none can be found.
     */
    public static final Messaging get()
    {
        ServiceLoader<Messaging> loader = ServiceLoader.load(Messaging.class);
        for (Messaging service : loader)
        {
            return service;
        }
        
        throw new UnsupportedOperationException("No Messaging service available on the class path");
    }
}

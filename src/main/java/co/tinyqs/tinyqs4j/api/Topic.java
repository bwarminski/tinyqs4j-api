package co.tinyqs.tinyqs4j.api;

import java.io.IOException;

/**
 * Represents a one-to-many type of messaging pattern between channels where a single message will
 * be passed to 0 or more subscribing channels
 */
public interface Topic
{
    /**
     * Publish the given message to listening channels, returning the number of channels subscribed.
     * 
     * In order to conserve server resources, publishers are recommended to set expirations on all messages to prevent
     * build up of messages on stale subscriber channels.  
     */
    public int publish(ByteMessage message) throws IOException;
    
    /**
     * Subscribe a channel identified by the given name to this topic. Upon subscription, future messages on this
     * topic are expected to be delivered and consumed on the named channel soon after, but not always immediately after
     * successful return from this call.
     */
    public void subscribe(String destination) throws IOException;
    
    /**
     * Unsubscribe a listening channel identified by the given name from this topic. Following unsubscription, future
     * messages on this topic may still arrive on the channelfor a short period of time. 
     * 
     * Publishers are encouraged to set expirations on all
     * messages to prevent resource leaks.
     */
    public void unsubscribe(String destination) throws IOException;
}

package co.tinyqs.tinyqs4j.api;

import java.util.Map;

/**
 * The basic thing that gets sent in the system. Represented as a byte array.
 */
public interface ByteMessage
{
    /**
     * @return System-wide unique ID for the message 
     */
    public String getUUID();
    
    /**
     * @return The message payload
     */
    public byte[] getBytes();
    
    /**
     * @return Expiration timestamp for this message if set, otherwise <= 0
     */
    public long getExpiration();
    
    /**
     * @return number of times delivery of the message has been attempted
     */
    public int getDeliveryCount();
    
    /**
     * @return timestamp at the time this message entered the system
     */
    public long getTimestamp();
    
    /**
     * @return application level headers. Values are expected to be primitive types that
     *         can be serialized from JSON via Jackson (or similar) without custom serialization
     */
    public Map<String,Object> getHeaders();
    
    /**
     * @return timestamp upon which this message should enter the system
     */
    public long getDelay();
    
}

package co.tinyqs.tinyqs4j.api;

import java.util.Collections;
import java.util.Map;

/**
 * Builder pattern for messages that provides access to setters.
 */
public abstract class MessageBuilder<T extends ByteMessage>
{
    protected String uuid = null;
    protected byte[] bytes = null;
    protected long expiration = -1;
    protected int deliveryCount = -1;
    protected long timestamp = -1;
    protected Map<String,Object> headers = Collections.emptyMap();
    protected long delay = -1;
    
    public MessageBuilder<T> uuid(String uuid) {this.uuid = uuid; return this;}
    public MessageBuilder<T> bytes(byte[] bytes) {this.bytes = bytes; return this;}
    public MessageBuilder<T> expiration(long expiration) {this.expiration = expiration; return this;}
    public MessageBuilder<T> deliveryCount(int deliveryCount) {this.deliveryCount = deliveryCount; return this;}
    public MessageBuilder<T> timestamp(long timestamp) {this.timestamp = timestamp; return this;}
    public MessageBuilder<T> headers(Map<String,Object> headers) {this.headers = headers; return this;}
    public MessageBuilder<T> delay(long delay) {this.delay = delay; return this;}
        
    
    public String getUuid()
    {
        return uuid;
    }
    public byte[] getBytes()
    {
        return bytes;
    }
    public long getExpiration()
    {
        return expiration;
    }
    public int getDeliveryCount()
    {
        return deliveryCount;
    }
    public long getTimestamp()
    {
        return timestamp;
    }
    public Map<String, Object> getHeaders()
    {
        return headers;
    }
    public long getDelay()
    {
        return delay;
    }
    public abstract T build();
}

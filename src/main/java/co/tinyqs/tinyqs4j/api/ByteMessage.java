package co.tinyqs.tinyqs4j.api;

import java.util.Map;

public interface ByteMessage
{
    /*
    Message:
        uuid
        payload - HSET "data" -> uuid (first byte is version, the remainder is payload
        expiration - ZSET "expirations:<channel>" -> (time) / uuid (optional)
        deliveryCount - HSET "deliveries" -> uuid (int)
        timestamp - HSET "timestamps" -> uuid
        headers - HSET "headers" -> uuid (JSON)
          type - json, stream
          replyTo - channel to reply */
    
    public String getUUID();
    public byte[] getBytes();
    public long getExpiration();
    public int getDeliveryCount();
    public long getTimestamp();
    public Map<String,Object> getHeaders();
    public long getDelay();
    
}

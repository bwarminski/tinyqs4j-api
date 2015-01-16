package co.tinyqs.tinyqs4j.api;

import java.util.Map;

/**
 * A byte message whose payload can be serialized to a specified type.
 */
public class Message<T> implements ByteMessage
{
    private final ByteMessage byteMessage;
    private final T payload;
    
    public static <T> Message<T> wrap(ByteMessage message, T payload)
    {
        return new Message<T>(message, payload);
    }
    
    private Message(ByteMessage byteMessage, T payload)
    {
        this.byteMessage = byteMessage;
        this.payload = payload;
    }    
    
    public T getPayload()
    {
        return payload;
    }

    @Override
    public String getUUID()
    {
        return byteMessage.getUUID();
    }

    @Override
    public byte[] getBytes()
    {
        return byteMessage.getBytes();
    }

    @Override
    public long getExpiration()
    {
        return byteMessage.getExpiration();
    }

    @Override
    public int getDeliveryCount()
    {
        return byteMessage.getDeliveryCount();
    }

    @Override
    public long getTimestamp()
    {
        return byteMessage.getTimestamp();
    }

    @Override
    public Map<String, Object> getHeaders()
    {
        return byteMessage.getHeaders();
    }

    @Override
    public long getDelay()
    {
        return byteMessage.getDelay();
    }
}

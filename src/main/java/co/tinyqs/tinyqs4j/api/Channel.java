package co.tinyqs.tinyqs4j.api;

import java.io.IOException;

/**
 * Represents a point-to-point communication channel where messages are delivered exactly once
 */
public interface Channel
{
    /**
     * @return Globally unique name for the channel
     */
    public String getName();
    
    /**
     * Send a message on the channel
     * Successful receipt of a message will increase its deliveryCount.
     */
    public void send(ByteMessage message) throws IOException;
    
    /**
     * Attempt to retrieve a message from the channel or return null if one is not present.
     * Successful receipt of a message will increase its deliveryCount.
     */
    public ByteMessage receive() throws IOException;
    
    /**
     * Attempt to retrieve a message from the channel, waiting up to timeoutSec for one to arrive,
     * Successful receipt of a message will increase its deliveryCount.
     * returning null if a message was not received.
     */
    public ByteMessage receive(int timeoutSec) throws IOException;
    
    /**
     * Attempt to retrieve a typed message from the channel. Transport implementations are
     * expected to know how to serialize into the correct type. Unsupported types should be considered
     * an IOException and may or may not increase delivery count on the server side
     * 
     * If no message is immediately available on the channel, return null.
     * 
     * Successful receipt of a message will increase its deliveryCount.
     */
    public <T> Message<T> receive(Class<? extends T> msgClass) throws IOException;
    
    /**
     * Attempt to retrieve a typed message from the channel. Transport implementations are
     * expected to know how to serialize into the correct type. Unsupported types should be considered
     * an IOException and may or may not cause a received message to be marked as needing acknowledgement
     * on the server-side.
     * 
     * If no message is immediately available on the channel, wait up to timeSec secondsfor one to arrive
     * and return null if a message is still not present
     */
    public <T> Message<T> receive(Class<? extends T> msgClass, int timeoutSec) throws IOException;
    
    /**
     * Release a message, decreasing its delivery count if it was represented as previously being delivered on the
     * server side. Note that releasing a non-existent message, or a message that has not already been delivered
     * is a no op, not an exception.
     */
    public void release(ByteMessage message) throws IOException;
    
    /**
     * Acknowledge receipt of a message and release channel resources associated with the message.
     * 
     * Note that acknowledging a non-existent or undelivered message should be considered a no-op.
     */
    public void acknowledge(ByteMessage message) throws IOException;
}

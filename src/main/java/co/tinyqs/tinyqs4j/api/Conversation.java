package co.tinyqs.tinyqs4j.api;

import java.io.IOException;

/**
 * Represents a request-reply pattern where messages are delivered exactly one and each message
 * sent is expected to have 0 or 1 responses
 * 
 * See also {@link Channel} for further explanation of deliveryCount and acknowledgement semantics.
 */
public interface Conversation 
{
    /**
     * @return Globally unique name for the channel
     */
    public String getName();
    
    /**
     * Add a request to this conversation.
     * @return A unique indentifier (claim check) of the location to wait for a response
     */
    public String put(ByteMessage message) throws IOException;
    
    /**
     * Attempt to retrieve a request in this conversation or return null if one is not present.
     */
    public ByteMessage take() throws IOException;
    
    /**
     * Attempt to retrieve a request in this conversation waiting up to timeoutSec seconds for one to arrive
     * and return null if a message has not arrived in that timeframe.
     */
    public ByteMessage take(int timeoutSec) throws IOException;
    
    /**
     * Attempt to retrieved a typed request in this conversation.
     */
    public <T> Message<T> take(Class<? extends T> msgClass) throws IOException;
    
    /**
     * Attempt to retrieve a typed request in this conversation, waiting up to timeoutSec seconds for one
     * to arrive
     */
    public <T> Message<T> take(Class<? extends T> msgClass, int timeoutSec) throws IOException;
    
    /**
     * Respond to the given request. Has the side effect of acknowledging receipt of the request and freeing
     * server resources related to the request except the claim check response channel.
     */
    public void respond(ByteMessage request, ByteMessage response) throws IOException;
    
    /**
     * Check the given claimCheck for a response, returning null if one does not currently exist.
     */
    public ByteMessage wait(String claimCheck) throws IOException;
        
    /**
     * Check the given claimCheck for a response, waiting up to timeoutSec seconds for one to arrive,
     * return null if one has not arrived.
     */
    public ByteMessage wait(String claimCheck, int timeoutSec) throws IOException;
    
    /**
     * Check the given claim check for a typed response, returning null if one does not currently exist.
     */
    public <T> Message<T> wait(Class<? extends T> msgClass, String claimCheck) throws IOException;
    
    /**
     * Check the given claim check for a typed response, waiting up to timeoutSec for one to arrive,
     * returning null if has not arrived
     */
    public <T> Message<T> wait(Class<? extends T> msgClass, String claimCheck, int timeoutSec) throws IOException;
    
    /**
     * Acknowledge receipt of a response on a given claim check. Frees server side resources associated with the
     * response and the claim check.
     */
    public void acknowledge(String claimCheck, ByteMessage response) throws IOException;
}

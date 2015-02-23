package co.tinyqs.tinyqs4j.api;

/**
 * Represents a access point where channels, topics and conversations can be accessed
 * in order to send messages.
 */
public interface Messaging 
{
    /**
     * @return channel represented by the given name
     */
    public Channel getChannel(String name);
    
    /**
     * @return topic represented by the given name
     */
    public Topic getTopic(String name);
    
    /**
     * @return conversation related by the given name
     */
    public Conversation getConversation(String name);
    
    /**
     * Return a typed message builder that is able to serialize messages in a format
     * appropriate for this given data store implementation.
     * 
     * Note, all cahnnels, topics and conversations are expected to be able to handle
     * Messages created from the same datastore but they do not have be to able to
     * handle Messages created from other data store.
     * 
     * ByteMessages, on the other hand, should be considered usable between multiple Datastores without
     * special conversation. 
     * @return
     */
    public <T> TypedMessageBuilder<T> buildMessage();
}

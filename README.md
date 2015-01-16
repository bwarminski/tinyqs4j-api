tinyqs4j
========

A simple message queuing API, similar to JMS, for passing messages in point-to-point, publish-subscribe and request-response pattern.

The motivation was to distill the simple components of the JMS specification without some of the heavy weight and/or legacy requirements that can make
full-fledged JMS client usage awkward and verbose in microservice-style applications. Aside from simplicity, key distinctions between JMS and tinyqs are:

* Message passing is a function of the given Channel or Topic rather than a function of a connection or session
* ReplyTo and CorrelationIDs headers are formalized as Conversations, which extend upon the basic point-to-point semantics of a channel
* Persistence / durability guarantees are expected to be an implementation detail of the service rather than a parameter of a message
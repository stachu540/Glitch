# Glitch Chat

This module contains a [Twitch Message Interface](https://dev.twitch.tv/docs/irc/guide/) using [IRC](https://en.wikipedia.org/wiki/Internet_Relay_Chat) over the [WebSocket](https://en.wikipedia.org/wiki/WebSocket).

## TODO:

* [x] Base Message Interface
* [ ] Channel cache for joined channels and chat rooms
* [ ] Chat Rooms Support
* [ ] Messaging
  * [ ] via Events
  * [ ] via `MessageInterface`
* [ ] Events supports
  * [x] Raw IRC - for creates own custom events
  * [x] Join/Part channel
  * [x] Messages
  * [x] Subscribe's
  * [x] Gift Sub's
  * [x] Host's
  * [x] Raid's
  * [ ] Moderation Actions - *better supported with [PubSub](../pubsub)*
    * [ ] Timeout - *with reasons too*
    * [ ] Bans - *with reasons too*
    * [ ] Unbans - *with reasons too*
* [ ] Command API

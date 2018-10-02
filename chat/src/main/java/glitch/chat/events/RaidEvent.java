package glitch.chat.events;

import glitch.chat.events.RitualNoticeEvent;
import glitch.socket.utils.EventImmutable;
import org.immutables.value.Value;

@EventImmutable
@Value.Immutable
public interface RaidEvent extends RitualNoticeEvent {
    long getViewcount();
}
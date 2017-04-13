import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

final class HandshakeCalculator {

    public HandshakeCalculator() {

    }

    public List<Signal> calculateHandshake(Integer handshake) {
        BiConsumer<LinkedList<Signal>, Signal> accumulator =
                Signal.REVERSE.isInHandshake(handshake)
                ? (c, e) -> c.addFirst(e)
                : (c, e) -> c.addLast(e);

        return Stream.of(Signal.values())
                .filter(s -> s.isInHandshake(handshake) && !s.equals(Signal.REVERSE))
                .collect(LinkedList::new, accumulator, LinkedList::addAll);
    }
}

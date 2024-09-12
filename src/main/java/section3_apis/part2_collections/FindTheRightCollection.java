package section3_apis.part2_collections;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class FindTheRightCollection {

    /**
     * a collection to store objects to be accessed by index.
     */
    Class rightCollection1() {
        return ArrayList.class;
    }

    /**
     * a collection to store objects to be retrieved by ID.
     */
    Class rightCollection2() {
        return Dictionary.class;
    }

    /**
     * a collection to store objects to be accessed by index, but where objects can also be removed efficiently.
     */
    Class rightCollection3() {
        return List.class;
    }

    /**
     * a collection to store objects supporting fast test for presence.
     */
    Class rightCollection4() {
        return null;
    }

    /**
     * an abstract (generic) collection type to store objects in an ordered way supporting accession by index.
     */
    Class rightCollection5() {
        return Map.class;
    }

    /**
     * an abstract (generic) collection type supporting fast test for presence.
     */
    Class rightCollection6() {
        return null;
    }

    /**
     * an abstract (generic) collection type supporting retrieval-by-key.
     */
    Class rightCollection7() {
        return Dictionary.class;
    }

    /**
     * a collection to store objects by natural ordering but also supporting fast test for presence.
     */
    Class rightCollection8() {
        return List.class;
    }
}

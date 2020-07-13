package net.minestom.server.world;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Allows servers to register custom dimensions. Also used during player joining to send the list of all existing dimensions.
 *
 * Contains {@link DimensionType#OVERWORLD}, {@link DimensionType#NETHER}, {@link DimensionType#END} by default but can be removed.
 */
public class DimensionTypeManager {

    private List<DimensionType> dimensionTypes = new LinkedList<>();

    public DimensionTypeManager() {
        addDimension(DimensionType.OVERWORLD);
        addDimension(DimensionType.NETHER);
        addDimension(DimensionType.END);
    }

    /**
     * Add a new dimension type. This does NOT send the new list to players.
     * @param dimensionType
     */
    public void addDimension(DimensionType dimensionType) {
        dimensionTypes.add(dimensionType);
    }

    /**
     * Removes a dimension type. This does NOT send the new list to players.
     * @param dimensionType
     * @return if the dimension type was removed, false if it was not present before
     */
    public boolean removeDimension(DimensionType dimensionType) {
        return dimensionTypes.remove(dimensionType);
    }

    /**
     * Returns an immutable copy of the dimension types already registered
     * @return
     */
    public List<DimensionType> unmodifiableList() {
        return Collections.unmodifiableList(dimensionTypes);
    }

}

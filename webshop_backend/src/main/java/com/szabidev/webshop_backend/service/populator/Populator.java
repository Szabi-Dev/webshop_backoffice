package com.szabidev.webshop_backend.service.populator;

/**
 * Populator interface for populating attributes durign PATCH and PUT
 *
 */
public interface Populator<T, S> {

    /**
     * Populate target with the values of source. Fully replacment is performerd, therefore all the values all populated from the source
     *
     * @param target target object to be populated
     * @param source source object with the values
     * @param <T> generic object

     */
    void populatePut(T target, S source);

    /**
     * Populate target with the values of source. It is for patch operation, so only the values hat are not null will be replaced
     *
     * @param target target object to be populated
     * @param source source object with the values
     * @param <T> generic object
     */
    void populatePatch(T target, S source);
}

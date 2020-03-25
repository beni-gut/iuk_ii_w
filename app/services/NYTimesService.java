package services;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultNYTimesService.class)
public interface NYTimesService {

    /**
     * Return's current bestseller list.
     */
    void bestseller();
}

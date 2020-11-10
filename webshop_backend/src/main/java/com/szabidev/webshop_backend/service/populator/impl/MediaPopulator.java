package com.szabidev.webshop_backend.service.populator.impl;

import com.szabidev.webshop_backend.model.MediaLocalizedModel;
import com.szabidev.webshop_backend.model.MediaModel;
import com.szabidev.webshop_backend.service.populator.Populator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("mediaPopulator")
public class MediaPopulator implements Populator<MediaModel, MediaModel> {

    @Override
    public void populatePut(MediaModel target, MediaModel source) {

    }

    @Override
    public void populatePatch(MediaModel target, MediaModel source) {
        if (source.getRelativePath() != null ) target.setRelativePath(source.getRelativePath());
        for (Map.Entry<String, MediaLocalizedModel> localizedModelEntry: source.getLocalizations().entrySet()) {
            populateLocalizedEntries(target, localizedModelEntry);
        }
    }

    private void populateLocalizedEntries(MediaModel target, Map.Entry<String, MediaLocalizedModel> localizedModelEntry) {
        if (target.getLocalizations().containsKey(localizedModelEntry.getKey())) {
            target.getLocalizations().get(localizedModelEntry.getKey()).setLocale(localizedModelEntry.getValue().getLocale());
            if (localizedModelEntry.getValue().getName() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setName(localizedModelEntry.getValue().getName());
            if (localizedModelEntry.getValue().getDescription() != null) target.getLocalizations().get(localizedModelEntry.getKey()).setDescription(localizedModelEntry.getValue().getDescription());
        } else {
            localizedModelEntry.getValue().setFkMediaModel(target);
            target.getLocalizations().put(localizedModelEntry.getKey(), localizedModelEntry.getValue());
        }
    }
}

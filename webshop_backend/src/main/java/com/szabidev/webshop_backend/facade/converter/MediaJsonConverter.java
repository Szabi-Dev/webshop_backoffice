package com.szabidev.webshop_backend.facade.converter;

import com.szabidev.webshop_backend.controller.dto.MediaJson;
import com.szabidev.webshop_backend.model.MediaLocalizedModel;
import com.szabidev.webshop_backend.model.MediaModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("mediaJsonConverter")
public class MediaJsonConverter implements Converter<MediaJson, MediaModel> {

    @Override
    public MediaModel convert(MediaJson source) {
        MediaModel mediaModel = new MediaModel();
        if (source == null) {
            return mediaModel;
        }
        mediaModel.setRelativePath(source.getRelativePath());
        mediaModel.setLocalizations(new HashMap<>());

        if (source.getName() != null) populateName(source, mediaModel);
        if (source.getDescription() != null) populateDescription(source, mediaModel);
        return mediaModel;
    }

    private void populateDescription(MediaJson source, MediaModel target){
        for (Map.Entry<String, String> description: source.getDescription().entrySet()) {
            MediaLocalizedModel localization = getLocalization(description.getKey(), target);
            localization.setDescription(description.getValue());
            target.getLocalizations().put(description.getKey(), localization);
        }
    }

    private void populateName(MediaJson source, MediaModel target){
        for (Map.Entry<String, String> name: source.getName().entrySet()) {
            MediaLocalizedModel localization = getLocalization(name.getKey(), target);
            localization.setName(name.getValue());
            target.getLocalizations().put(name.getKey(), localization);
        }
    }

    private MediaLocalizedModel getLocalization(String lang, MediaModel target) {
        if (target.getLocalizations().containsKey(lang)) {
            return target.getLocalizations().get(lang);
        }
        MediaLocalizedModel newLocalization = new MediaLocalizedModel();
        newLocalization.setLocale(lang);
        newLocalization.setFkMediaModel(target);
        return newLocalization;
    }
}

package com.szabidev.webshop_backend.facade.assembler;

import com.szabidev.webshop_backend.facade.dto.MediaData;
import com.szabidev.webshop_backend.model.MediaLocalizedModel;
import com.szabidev.webshop_backend.model.MediaModel;
import com.szabidev.webshop_backend.service.LocalizationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mediaDataAssembler")
public class MediaDataAssembler implements RepresentationModelAssembler<MediaModel, MediaData> {

    @Resource(name = "localizationService")
    private LocalizationService localizationService;

    @Override
    public MediaData toModel(MediaModel entity) {
        if (entity == null) {
            return null;
        }
        return convert(entity);
    }

    @Override
    public CollectionModel<MediaData> toCollectionModel(Iterable<? extends MediaModel> entities) {
        return null;
    }

    private MediaData convert(MediaModel entity) {
        MediaData mediaData = new MediaData();
        mediaData.setId(entity.getId());
        mediaData.setRelativePath(entity.getRelativePath());

        String lang = localizationService.getLocalization();
        if (entity.getLocalizations().get(lang) == null){
            return mediaData;
        }
        MediaLocalizedModel localizedModel = entity.getLocalizations().get(lang);

        mediaData.setName(localizedModel.getName());
        mediaData.setDescription(localizedModel.getDescription());
        return mediaData;
    }
}

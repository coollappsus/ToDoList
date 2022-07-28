package main.utils;

import main.dto.NeuterDto;
import main.model.Neuter;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    //из entity в main.dto
    public NeuterDto mapToProductDto(Neuter entity){
        NeuterDto dto = new NeuterDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreateDate(entity.getDate());
        return dto;
    }
    //из main.dto в entity
    public Neuter mapToProductEntity(NeuterDto dto){
        Neuter entity = new Neuter();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getCreateDate());
        return entity;
    }
}

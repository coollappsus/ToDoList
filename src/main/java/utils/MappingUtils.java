package utils;

import dto.NeuterDto;
import entity.Neuter;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    //из entity в dto
    public NeuterDto mapToProductDto(Neuter entity){
        NeuterDto dto = new NeuterDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }
    //из dto в entity
    public Neuter mapToProductEntity(NeuterDto dto){
        Neuter entity = new Neuter();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCreateDate(dto.getCreateDate());
        return entity;
    }
}

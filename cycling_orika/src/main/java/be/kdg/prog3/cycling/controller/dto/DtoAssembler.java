package be.kdg.prog3.cycling.controller.dto;

import be.kdg.prog3.cycling.model.Rider;
import be.kdg.prog3.cycling.model.Team;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class DtoAssembler {
    private final MapperFacade mapper;

    public DtoAssembler() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Rider.class, RiderDto.class)
                .field("team.uciCode", "teamUciCode")
                .field("team.name","teamName")
                .byDefault()
                .customize(new CustomMapper<Rider, RiderDto>() {
                    @Override
                    public void mapAtoB(Rider rider, RiderDto riderDto, MappingContext context) {
                        riderDto.setStageWins(rider.getStageResults().size());
                    }
                })
                .register();

        mapperFactory.classMap(Team.class, TeamDto.class)
                .byDefault()
                .register();

        this.mapper = mapperFactory.getMapperFacade();
    }

    public RiderDto toResource(Rider rider) {
        return mapper.map(rider, RiderDto.class);
    }

    public List<RiderDto> toRiderResources(Iterable<? extends Rider> entities) {
        return StreamSupport
                .stream(entities.spliterator(), false)
                .map(this::toResource)
                .collect(Collectors.toList());
    }

    public TeamDto toResource(Team team) {
        return mapper.map(team, TeamDto.class);
    }

    public List<TeamDto> toTeamResources(Iterable<? extends Team> entities) {
        return StreamSupport
                .stream(entities.spliterator(), false)
                .map(this::toResource)
                .collect(Collectors.toList());
    }
}

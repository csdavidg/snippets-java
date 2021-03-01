package com.example.snippets.mapper;

import java.util.Optional;
import java.util.function.Function;

public class MapperUtils {

    /**
     * Check if a value is null, if the value is not null applies the received function
     *
     * Example
     *
     * mapNullableValue(dto,
     *                 (StatusDTO s) -> Status.builder()
     *                         .id(s.getId())
     *                         .description(s.getDescription())
     *                         .statusType(StatusMapper.statusTypeToEntity(s.getStatusType()))
     *                         .build())
     *
     * @param object
     * @param function
     * @param <V>
     * @param <R>
     * @return
     */
    private static <V, R> R mapNullableValue(V object, Function<V, R> function) {
        return Optional.ofNullable(object)
                .map(function)
                .orElse(null);
    }

}

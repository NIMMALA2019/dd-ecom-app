package com.ntreddy.dd.ecommerce.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommonMapper {
    
	@Autowired
    private ModelMapper modelMapper;

    <T, S> S convertToEntity(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }

    <T, S> S convertToResponse(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }
    
    public <T, S> S convertTo(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }

    <T, S> List<S> convertListTo(List<T> lists, Class<S> type) {
      
    	return lists.stream()
                .map(list -> convertToResponse(list, type))
                .collect(Collectors.toList());
    	

    }
}

package com.inova.uni.services;

import java.util.List;

import com.inova.uni.dto.request.LectureRequestDto;
import com.inova.uni.dto.response.LectureResponseDto;
import org.springframework.stereotype.Service;

import com.inova.uni.entity.Lecture;
@Service
public interface LectureService {
	public String save(LectureRequestDto lecture);
	public LectureResponseDto findLecture(String id);
	public List<LectureResponseDto> findAllLecture();
	public String updateLecture(LectureRequestDto lecture,String id);
	public boolean delete(String id);
}

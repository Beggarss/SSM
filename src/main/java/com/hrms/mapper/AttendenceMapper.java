package com.hrms.mapper;

import com.hrms.model.Attendence;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttendenceMapper {
    int deleteByPrimaryKey(Integer attendenceId);

    int insert(Attendence record);

    int insertSelective(Attendence record);

    Attendence selectByPrimaryKey(Integer attendenceId);

    int updateByPrimaryKeySelective(Attendence record);

    int updateByPrimaryKey(Attendence record);

    int punchIn(Attendence attendence);

    int pounchOut(Attendence attendence);

    Attendence isPounchIn(Attendence attendence);

    Attendence isPounchOut(Attendence attendence);

    int setLate(Attendence attendence);

    int setAbsence(Attendence attendence);

    List<Attendence> selectAttendence();
}
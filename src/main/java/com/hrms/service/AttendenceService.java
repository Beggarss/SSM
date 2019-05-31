package com.hrms.service;

import com.hrms.mapper.AttendenceMapper;
import com.hrms.model.Attendence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendenceService {
    @Autowired
    private AttendenceMapper attendenceMapper;

     public int punchIn(Attendence attendence){
        return  attendenceMapper.punchIn(attendence);
    }

    public int pounchOut(Attendence attendence){
        return  attendenceMapper.pounchOut(attendence);
    }
    public Attendence isPounchIn(Attendence attendence){
        return  attendenceMapper.isPounchIn(attendence);
    }
    public Attendence isPounchOut(Attendence attendence){
        return attendenceMapper.isPounchOut(attendence);
    }
    public int setLate(Attendence attendence){
         return  attendenceMapper.setLate(attendence);
    }
    public int setAbsence(Attendence attendence){
         return  attendenceMapper.setAbsence(attendence);
    }
    public List<Attendence> selectAttendence(){return  attendenceMapper.selectAttendence();}
}

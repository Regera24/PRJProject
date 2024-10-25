package com.example.regera.Service.Impl;

import com.example.regera.Converter.CvDTOConverter;
import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Repository.ApplyJobRepository;
import com.example.regera.Repository.CvRepository;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.Entity.applyJobEntity;
import com.example.regera.Service.ApplyJobService;
import com.example.regera.Service.CvService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private CvDTOConverter cvDTOConverter;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CvDTO> getAllCv() {
        List<CvDTO> listCvDTO = new ArrayList<>();
        for(CvEntity cvEntity : cvRepository.findAll()){
            listCvDTO.add(cvDTOConverter.toCvDTO(cvEntity));
        }
        return listCvDTO;
    }

    @Override
    public List<CvDTO> getCvByJobId(Integer jobId) {
        List<CvDTO> listCvDTO = new ArrayList<>();
        for(CvEntity cvEntity : cvRepository.findAll()){
            for(applyJobEntity aj : cvEntity.getApplyJobEntities()){
                if(aj.getJob().getId()==jobId){
                    listCvDTO.add(cvDTOConverter.toCvDTO(cvEntity));
                }
            }
        }
        return listCvDTO;
    }

    @Override
    public List<CvDTO> getCvByUserId(Integer userId) {
        List<CvDTO> listCvDTO = new ArrayList<>();
        for(CvEntity cvEntity : cvRepository.findAll()){
            if(cvEntity.getCandidate().getId()==userId){
                listCvDTO.add(cvDTOConverter.toCvDTO(cvEntity));
            }
        }
        return listCvDTO;
    }

    @Override
    public void addCv(CvEntity cv) {
        cvRepository.save(cv);
    }

    @Override
    public CvDTO getCvById(Integer id) {
        CvEntity cv = cvRepository.findById(id).get();
        return cvDTOConverter.toCvDTO(cv);
    }

    @Override
    public void updateCv(CvDTO cv, int id) {
        CvEntity cvEntity = cvRepository.findById(id).get();
        CvEntity newCV = modelMapper.map(cv, CvEntity.class);
            try{
                Field[] fields = cvEntity.getClass().getDeclaredFields();
                for(Field field : fields){
                    field.setAccessible(true);
                    if(field.get(newCV)!=null){
                        field.set(cvEntity,field.get(newCV));
                    }
                }
                cvRepository.save(cvEntity);
            }catch(Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void deleteCv(Integer id) {
        CvEntity cv = cvRepository.findById(id).get();
        List<applyJobEntity> applyJobEntities = applyJobRepository.findByCv(cv);
        applyJobRepository.deleteAll(applyJobEntities);
        cvRepository.deleteById(id);
    }
}

package com.sbhysf.ppmtool.services.impl;

import com.sbhysf.ppmtool.domain.Project;
import com.sbhysf.ppmtool.repositories.ProjectRepository;
import com.sbhysf.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {

        //Error handling
        return projectRepository.save(project);
    }
}

package com.sbhysf.ppmtool.services.impl;

import com.sbhysf.ppmtool.domain.Project;
import com.sbhysf.ppmtool.exceptions.ProjectIdException;
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
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project Id " + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }

    @Override
    public Project findProjectByProjectIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if (project == null)
            throw new ProjectIdException("Project Id " + projectIdentifier.toUpperCase() + " not found");

        return projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
    }


}

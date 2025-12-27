package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Module;

@Service
public class ModuleServiceImpl implements ModuleService {

    private List<Module> moduleList = new ArrayList<>();

    @Override
    public Module addModule(Module module) {
        moduleList.add(module);
        return module;
    }

    @Override
    public List<Module> getAllModules() {
        return moduleList;
    }
}

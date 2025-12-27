package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Module;

public interface ModuleService {

    Module addModule(Module module);

    List<Module> getAllModules();
}

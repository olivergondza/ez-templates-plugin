package com.joelj.jenkins.eztemplates.exclusion;

import com.joelj.jenkins.eztemplates.utils.ReflectionUtils;
import hudson.model.AbstractProject;

public class DisabledExclusion extends HardCodedExclusion {
    private boolean disabled;

    @Override
    public String getId() {
        return "disabled";
    }

    @Override
    public String getDescription() {
        return "Retain local disabled setting";
    }

    @Override
    public void preClone(AbstractProject implementationProject) {
        disabled = implementationProject.isDisabled();
    }

    @Override
    public void postClone(AbstractProject implementationProject) {
        ReflectionUtils.setFieldValue(AbstractProject.class, implementationProject, "disabled", disabled);
    }

}
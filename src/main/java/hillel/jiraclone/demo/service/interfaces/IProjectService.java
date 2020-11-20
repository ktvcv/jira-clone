package hillel.jiraclone.demo.service.interfaces;

import hillel.jiraclone.demo.persistence.common.ICommonDao;
import hillel.jiraclone.demo.persistence.common.ICommonService;
import hillel.jiraclone.demo.persistence.entity.Project;

public interface IProjectService extends ICommonService<Project, Integer> {
}

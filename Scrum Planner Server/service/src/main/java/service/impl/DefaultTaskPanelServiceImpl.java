package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TaskPanelDao;
import model.planner.taskboard.TaskPanel;
import service.TaskPanelService;
import service.exception.ServiceException;

/**
 * Default implementation of the TaskPanelService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskPanelServiceImpl implements TaskPanelService {
    @Autowired
    private TaskPanelDao taskPanelDao;

    @Override
    public TaskPanel getTaskPanel(Integer id) throws ServiceException {
        return null;
    }

    @Override
    public void insertTaskPanel(TaskPanel taskPanel) throws ServiceException {

    }

    @Override
    public void updateTaskPanel(TaskPanel taskPanel) throws ServiceException {

    }

    @Override
    public void deleteTaskPanel(TaskPanel taskPanel) throws ServiceException {

    }
}

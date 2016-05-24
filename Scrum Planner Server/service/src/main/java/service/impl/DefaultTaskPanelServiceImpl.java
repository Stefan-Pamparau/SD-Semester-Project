package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TaskPanelDao;
import dao.exception.DaoException;
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
        try {
            return taskPanelDao.getTaskPanel(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertTaskPanel(TaskPanel taskPanel) throws ServiceException {
        try {
            taskPanelDao.insertTaskPanel(taskPanel);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateTaskPanel(TaskPanel taskPanel) throws ServiceException {
        try {
            taskPanelDao.updateTaskPanel(taskPanel);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteTaskPanel(TaskPanel taskPanel) throws ServiceException {
        try {
            taskPanelDao.deleteTaskPanel(taskPanel);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}

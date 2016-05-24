package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TaskCardDao;
import dao.exception.DaoException;
import model.planner.card.TaskCard;
import service.TaskCardService;
import service.exception.ServiceException;

/**
 * Default implementation of the TaskCardService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskCardServiceImpl implements TaskCardService {
    @Autowired
    private TaskCardDao taskCardDao;

    @Override
    public TaskCard getTaskCard(Integer id) throws ServiceException {
        try {
            return taskCardDao.getTaskCard(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertTaskCard(TaskCard taskCard) throws ServiceException {
        try {
            taskCardDao.insertTaskCard(taskCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateTaskCard(TaskCard taskCard) throws ServiceException {
        try {
            taskCardDao.updateTaskCard(taskCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteTaskCard(TaskCard taskCard) throws ServiceException {
        try {
            taskCardDao.deleteTaskCard(taskCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}

package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TaskCardDao;
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
        return null;
    }

    @Override
    public void insertTaskCard(TaskCard taskCard) throws ServiceException {

    }

    @Override
    public void updateTaskCard(TaskCard taskCard) throws ServiceException {

    }

    @Override
    public void deleteTaskCard(TaskCard taskCard) throws ServiceException {

    }
}

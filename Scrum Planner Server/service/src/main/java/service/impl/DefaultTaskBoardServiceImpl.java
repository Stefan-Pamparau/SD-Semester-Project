package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TaskBoardDao;
import dao.exception.DaoException;
import model.planner.taskboard.TaskBoard;
import service.TaskBoardService;
import service.exception.ServiceException;

/**
 * Default implementation of the TaskBoardService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskBoardServiceImpl implements TaskBoardService {
    @Autowired
    private TaskBoardDao taskBoardDao;

    @Override
    public TaskBoard getTaskBoard(Integer id) throws ServiceException {
        try {
            return taskBoardDao.getTaskBoard(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertTaskBoard(TaskBoard taskBoard) throws ServiceException {
        try {
            taskBoardDao.insertTaskBoard(taskBoard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateTaskBoard(TaskBoard taskBoard) throws ServiceException {
        try {
            taskBoardDao.updateTaskBoard(taskBoard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteTaskBoard(TaskBoard taskBoard) throws ServiceException {
        try {
            taskBoardDao.deleteTaskBoard(taskBoard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public TaskBoardDao getTaskBoardDao() {
        return taskBoardDao;
    }

    public void setTaskBoardDao(TaskBoardDao taskBoardDao) {
        this.taskBoardDao = taskBoardDao;
    }
}

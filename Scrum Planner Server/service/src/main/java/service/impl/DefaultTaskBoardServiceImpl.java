package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

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
    private TaskBoardService taskBoardService;

    @Override
    public TaskBoard getTaskBoard(Integer id) throws ServiceException {
        return null;
    }

    @Override
    public void insertTaskBoard(TaskBoard taskBoard) throws ServiceException {

    }

    @Override
    public void updateTaskBoard(TaskBoard taskBoard) throws ServiceException {

    }

    @Override
    public void deleteTaskBoard(TaskBoard taskBoard) throws ServiceException {

    }

    public TaskBoardService getTaskBoardService() {
        return taskBoardService;
    }

    public void setTaskBoardService(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }
}

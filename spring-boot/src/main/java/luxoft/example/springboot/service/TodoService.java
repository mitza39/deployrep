package luxoft.example.springboot.service;

import luxoft.example.springboot.bean.TodoBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<TodoBean> todoBeanList = new ArrayList<>();
    private static int todoCount = 3;

    static{
        todoBeanList.add(new TodoBean(1,"Jack", "Learn Spring MVC", new Date(), false));
        todoBeanList.add(new TodoBean(2,"Jack", "Learn Struts", new Date(), false));
        todoBeanList.add(new TodoBean(3,"Jill", "Learn Hibernate", new Date(), false));
    }

    public List<TodoBean> retrieveTodoBeans(String user) {
        List<TodoBean> filtederTodoBeans = new ArrayList<>();
        filtederTodoBeans = todoBeanList.stream().filter(todoBean -> todoBean.getUser().equals(user)).collect(Collectors.toList());
        return filtederTodoBeans;
    }

    public TodoBean addTodo(String name, String desc, Date targetDate, boolean isDone){
        TodoBean todoBean = new TodoBean(++todoCount, name, desc, targetDate, isDone);
        todoBeanList.add(todoBean);
        return todoBean;
    }

    public TodoBean retrieveTodo(int id){
        for(TodoBean todoBean : todoBeanList){
            if(todoBean.getId() == id){
                return todoBean;
            }
        }
        return null;
    }




}

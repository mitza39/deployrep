package luxoft.example.springboot.controller;

import luxoft.example.springboot.bean.TodoBean;
import luxoft.example.springboot.exceptions.TodoNotFoundException;
import luxoft.example.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{name}/todos")
    public List<TodoBean> retrieveTodos(@PathVariable String name){
        return todoService.retrieveTodoBeans(name);
    }

    @GetMapping("/users/{name}/todos/{id}")
    public TodoBean retrieveTodoBean(@PathVariable String name, @PathVariable int id){
        TodoBean todoBean =  todoService.retrieveTodo(id);
        if(todoBean == null){
            throw new TodoNotFoundException("Todo not found");
        }
        return todoBean;
    }

    @PostMapping("/users/{name}/todos")
    ResponseEntity<?> add(@PathVariable String name, @RequestBody TodoBean todo){
        TodoBean createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
        if(createdTodo == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("users/dummy-service")
    public TodoBean errorService(){
        throw new RuntimeException("Some Exception Occured");
    }
}

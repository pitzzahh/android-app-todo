package tech.araopj.backend.model;

import java.util.Objects;

public class Todo {

    private int id;

    private String todo;
    private String deadline;

    public Todo(String todo, String deadline) {
        this.todo = todo;
        this.deadline = deadline;
    }

    public Todo(int id, String todo, String deadline) {
        this.id = id;
        this.todo = todo;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo1 = (Todo) o;
        return id == todo1.id && Objects.equals(todo, todo1.todo) && Objects.equals(deadline, todo1.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, todo, deadline);
    }
}

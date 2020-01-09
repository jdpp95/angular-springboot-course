import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public isDone: boolean,
    public targetDate: Date)
  {

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos = []
  username = "jdpp95"
  errorMessage: string;
  constructor(
    private todoService: TodoDataService,
    private router: Router
    ) { }

  ngOnInit() {
    this.refreshTodos();
  }

  deleteTodo(id){
    this.todoService.deleteTodo(this.username, id).subscribe(
      response => {
        this.errorMessage = `Delete of Todo ${id} successful!!`;
        this.refreshTodos();
      }
    );
  }

  updateTodo(id){
    console.log("update " + id);
    this.router.navigate(['todos', id]);
  }

  addTodo(){
    this.router.navigate(['todos',-1])
  }

  refreshTodos(){
    this.todoService.retrieveAllTodos(this.username).subscribe(
      response => {
        this.todos = response
      }
    )
  }
}

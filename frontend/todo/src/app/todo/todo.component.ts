import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  private hardcodedUser = "jdpp95";
  id: number;
  todo: Todo;

  constructor(
    private todoService: TodoDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.todo = new Todo(this.id, '', false, new Date());

    if(this.id != -1){
      console.log("Update");
      this.todoService.retrieveTodo(this.hardcodedUser, this.id).subscribe(
        data => {
          this.todo = data;
        }
      );
    }

    console.log("todo: ");
    console.log(this.todo);
  }

  saveTodo(){
    if(this.id === -1) {
      this.todoService.createTodo(this.hardcodedUser, this.todo).subscribe(

      );
    } else {
      this.todoService.updateTodo(this.hardcodedUser, this.id, this.todo).subscribe(
        data => {
          this.router.navigate(['todos']);
        }
      );
    }
  }
}

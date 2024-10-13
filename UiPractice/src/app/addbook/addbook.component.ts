import { Component } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-addbook',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './addbook.component.html',
  styleUrl: './addbook.component.css'
})
export class AddbookComponent {

  constructor(private bookservice:BookserviceService, private router:Router){}

  title=new FormControl("",[])
  author=new FormControl("",[])
  genre=new FormControl("",[])
  price=new FormControl("",[])
  rating=new FormControl("",[])


  addForm=new FormGroup({

    title:this.title,
    author:this.author,
    genre:this.genre,
    price:this.price,
    rating:this.rating

  })

  statusMessage: string = '';
  addBookDetails(){
    if(this.addForm.valid){
      console.log(this.addForm)

      this.bookservice.saveBook(this.addForm.value).subscribe((response)=>{
       console.log(response)
       this.statusMessage=response.message
       if(this.statusMessage.includes('Details save succsesfully')){
         alert("Details save succsesfully")
         this.router.navigate(['/book'])

       }
      })

    }

  }





}

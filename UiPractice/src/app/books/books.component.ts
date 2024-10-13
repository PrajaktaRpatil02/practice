import { Component, OnInit } from '@angular/core';
import { BookserviceService } from '../bookservice.service';
import { Book } from '../user-response';
import { Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-books',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './books.component.html',
  styleUrl: './books.component.css'
})
export class BooksComponent implements OnInit{

  constructor(private bookservice:BookserviceService,private roter:Router){}

  bookList:Book[]=[]




  title=new FormControl("",[])
  author=new FormControl("",[])
  genre=new FormControl("",[])
  price=new FormControl(0,[])
  rating=new FormControl(0,[])


  addForm=new FormGroup({

    title:this.title,
    author:this.author,
    genre:this.genre,
    price:this.price,
    rating:this.rating

  })


ngOnInit(): void {
  this.bookservice.fetchAllBook().subscribe((response)=>{

    console.log(response)
    this.bookList=response.data

  })
    
}



deleteBook(book:any){
  this.bookservice.deleteBook(book.id).subscribe((response)=>{
    console.log(response)
    this.ngOnInit();

    })

}

adddetails(){
this.roter.navigate(['/add/book'])
}


updateformvisible=false
 bookid:any

openmodal(book:any){
  this.updateformvisible=true
  this.bookid=book.id

  this.addForm.patchValue({

    title:book.title,
     author:book.author,
     genre:book.genre,
     price: book.price !== null ? book.price : 0,
     rating: book.rating !== null ? book.rating : 0 

  })
}

closeModal(){
  this.updateformvisible=false
}


statusmessage:string=''
updateBook(){

  this.bookservice.updateBook(this.bookid,this.addForm.value).subscribe((response)=>{
    console.log(response)
    this.statusmessage=response.message
    if( this.statusmessage.includes("Data updated")){
      alert("Data updated")
      this.closeModal()
      this.ngOnInit();


    }

  })
    
}
}

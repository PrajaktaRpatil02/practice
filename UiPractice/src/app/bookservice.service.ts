import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookResponse, UpdateBookResponse } from './user-response';

@Injectable({
  providedIn: 'root'
})
export class BookserviceService {

  constructor(private httpclient:HttpClient) { }

 fetchAllBookUrl="/api"

 deleteBookUrl="/api"

 updateBookUrl="/api"

 saveBookUrl="/api"


 fetchAllBook():Observable<BookResponse>{
  let headers = new HttpHeaders({
    "Content-Type":"application/json"
  })

  return this.httpclient.get<BookResponse>(this.fetchAllBookUrl+ "/"+"get",{headers:headers});
 }


 deleteBook(id:any):Observable<UpdateBookResponse>{
  let headers = new HttpHeaders({
    "Content-Type":"application/json"
  })
return this.httpclient.delete<UpdateBookResponse>(this.deleteBookUrl+ "/"+"deletebook"+"/"+id,{headers:headers})
 }


 updateBook(id:any,book:any):Observable<UpdateBookResponse>{
  let headers = new HttpHeaders({
    "Content-Type":"application/json"
  })
  return this.httpclient.put<UpdateBookResponse>(this.updateBookUrl+ "/"+"updatebook"+"/"+id,book,{headers:headers})

 }


 saveBook(book:any):Observable<UpdateBookResponse>{
  let headers = new HttpHeaders({
    "Content-Type":"application/json"
  })
  return this.httpclient.post<UpdateBookResponse>(this.saveBookUrl+ "/"+"save",book,{headers:headers})

 }
}

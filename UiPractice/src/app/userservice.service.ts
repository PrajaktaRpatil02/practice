import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addressresponse, UpdateAddressResponse, UserResponse } from './user-response';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private httpclient:HttpClient) { }

  saveuserUrl="/api"
  fetchaddressurl="/api"
  deleteAddressUrl="/api"
  updateAddressUrl="/api"

  saveUserDetails(user:any):Observable<UserResponse>{
    let headers = new HttpHeaders({
      "Content-Type":"application/json"
    })
    return this.httpclient.post<UserResponse>(this.saveuserUrl+ "/"+"saveuser",user,{headers:headers})

  }


  fetchAddress():Observable<Addressresponse>{
    let headers = new HttpHeaders({
      "Content-Type":"application/json"
    })

    return this.httpclient.get<Addressresponse>(this.fetchaddressurl + "/"+"fetchall",{headers:headers});

  }

  deleteAddress(id:any):Observable<string>{

    let headers = new HttpHeaders({
      "Content-Type":"application/json"
    })
   return this.httpclient.delete<string>(this.deleteAddressUrl+ "/"+"delete"+"/"+id,{headers:headers})

  }


  updateAddress(id:any ,address:any):Observable<UpdateAddressResponse>{
    let headers = new HttpHeaders({
      "Content-Type":"application/json"
    })

    return this.httpclient.put<UpdateAddressResponse>(this.updateAddressUrl+ "/"+"update"+"/"+id,address,{headers:headers})
  }
}

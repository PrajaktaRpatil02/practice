import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  constructor(private userservice:UserserviceService,private router:Router){}

  username=new FormControl("",[])
  emailid=new FormControl("",[])
  password=new FormControl("",[])


registerForm=new FormGroup({
  username:this.username,
  emailId:this.emailid,
  password:this.password
})


register(){
  if(this.registerForm.valid){

    this.userservice.saveUserDetails(this.registerForm.value).subscribe((response)=>{
     console.log(response)
     this.registerForm.reset()

     if(response.message.includes("User details save successfully")){
         alert("User details save successfully")
         this.router.navigate([''])

     }
    })

  }
}



}

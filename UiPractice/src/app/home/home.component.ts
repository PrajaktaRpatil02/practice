import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../userservice.service';
import { Address } from '../user-response';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent  implements OnInit{

  constructor(private router:Router,private userservice:UserserviceService){}

  onclickRegister(){
    this.router.navigate(['/register'])
  }

  onclickBook(){
    this.router.navigate(['/book'])
  }

 
  addressList:Address[]=[]

  addressLine=new FormControl("",[])
  city=new FormControl("",[])
  pincode=new FormControl("",[])

editAddressForm=new FormGroup({
  addressLine:this.addressLine,
  city:this.city,
  pincode:this.pincode
})
editAddressFormvisible=false

addressid:any
modalVisible(address:any){

this.editAddressFormvisible=true;
this.addressid=address.id

console.log(address)
this.editAddressForm.patchValue({
  
  addressLine:address.addressLine,
  city:address.city,
 
  pincode:address.pincode
})

}

closeModal(){
  this.editAddressFormvisible=false;
}

statusMessage: string = '';
updateAddress(){
  this.userservice.updateAddress(this.addressid,this.editAddressForm.value).subscribe((response)=>{
   console.log(response)
    this.statusMessage=response.message
    if (response.message.includes("Data fetch")) { // Correct method is includes()
      alert("Data fetch");
      this.closeModal(); // Close the modal after successful data fetch
    }

  })

}









ngOnInit(): void {
    
  this.userservice.fetchAddress().subscribe((response)=>{
   this.addressList=response.data
   console.log(this.addressList)
  })
}

deleteAddress(address:any){
  if (confirm('Are you sure you want to delete this user?')) {
  this.userservice.deleteAddress(address.id).subscribe((response)=>{
    console.log(response)
    this.ngOnInit();
  })
  }

}
}
